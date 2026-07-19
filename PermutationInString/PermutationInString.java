package PermutationInString;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.checkInclusion("ab", "eidbaooo"));  // esperado: true
        System.out.println(s.checkInclusion("ab", "eidboaoo"));  // esperado: false
        System.out.println(s.checkInclusion("adc", "dcda"));     // esperado: true
        System.out.println(s.checkInclusion("abb", "ddc"));      // esperado: false
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        //Mapeia qtd dos chars em s1
        for (int i = 0; i < s1.length(); i++) {
            Character c = s1.charAt(i); 
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //Percorre s2 procurando s1
        for (int i = 0; i < s2.length(); i++) {
            Character c = s2.charAt(i);

            if (map.containsKey(c)) {   
                Map<Character, Integer> copy = new HashMap<>(map);

                copy.put(c, copy.get(c) - 1);
                int cont = s1.length() - 1;
                int index = i + 1;

                while (cont > 0 && index < s2.length()) {
                    Character next = s2.charAt(index);

                    if (!copy.containsKey(next)
                    || copy.get(next) <= 0) break;

                    copy.put(next, copy.get(next) - 1);
                    index++;
                    cont--;
                }

                if (cont == 0) return true;
            }
        }

        return false;
    }
}
