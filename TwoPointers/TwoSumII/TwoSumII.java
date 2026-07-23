package TwoSumII;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.twoSum(new int[]{2,7,11,15}, 9)));  // esperado: [1,2]
        System.out.println(Arrays.toString(s.twoSum(new int[]{2,3,4}, 6)));      // esperado: [1,3]
        System.out.println(Arrays.toString(s.twoSum(new int[]{-1,0}, -1)));      // esperado: [1,2]
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = numbers[left] + numbers[right]; 

        while (sum != target && left <= right) {
            if (sum > target) right--;
            else left++;

            sum = numbers[left] + numbers[right];
        }
        
        return new int[]{left + 1, right + 1}; 
    }
}

//Criar dois ponteiros, um para o inicio e outro para o final
//Enquanto os ponteiros nao se cruzam -> verificar a soma dos elementos no index dos ponteiros
//Se maior que target -> fim--
//Se menor -> inicio++
//Se exato -> novo array com inicio, e fim + 1