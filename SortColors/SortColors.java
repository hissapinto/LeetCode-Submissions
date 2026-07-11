package SortColors;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {2,0,2,1,1,0};
        s.sortColors(nums1);
        System.out.println(Arrays.toString(nums1)); // esperado: [0,0,1,1,2,2]

        int[] nums2 = {2,0,1};
        s.sortColors(nums2);
        System.out.println(Arrays.toString(nums2)); // esperado: [0,1,2]

        int[] nums3 = {0};
        s.sortColors(nums3);
        System.out.println(Arrays.toString(nums3)); // esperado: [0]
    }
}


class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[]{0,0,0};

        for(int n : nums) {
            count[n]++;
        }

        for(int i = 0; i < nums.length; i++) {
            if (count[0] > 0) {
                nums[i] = 0;
                count[0]--;
            }
            else if (count[1] > 0) {
                nums[i] = 1;
                count[1]--;
            }
            else {
                nums[i] = 2;
                count[2]--;
            }
        }
    }
}