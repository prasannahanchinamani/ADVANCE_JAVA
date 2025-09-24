package java8_features.java_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Qualifier_check {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("a+");
//        a = one time
//        a* = many time including 0 also
//        a+= atleast one time
//        a? = atmost one time
        Matcher m = p.matcher("abaababaaa");
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println(m.start() + "------------- " + m.group());
        }
        System.out.println();
        System.out.println("How many pattern matcher find=:" + count);
    }
}
