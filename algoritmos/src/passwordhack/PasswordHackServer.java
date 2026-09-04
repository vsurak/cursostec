package passwordhack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Console TCP server on port 4000.
 * Client sends: {"password": "xxx"}  (xxx = 2 to 4 lowercase letters)
 * Server replies with a JSON message and, on a correct guess, rolls a new password.
 */
public class PasswordHackServer {

    private static final int PORT = 4000;
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 4;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Pattern PASSWORD_FIELD =
            Pattern.compile("\"password\"\\s*:\\s*\"([a-z]{0,10})\"", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_GUESS = Pattern.compile("^[a-z]{2,4}$");

    private volatile String currentPassword;
`
    public static void main(String[] args) throws IOException {
        new PasswordHackServer().start();
    }

    private void start() throws IOException {
        rollNewPassword();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("PasswordHack server listening on port " + PORT);

            while (true) {
                Socket client = serverSocket.accept();
                new Thread(() -> handleClient(client)).start();
            }
        }
    }

    private void handleClient(Socket client) {
        try (client;
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true, StandardCharsets.UTF_8)) {

            String line;
            while ((line = in.readLine()) != null) {
                out.println(handleMessage(line));
            }
        } catch (IOException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    private String handleMessage(String rawMessage) {
        Matcher matcher = PASSWORD_FIELD.matcher(rawMessage);
        if (!matcher.find()) {
            return "{\"status\":\"ERROR\",\"message\":\"expected JSON message like {\\\"password\\\": \\\"xxx\\\"}\"}";
        }

        String guess = matcher.group(1).toLowerCase();
        if (!VALID_GUESS.matcher(guess).matches()) {
            return "{\"status\":\"ERROR\",\"message\":\"password must be 2 to 4 lowercase letters\"}";
        }

        String password = currentPassword;

        if (guess.equals(password)) {
            rollNewPassword();
            return "{\"status\":\"SUCCESS\"}";
        }

        int matched = countPositionalMatches(guess, password);
        int distance = levenshteinDistance(guess, password);
        int score = computeScore(matched, distance);

        return String.format(
                "{\"status\":\"FAIL\",\"matchedLetters\":%d,\"distance\":%d,\"score\":%d}",
                matched, distance, score);
    }

    private void rollNewPassword() {
        Random random = ThreadLocalRandom.current();
        int length = MIN_LENGTH + random.nextInt(MAX_LENGTH - MIN_LENGTH + 1);
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        currentPassword = builder.toString();
        System.out.println("New password generated: " + currentPassword);
    }

    private int countPositionalMatches(String guess, String password) {
        int matches = 0;
        int limit = Math.min(guess.length(), password.length());
        for (int i = 0; i < limit; i++) {
            if (guess.charAt(i) == password.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }

    private int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= b.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int cost = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + cost);
            }
        }

        return dp[a.length()][b.length()];
    }

    private int computeScore(int matchedLetters, int distance) {
        int score = matchedLetters * 10 - distance * 5;
        return Math.max(score, 0);
    }
}
