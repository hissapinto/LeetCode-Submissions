package ContainsDuplicate;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,3,4};

        Solution s = new Solution();
        System.out.println("\n\n");
        System.out.println(s.containsDuplicate(nums1)); // esperado: true
        System.out.println(s.containsDuplicate(nums2)); // esperado: false
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            } 
        }

        return false;
    }
}