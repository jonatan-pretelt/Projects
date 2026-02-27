import java.util.Map;
import java.util.HashMap;

class Main{

    public static int nonRepeatingChar(String s){

        Map<Character, Integer> myChars = new HashMap<>(); 

        for(int i=0;i < s.length();i++){
           myChars.put(s.charAt(i),myChars.getOrDefault(s.charAt(i), 0) +1);
        }

        for(int i=0;i< s.length();i++){
            if (myChars.get(s.charAt(i))==1){
                return i;
            };
        }

        return -1;
    }
    public static void main(String[] args){
        //Given a string s, return the index of the first non-repeating character.
        //input: "leetcode" output: 0 //'l'

        // Input: "loveleetcode"  Output: 2   // 'v'

        //Input: "aabb" Output: -1

       System.out.println(nonRepeatingChar("leetcode")); 
       System.out.println(nonRepeatingChar("loveleetcode")); 
       System.out.println(nonRepeatingChar("aabb")); 

    }
}