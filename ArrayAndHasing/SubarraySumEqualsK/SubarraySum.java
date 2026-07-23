package ArrayAndHasing.SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.subarraySum(new int[]{1,1,1}, 2));      // esperado: 2
        System.out.println(s.subarraySum(new int[]{1,2,3}, 3));      // esperado: 2
        System.out.println(s.subarraySum(new int[]{-1,-1,1}, 0));    // esperado: 1
        System.out.println(s.subarraySum(new int[]{1}, 0));           // esperado: 0
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int resp = 0;
        int currSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>(); //Criar map que guarda o prefix sum e freq

        //0 já começa com 1, pra contabilizar o subarray atual
        prefixSums.put(0,1);

        for(int n : nums) {
            currSum += n; //Calcula prefixo até aqui
            int c = currSum - k; //Complemento de k
            resp += prefixSums.getOrDefault(c, 0); //Acrescenta a qtd de prefixos(subarrays) possíveis
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1); //Add novo prefixo no mapa
        }

        return resp;
    }
}