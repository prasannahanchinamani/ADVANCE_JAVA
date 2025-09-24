package java8_features.java_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumberValidation {
    public static void main(String[] args) {
        // Correct regex for mobile number starting with 91 - so ^
        Pattern p = Pattern.compile("^91-[789][0-9]{9}$");
        Matcher m = p.matcher("91-8660103592");

        if (m.matches()) {
            System.out.println("Valid mobile number");
        } else {
            System.out.println("Invalid mobile number");
        }
    }
}
