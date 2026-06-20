package ValidAnagram;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.err.println("\n\n");
        System.out.println(s.isAnagram("anagram", "nagaram")); // esperado: true
        System.out.println(s.isAnagram("rat", "car")); // esperado: false
        System.out.println(s.isAnagram("aab", "abb")); // esperado: false
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { return false; }
        int len = t.length();

        //map palavra s
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) { //percorre palavra
            Character c = s.charAt(i);

            if (map.containsKey(c)) { //se ja tem o char, qtd +1
                int value = map.get(c) + 1;
                map.put(c,value);
            } else {
                map.put(c, 1); //Se nao, qtd = 1
            }
        }

        //map palavra t
        for (int i = 0; i < len; i++) {
            Character c = t.charAt(i);
            if (map.containsKey(c)) {
                int value = map.get(c) - 1;
                map.put(c,value);
                
                if (value < 0) { return false; }
            } else {
                return false;
            }
        }
        
        return true;
    }
}

//Mapear palavra 1 (char, qtd)
//Mapear palavra 2 (char, qtd)
//percorrer os maps e ver se sao iguais. ?
//Percorro uma palavra e comparo os maps nos chars. Se der a mesma qtd ate o final -> true 