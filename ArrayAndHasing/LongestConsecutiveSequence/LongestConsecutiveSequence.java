package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestConsecutive(new int[]{100,4,200,1,3,2}));    // esperado: 4
        System.out.println(s.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})); // esperado: 9
        System.out.println(s.longestConsecutive(new int[]{}));                     // esperado: 0
        System.out.println(s.longestConsecutive(new int[]{1}));                    // esperado: 1
        System.out.println(s.longestConsecutiveImproved(new int[]{2,7,5,3,4,8,9,1,1,0,5,13,74,97,2,6,37,7,10}));
    }
}

class Solution {

    //Tempo O(n)
    public int longestConsecutive(int[] nums) {
        //resp = 0 que recebe a maior sequencia
        //aux para contabilizar sequencia atual
        //booleano que indica se estou em uma sequencia ou nao
        int resp = 0;
        int aux = 0;
        int len = nums.length;
        boolean emSeq = false;

        //Mapear todos os numeros, sendo key - o numero
        Set <Integer> set = new HashSet<>();
        for (int j = 0; j < len; j++) {
            set.add(nums[j]);
        }

        //Percorrer no set pois nao tem duplicatas
        for(int key : set) {
            int prox = key + 1;
            if(!set.contains(key - 1)) { //Se nao tem predecessor = nova seq
                emSeq = true;
                aux = 1;
            }
            while(emSeq) { //É no máximo O(2n) = O(n)
                if(set.contains(prox)) {
                    aux++;
                    prox++;
                } else {
                    emSeq = false;
                }
            }
            if (aux > resp) {resp = aux;}
        }
 
        return resp;
    }

    //Sem variáveis e condições desnecessárias
    public int longestConsecutiveImproved(int[] nums) {
        int resp = 0;
        int len = nums.length;

        Set <Integer> set = new HashSet<>();
        for (int j = 0; j < len; j++) {
            set.add(nums[j]);
        }

        for(int key : set) {
            int prox = key + 1;

            if(!set.contains(key - 1)) {
                int aux = 1;
                while(set.contains(prox)) {
                    aux++;
                    prox++;
                }
                if (aux > resp) {resp = aux;}
            }
        }
 
        return resp;
    }
}

