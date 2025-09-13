package java8_features.java_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidation {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^[a-zA-z][a-zA-Z0-9_.]*@gmail[.]com$");
        Matcher m = p.matcher("prasannahanchinamani.15@gmail.com");

        if (m.matches()) {
            System.out.println("is valid email");
        } else {
            System.out.println("Invalid email");
        }
    }
}
