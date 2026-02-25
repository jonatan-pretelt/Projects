import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Main {

    public static boolean checkAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String s1_sorted = new String(c1);
        String s2_sorted = new String(c2);
        return s1_sorted.equals(s2_sorted) ? true : false;

    }

    public static boolean checkAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> chars1 = new HashMap<Character, Integer>();
        Map<Character, Integer> chars2 = new HashMap<Character, Integer>();

        for (char c1 : s1.toCharArray()) {
            chars1.put(c1, chars1.getOrDefault(c1, 0) + 1);
        }

        for (char c2 : s2.toCharArray()) {
            chars2.put(c2, chars2.getOrDefault(c2, 0) + 1);
        }

        return chars1.equals(chars2) ? true: false;

    }

    public static void main(String[] args) {

        String s1 = "listen", t1 = "silent"; // true
        String s2 = "rat", t2 = "car"; // false
        String s3 = "onestring", t3 = "anotherstring"; // false

        System.out.println(checkAnagram(s1, t1));
        System.out.println(checkAnagram(s2, t2));
        System.out.println(checkAnagram(s3, t3));

        System.out.println("-----------------------------------");
        System.out.println(checkAnagram2(s1, t1));
        System.out.println(checkAnagram2(s2, t2));
        System.out.println(checkAnagram2(s3, t3));
        
      
       
    }
}