class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;

        for(int j = 1; j < nums.length; j++) {
            if(nums[index] != nums[j]) {
                index++;
                nums[index] = nums[j];
            }
        }
        
        return index+1;
    }
}

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] expectedNums = {0,1,2,3,4};

        Solution s = new Solution();
        int k = s.removeDuplicates(nums);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }

        System.out.println("k = " + k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}