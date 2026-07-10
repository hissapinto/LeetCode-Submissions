package ThreeSum;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.threeSum(new int[]{-1,0,1,2,-1,-4})); // esperado: [[-1,-1,2],[-1,0,1]]
        System.out.println(s.threeSum(new int[]{0,1,1}));           // esperado: []
        System.out.println(s.threeSum(new int[]{0,0,0}));           // esperado: [[0,0,0]]
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
                    if (!result.contains(trio)) {
                        result.add(trio);
                    }
                    
                }
                else set.add(nums[j]);
            }

        }

        return result;
    }
}