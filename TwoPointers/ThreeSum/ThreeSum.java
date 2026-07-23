package ThreeSum;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.threeSum(new int[]{-1,0,1,2,-1,-4})); // esperado: [[-1,-1,2],[-1,0,1]]
        System.out.println(s.threeSum(new int[]{0,1,1}));           // esperado: []
        System.out.println(s.threeSum(new int[]{0,0,0}));           // esperado: [[0,0,0]]
        System.out.println(s.threeSumOpt(new int[]{-2,8,1,-3,4,-2,2,0,0,0,0,-3,-5,7,-1,-1}));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            Set<Integer> set = new HashSet<>();
            int target = nums[i] * -1;

            for (int j = i + 1; j < len; j++){
                int soma = target - nums[j];
                if (set.contains(soma)) {
                    List<Integer> trio = Arrays.asList(nums[i], nums[j], soma);
                    Collections.sort(trio);
                    if (!result.contains(trio)) { //Quebra o tempo no leetcode (n3)
                        result.add(trio);
                    }
                    
                }
                else set.add(nums[j]);
            }

        }

        return result;
    }

    public List<List<Integer>> threeSumOpt(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            //Vira Two sum ordenado
            int target = nums[i] * -1;
            int p1 = i + 1;
            int p2 = len - 1;

            if (nums[i] > 0) break; //Se inicia com + não tem como somar 0
            if (i > 0 && nums[i] == nums[i-1]) { //Evita duplicata -> pula primeiro num igual
                    continue;
            }

            while(p1 < p2) {
                if (nums[i] + nums[p1] + nums[p2] == 0) {
                    List<Integer> trio = Arrays.asList(nums[i], nums[p1], nums[p2]);
                    result.add(trio);
                    p1++;
                    p2--;
                    while(p1 < p2 && nums[p1] == nums[p1 - 1]) {//Evita duplicata -> pula segundo num igual
                        p1++;
                    }
                } else {
                    if(nums[p1] + nums[p2] > target) p2--;
                    else p1++;
                }

                
            }
        }

        return result;
    }
}

