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

        int[] nums4 = {1,0,1};
        s.sortColorsThreePonters(nums4);
        System.out.println(Arrays.toString(nums4)); // esperado: [0,1,1]

        int[] nums5 = {1,2,2,2,2,0,0,0,1,1};
        s.sortColorsThreePonters(nums5);
        System.out.println(Arrays.toString(nums5)); // esperado: [0,0,0,1,1,1,2,2,2,2]
    }
}


class Solution {

    //Realiza bucket sort -> calcula quantidades de cada num (0, 1 e 2), contanto num array
    // e depois atualiza o vetor nums
    //Duas passadas no vetor
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


    //Tres ponteiros, l , r e i
    //l - de onde ele está pra trás só tem zeros
    //r - de onde ele esta pra frente só tem 2
    //i - anda procurando 0 ou 2 para trocar, se for 1 ignora e anda tb (1s ficam no meio)
    //quando o i trocar de lugar com o 2 ainda precisa ficar no mesmo lugar,
    // pois precisa verificar se o novo numero é um zero
    //Uma passada no vetor
    public void sortColorsThreePonters(int[] nums) {
        int l = 0;
        int i = 0;
        int r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}