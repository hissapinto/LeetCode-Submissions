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
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{0,0,0,1,1,2}, 2))); // esperado: [0,1]
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
}