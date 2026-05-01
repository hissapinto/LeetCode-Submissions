import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            Integer sum = Integer.valueOf(nums[i]);
            Integer soma = Integer.valueOf(target-nums[i]);

            if (map.get(soma) != null) {
                return new int[]{map.get(soma),i};
            }
            
            map.put(sum, i); //Depois para não checar o próprio elemento
        }
        return null;
    }
}

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.twoSum(nums, 6)));
    }
}