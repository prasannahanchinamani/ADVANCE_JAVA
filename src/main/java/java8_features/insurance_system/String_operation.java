package java8_features.insurance_system;

import java.util.*;
import java.util.stream.Collectors;

public class String_operation {

    // Count frequency of each word
    public static Map<String, Long> map_count(String st) {
        return Arrays.stream(st.toLowerCase()
                        .replaceAll("[^a-z ]", "") // remove punctuation
                        .split("\\s+"))              // split by whitespace
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
    }

    // Top N frequent words
    public static void map_sort(String st, int N) {
        Map<String, Long> countFreq = map_count(st);

        List<Map.Entry<String, Long>> sortedBasedOnCount = countFreq.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(N)
                .toList();

        System.out.println("Top " + N + " words with their counts:");
        sortedBasedOnCount.forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }

    // Second most frequent word
    public static void top_2Words(String st) {
        Map<String, Long> count = map_count(st);

        List<Map.Entry<String, Long>> topWords = count.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .toList();

        if (topWords.size() >= 2) {
            Map.Entry<String, Long> second = topWords.get(1);
            System.out.println("Second most frequent word=  : " + second.getKey() + " : " + second.getValue());
        } else {
            System.out.println("Not enough words to find the second most frequent.");
        }
    }

    public static void main(String[] args) {
        String text = "Java is great. Java is powerful. Streams and lambda make Java great!";

        map_sort(text, 3);      // Top 3 words
        System.out.println();
        top_2Words(text);       // Second most frequent word
    }
}
