package tudelft.roman;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumeral {

    private static Map<Character, Integer> map;
    private static String romanRegExp =
            "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    private static Pattern romanPattern;

    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        romanPattern = Pattern.compile(romanRegExp);
    }

    public static int convert(String s) throws IllegalArgumentException {

        s = s.trim().toUpperCase();
        if(s == null || s.length() == 0 || !isRoman(s)) {
            throw new IllegalArgumentException("not a roman number");
        }

        int convertedNumber = 0;
        int i = 0, curr, next;
        // does not handle eroneous input
        // upper or lower case
        int n = s.length();
        while (i < n) {
            curr = map.get(s.charAt(i));
            if (i == (n - 1)) {
                convertedNumber += curr;
                i += 1;
            } else {
                next = map.get(s.charAt(i + 1));

                if (curr >= next) {
                    convertedNumber += curr;
                    i += 1;
                } else {
                    convertedNumber += (next - curr);
                    i += 2;
                }
            }
        }

        return convertedNumber;
    }

    private static boolean isRoman(String str) {
        Matcher matcher = romanPattern.matcher(str);
        return matcher.matches();
    }

    /*
        Delft implementation
     */
    public int convert2(String s) {

        int convertedNumber = 0;
        for(int i = 0; i < s.length(); i++) {
            int currentNumber = map.get(s.charAt(i));
            int next = i+1 < s.length() ? map.get(s.charAt(i+1)) : 0;

            if(currentNumber >= next)
                convertedNumber += currentNumber;
            else
                convertedNumber -= currentNumber;
        }

        return convertedNumber;

    }
}
