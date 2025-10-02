package ex4;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

public class WordAnalytics {
    // 4a/4b/4c skal bruge delimiteren [^A-ZÆØÅa-zæøå]+ og ignorere store/små bogstaver.
    private static final Pattern DELIM_DA = Pattern.compile("[^A-ZÆØÅa-zæøå]+");

    private static final String INPUT_PATH = "src/ex4/Gjoengehoevdingen.txt";

    public static void main(String[] args) throws IOException {
        File f = new File(INPUT_PATH);
        if (!f.exists()) {
            System.err.println("Kan ikke finde filen: " + f.getAbsolutePath());
            System.err.println("Læg Gjoengehoevdingen.txt i src/ eller opdatér INPUT_PATH.");
            System.exit(1);
        }

        System.out.println("=== Exercise 4a ===");
        Result4a r4a = exercise4a(f);
        System.out.println("Total number of words (incl. duplicates): " + r4a.totalWords);
        System.out.println("Number of different words: " + r4a.uniqueWords.size());
        // for at se alle ord, udkommentere næste linje:
        // System.out.println(r4a.uniqueWords);

        System.out.println("\n=== Exercise 4b ===");
        Result4b r4b = exercise4b(f);
        boolean any1000 = false;
        for (Map.Entry<String, Integer> e : r4b.counts.entrySet()) {
            if (e.getValue() >= 1000) {
                System.out.println(e.getKey() + " -> " + e.getValue());
                any1000 = true;
            }
        }
        if (!any1000) System.out.println("(none)");
        System.out.println("Total number of words (incl. duplicates): " + r4b.totalWords);
        System.out.println("Number of different words: " + r4b.counts.size());

        System.out.println("\n(Top 25 by frequency preview)");
        r4b.printTopN(25);

        System.out.println("\n=== Exercise 4c ===");
        Map<Integer, Set<String>> collisions = exercise4c(f);
        boolean printed = false;
        for (Map.Entry<Integer, Set<String>> e : collisions.entrySet()) {
            if (e.getValue().size() > 1) {
                System.out.println(e.getKey() + " -> " + e.getValue());
                printed = true;
            }
        }
        if (!printed) System.out.println("(no collisions found in this text)");
    }

    // ---------- 4a ----------
    private static Result4a exercise4a(File file) throws IOException {
        Set<String> unique = new TreeSet<>();
        long total = 0;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8)) {
            sc.useDelimiter(DELIM_DA);
            while (sc.hasNext()) {
                String w = sc.next().trim();
                if (!w.isEmpty()) {
                    total++;
                    unique.add(w.toLowerCase(Locale.ROOT));
                }
            }
        }
        return new Result4a(total, unique);
    }

    // ---------- 4b ----------
    private static Result4b exercise4b(File file) throws IOException {
        // TreeMap holder orden (alfabetisk)
        Map<String, Integer> counts = new TreeMap<>();
        long total = 0;

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8)) {
            sc.useDelimiter(DELIM_DA);
            while (sc.hasNext()) {
                String w = sc.next().trim();
                if (!w.isEmpty()) {
                    total++;
                    String key = w.toLowerCase(Locale.ROOT);
                    counts.merge(key, 1, Integer::sum);
                }
            }
        }
        return new Result4b(total, counts);
    }

    // ---------- 4c ----------
    private static Map<Integer, Set<String>> exercise4c(File file) throws IOException {
        // LinkedHashMap for at bevare indsætningsrækkefølge
        Map<Integer, Set<String>> map = new LinkedHashMap<>();

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8)) {
            sc.useDelimiter(DELIM_DA);
            while (sc.hasNext()) {
                String w = sc.next().trim();
                if (!w.isEmpty()) {
                    String word = w.toLowerCase(Locale.ROOT); // ignorer case som i 4a/4b
                    int h = word.hashCode(); // Java String.hashCode()
                    map.computeIfAbsent(h, k -> new LinkedHashSet<>()).add(word);
                }
            }
        }
        return map;
    }

    // ===== Små hjælper-typer til at holde resultater =====
    private static class Result4a {
        final long totalWords;
        final Set<String> uniqueWords;
        Result4a(long totalWords, Set<String> uniqueWords) {
            this.totalWords = totalWords;
            this.uniqueWords = uniqueWords;
        }
    }

    private static class Result4b {
        final long totalWords;
        final Map<String, Integer> counts;
        Result4b(long totalWords, Map<String, Integer> counts) {
            this.totalWords = totalWords;
            this.counts = counts;
        }
        void printTopN(int n) {
            // Sortér efter frekvens (desc), ved lighed alfabetisk
            List<Map.Entry<String, Integer>> list = new ArrayList<>(counts.entrySet());
            list.sort((a, b) -> {
                int c = Integer.compare(b.getValue(), a.getValue());
                return c != 0 ? c : a.getKey().compareTo(b.getKey());
            });
            int limit = Math.min(n, list.size());
            for (int i = 0; i < limit; i++) {
                Map.Entry<String, Integer> e = list.get(i);
                System.out.printf("%-20s %d%n", e.getKey(), e.getValue());
            }
        }
    }
}

