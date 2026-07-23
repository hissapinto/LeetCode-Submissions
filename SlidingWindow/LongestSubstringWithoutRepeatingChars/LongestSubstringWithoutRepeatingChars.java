package LongestSubstringWithoutRepeatingChars;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLongestSubstring("abcabcbb")); // esperado: 3
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));    // esperado: 1
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));   // esperado: 3
        System.out.println(s.lengthOfLongestSubstring("abba"));     // esperado: 2
        System.out.println(s.lengthOfLongestSubstring(""));         // esperado: 0
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {return s.length();}

        int resp = 0;
        int l = 0;
        int r = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(l), 0); //Pra computar o primeiro char

        while (r < s.length()) {
            char c = s.charAt(r);

            //Se contem no mapa e o index que o ponteiro l precisa ir for na frente do valor atual dele
            if (map.containsKey(c) && map.get(c) + 1 > l) {
                l = map.get(c) + 1; //Anda pra frente da letra repetida
            }
            
            map.put(c, r); //Atualiza ou inclui o char
            resp = Math.max(resp, r - l + 1);
            r++;
        }

        return resp;        
    }
}