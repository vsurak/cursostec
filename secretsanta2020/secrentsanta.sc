(
~tonadas = Array.new(4);

~labels = Array.new(~desc.size);

~tonadas.add(SimpleMIDIFile.read( "C:\\Users\\rodri\\OneDrive\\Electroacustica\\Library\\Patches\\Sc\\Amigo Secreto\\song_1.mid" ));
~tonadas.add(SimpleMIDIFile.read( "C:\\Users\\rodri\\OneDrive\\Electroacustica\\Library\\Patches\\Sc\\Amigo Secreto\\song_2.mid" ));
~tonadas.add(SimpleMIDIFile.read( "C:\\Users\\rodri\\OneDrive\\Electroacustica\\Library\\Patches\\Sc\\Amigo Secreto\\song_3.mid" ));
~tonadas.add(SimpleMIDIFile.read( "C:\\Users\\rodri\\OneDrive\\Electroacustica\\Library\\Patches\\Sc\\Amigo Secreto\\song.mid" ));

(
SynthDef( "organ", { |freq = 440, sustain = 1, amp = 0.1|
		var sig;
		sig = LFPar.ar( freq * [1,2,3,5], 0, amp/[2,4,5,7] );
		Out.ar( 0, Env([0,0.35,0.4,0], [0.025,sustain,0.025]).kr(2) * sig.dup )
}).add;
);

~textF = {
	arg index;
	if(index>=0, {
		a.string = a.string + ~name[index];
		~labels[index].string = ~desc[index];
	});
};


~pumpum = {
	arg speed=1.0, freqbase=220, letterindex=0;
	var sound;

	~textF.value(letterindex);
	{
	CombL.ar(LinPan2.ar(Impulse.kr(speed)*Klang.ar(`[[freqbase, (freqbase.cpsmidi+5).midicps, (freqbase.cpsmidi+8).midicps], [0.3, 0.2, 0.4], [pi, pi/2.3, pi]]), FSinOsc.kr(speed/4)), 0.05, 0.08, 0.7)+
	LinPan2.ar(Impulse.kr(speed)*Klang.ar(`[[freqbase, (freqbase.cpsmidi+5).midicps, (freqbase.cpsmidi+8).midicps], [0.2, 0.33, 0.21], [pi, pi/2.3, pi]]), FSinOsc.kr(speed/4))
	}.play;
};

~nubladobajo = {
	arg letterindex=0;
	~textF.value(letterindex);
	{Pan2.ar(PMOsc.ar(111, XLine.kr(220, 8, 25), 0.593411946, 0.1, mul:0.27),0)}.play;
};

~nubladoalto = {
	arg letterindex=0;
	~textF.value(letterindex);
	{Pan2.ar(PMOsc.ar(931, XLine.kr(45, 8, 15), 0.593412686, 0.1, mul:0.33),1)}.play;
};

~ranas={
	arg letterindex=0;
	~textF.value(letterindex);
	{LinPan2.ar(PMOsc.ar(755, 15, Line.ar(0,10,8), 0, 0.1), FSinOsc.kr(7))}.play;
};

~train = {
	arg letterindex=0;
	~textF.value(letterindex);
	{
		var steam, pan, time, e2, filter, we, whistle;
		time = 24;

		e2 = Env.new([-0.8, 0.8 ], [ time+2],'sine');
		we = Env.new([0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0], [2, 0, 0.2, 0, 0.2, 0, 0.8, 0, 4, 0, 3]);

		steam = WhiteNoise.ar(LFSaw.ar(XLine.ar(1, 7, time)))+PinkNoise.ar(LFSaw.ar(XLine.ar(1, 7, time)));
		filter = BPF.ar(steam, 600, 1+EnvGen.ar(Env.sine(time,9)));
		whistle = Mix.ar(Klank.ar(`[[800, 600, 1200, 990], nil, [0.7, 0.8, 0.74, 0.6]], WhiteNoise.ar(0.005)) * EnvGen.ar(we, timeScale:time/10.2 ));

		pan = Pan2.ar(filter+whistle, EnvGen.ar(e2, doneAction:2));
		pan}.play;
};

~playtonada = {
	arg songnumber, letterindex=0;
	~textF.value(letterindex);
	~tonadas[songnumber].p(\organ).play;
}

)


(
w = Window.new("Arreglo Sintético Navideño").front;
//w.background = Color.new255(red: 138.0, green: 54.0, blue: 48.0);
w.background = Color.new255(red: 162.0, green: 0.0, blue: 20.0);
w.bounds_(Rect(685,35,683,851));

a = StaticText(w, Rect(10, 10, 600, 80));
a.font = Font("Monaco", 48);
a.stringColor = Color.new255(red: 61, green: 153.0, blue: 50.0);
a.string = "";
a.align = \center;

~desc.size.do(
	{
		arg index;
		e = StaticText(w, Rect(10, 100+(60*index), 600, 40));
		e.font = Font("Monaco", 22);
		e.stringColor = Color.new255(red: 255.0, green: 255.0, blue: 255.0);
		e.string = "";
		e.align = \left;
		~labels.add(e);
	}
)


)


h=~ranas.value(-1);
i=~pumpum.value(1, 88, 0);
j=~pumpum.value(2, 335,1);
k=~pumpum.value(0.55, 9435,2);
~playtonada.value(3,3);
l=~nubladobajo.value(4);
~playtonada.value(0,5);
~playtonada.value(1,6);
~playtonada.value(1,-1);
~playtonada.value(2,7);
~playtonada.value(2,-1);
~train.value(8);

m=~nubladoalto.value(-1);
n=~nubladoalto.value(-1);
~playtonada.value(1,-1);
~playtonada.value(2,-1);

h.free;
i.free;
j.free;
k.free;
l.free;
m.free;
n.free;






























