import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Minimal OSC client that plays the synths defined in myband.sc
 * (classicPiano, stringBass, organ70s) on a running scsynth.
 *
 * It talks directly to scsynth (default UDP 57110) using /s_new and /n_set,
 * so no OSC library is needed. Run ~myband.load in SuperCollider first.
 */
public class BandClient implements AutoCloseable {

    public static final String DEFAULT_HOST = "127.0.0.1";
    public static final int DEFAULT_PORT = 57110;

    private static final int ADD_TO_HEAD = 0;
    private static final int DEFAULT_GROUP = 1;
    private static final int FIRST_NODE_ID = 10000;

    private final DatagramSocket socket;
    private final InetAddress address;
    private final int port;

    private int nextNodeId = FIRST_NODE_ID;
    private final Map<Integer, Integer> activeOrgan = new HashMap<>(); // midi note -> node id

    public BandClient() throws IOException {
        this(DEFAULT_HOST, DEFAULT_PORT);
    }

    public BandClient(String host, int port) throws IOException {
        this.socket = new DatagramSocket();
        this.address = InetAddress.getByName(host);
        this.port = port;
    }

    // ------------------------------------------------------------ synth API

    /** Classic piano chord (major) built on the given fundamental MIDI note. */
    public void playPiano(int note, int durMs) throws IOException {
        playPiano(note, durMs, true);
    }

    /** Classic piano chord, major or minor, built on the given fundamental. */
    public void playPiano(int note, int durMs, boolean major) throws IOException {
        sNew("classicPiano",
                "note", note,
                "durMs", durMs,
                "third", major ? 4 : 3);
    }

    /** String bass note with a duration in milliseconds. */
    public void playBass(int note, int durMs) throws IOException {
        sNew("stringBass",
                "note", note,
                "durMs", durMs);
    }

    /** 70's organ with default partials (1, 2, 3) and amplitudes. */
    public void noteOn(int note) throws IOException {
        noteOn(note, new float[] { 1f, 2f, 3f }, new float[] { 1f, 0.5f, 0.25f });
    }

    /** 70's organ with 3 partial ratios and 3 partial amplitudes. Sounds until noteOff. */
    public void noteOn(int note, float[] ratios, float[] amps) throws IOException {
        if (ratios.length != 3 || amps.length != 3) {
            throw new IllegalArgumentException("organ needs exactly 3 ratios and 3 amps");
        }
        noteOff(note); // retrigger safely
        int id = sNew("organ70s",
                "freq", midiToFreq(note),
                "r1", ratios[0], "r2", ratios[1], "r3", ratios[2],
                "a1", amps[0], "a2", amps[1], "a3", amps[2]);
        activeOrgan.put(note, id);
    }

    public void noteOff(int note) throws IOException {
        Integer id = activeOrgan.remove(note);
        if (id != null) {
            send("/n_set", id, "gate", 0);
        }
    }

    public void allNotesOff() throws IOException {
        for (Integer note : activeOrgan.keySet().toArray(new Integer[0])) {
            noteOff(note);
        }
    }

    // ------------------------------------------------------------- helpers

    private static float midiToFreq(int note) {
        return (float) (440.0 * Math.pow(2.0, (note - 69) / 12.0));
    }

    /** Sends /s_new defName nodeId addAction target [name value ...]; returns the node id. */
    private int sNew(String defName, Object... controls) throws IOException {
        int id = nextNodeId++;
        Object[] args = new Object[4 + controls.length];
        args[0] = defName;
        args[1] = id;
        args[2] = ADD_TO_HEAD;
        args[3] = DEFAULT_GROUP;
        System.arraycopy(controls, 0, args, 4, controls.length);
        send("/s_new", args);
        return id;
    }

    /** Encodes and sends one OSC message. Supports Integer, Float and String arguments. */
    private void send(String path, Object... args) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        writeString(out, path);

        StringBuilder tags = new StringBuilder(",");
        for (Object a : args) {
            if (a instanceof Integer) tags.append('i');
            else if (a instanceof Float) tags.append('f');
            else if (a instanceof String) tags.append('s');
            else throw new IllegalArgumentException("unsupported OSC type: " + a.getClass());
        }
        writeString(out, tags.toString());

        for (Object a : args) {
            if (a instanceof Integer) writeInt(out, (Integer) a);
            else if (a instanceof Float) writeInt(out, Float.floatToIntBits((Float) a));
            else writeString(out, (String) a);
        }

        byte[] data = out.toByteArray();
        socket.send(new DatagramPacket(data, data.length, address, port));
    }

    private static void writeInt(ByteArrayOutputStream out, int v) {
        out.write(v >>> 24);
        out.write(v >>> 16);
        out.write(v >>> 8);
        out.write(v);
    }

    /** OSC string: bytes + null terminator, padded to a multiple of 4. */
    private static void writeString(ByteArrayOutputStream out, String s) {
        byte[] b = s.getBytes(StandardCharsets.US_ASCII);
        out.write(b, 0, b.length);
        int pad = 4 - (b.length % 4); // always adds at least the terminating null
        for (int i = 0; i < pad; i++) out.write(0);
    }

    @Override
    public void close() {
        try {
            allNotesOff();
        } catch (IOException ignored) {
        }
        socket.close();
    }

    // ---------------------------------------------------------------- test

    /**
     * Test: start SuperCollider, run ~myband.load; (server booted, synths added),
     * then run this main. Optional args: host port.
     */
    public static void main(String[] args) throws Exception {
        String host = args.length > 0 ? args[0] : DEFAULT_HOST;
        int port = args.length > 1 ? Integer.parseInt(args[1]) : DEFAULT_PORT;

        try (BandClient band = new BandClient(host, port)) {
            System.out.println("Connecting to scsynth at " + host + ":" + port);

            System.out.println("-- piano: C major, A minor, F major");
            band.playPiano(48, 1500);       Thread.sleep(1700);
            band.playPiano(57, 1500, false); Thread.sleep(1700);
            band.playPiano(53, 2000);       Thread.sleep(2300);

            System.out.println("-- string bass: C G A F");
            for (int n : new int[] { 36, 43, 45, 41 }) {
                band.playBass(n, 450);
                Thread.sleep(500);
            }
            Thread.sleep(500);

            System.out.println("-- organ 70s: noteOn / noteOff");
            band.noteOn(60);                                                    Thread.sleep(1500);
            band.noteOn(64, new float[] { 1f, 2.01f, 4f }, new float[] { 1f, 0.6f, 0.3f }); Thread.sleep(1500);
            band.noteOn(67, new float[] { 1f, 3f, 5f }, new float[] { 1f, 0.4f, 0.2f });    Thread.sleep(2000);
            band.noteOff(60);
            band.noteOff(64);
            band.noteOff(67);
            Thread.sleep(1000); // let the release tail finish

            System.out.println("Done.");
        }
    }
}
