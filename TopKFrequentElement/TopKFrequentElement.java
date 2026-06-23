package TopKFrequentElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElement {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1,1,1,2,2,3}, 2))); // esperado: [1,2]
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1}, 1)));            // esperado: [1]
        System.out.println(Arrays.toString(s.topKFrequentBucket(new int[]{0,0,0,1,1,2}, 2))); // esperado: [0,1]
        System.out.println(Arrays.toString(s.topKFrequentBucket(new int[]{0,0,0,2,2,3,3,2,2,4,3,7,3,0,0,0,0}, 3)));
    }
}

class Solution {
    //O(n.k) -> naive
    public int[] topKFrequent(int[] nums, int k) {
        int[] resp = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int n : nums) {
            if(map.get(n) == null) {
                map.put(n, 1);
                list.add(n);
            } else {
                int aux = map.get(n) + 1;
                map.put(n, aux);
            }
        }

        for(int i = 0; i < k; i++) {
            int aux = 0;

            for(int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    resp[i] = list.get(0);
                    aux = list.get(0);
                }

                if (map.get(list.get(j)) > map.get(resp[i])) {
                    resp[i] = list.get(j);
                    aux = list.get(j);
                }
            }

            list.remove(Integer.valueOf(aux));
        }

        return resp;
    }


    //Versão com melhor O -> O(n)
    @SuppressWarnings("unchecked")
    public int[] topKFrequentBucket(int[] nums, int k) {
        int[] resp = new int[k];
        int index = 0;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        //Preencher map
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1); //Se já existir ++, se nao default(0) + 1
        }

        //Inicializar freq
        for(int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        //Percorrer map - entry retorna o par key e value - e preencher freq
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        //percorrer lista de tras pra frente e preencher o resp
        for(int j = freq.length - 1; j > 0; j--) {
            //É O(n) porque ainda percorre, no máximo, todos os elementos uma só vez
            for(int l = 0; l < freq[j].size(); l++) {
                resp[index] = freq[j].get(l);
                index++;
                if (index == k) {
                    return resp;
                }
            }
        }

        return resp;
    }
}