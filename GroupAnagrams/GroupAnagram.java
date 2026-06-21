package GroupAnagrams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram{
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("\n\n");
        System.out.println(s.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(s.groupAnagrams(new String[]{""}));
        System.out.println(s.groupAnagrams(new String[]{"a"}));
        System.out.println(s.groupAnagrams(new String[]{"a", "ab", "bolo", "ba", "casa", "saca", "lobo", "aaa", "bloo"}));
    }   
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int index = 0;

        List<List<String>> resposta = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>(); //string ordenada, index do arraylist

        //Percorre array strs
        for(String s : strs){
            //Ordenaçao
            char[] chars = s.toCharArray(); //Transforma string em array de chars
            Arrays.sort(chars);
            String key = new String(chars); //Volta a ser string

            //Se primeira ocorrencia
            if (map.get(key) == null) { 
                map.put(key,index); //Acrescenta no map
                List<String> word = new ArrayList<>(); //Cria novo list
                word.add(s); //Add palavra nele
                resposta.add(word); //Add list no list resposta
                index++;
            } else {
                Integer aux = map.get(key); //Pega index do resposta
                resposta.get(aux).add(s); //add palavra nele
            }
        }

        return resposta;
    }
}
