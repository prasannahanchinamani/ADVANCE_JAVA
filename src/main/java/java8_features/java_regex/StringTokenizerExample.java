package java8_features.java_regex;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {

        StringTokenizer str = new StringTokenizer("12-09-2025", "-");

        while (str.hasMoreTokens()) {
            System.out.println(str.nextToken());
        }
    }
}
