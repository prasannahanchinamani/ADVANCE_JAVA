package java8_features.java_regex;

import java.util.regex.*;

public class RegexDemo {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("ab");
        Matcher m = p.matcher("ababaaba");
        int count = 0;
        while (m.find()) {
            count++;
            System.out.print(m.start()+" "+(m.end()-1)+" "+m.group()+"");
        }
        System.out.println();
        System.out.println("How many pattern matcher find=:" + count);
    }
}
