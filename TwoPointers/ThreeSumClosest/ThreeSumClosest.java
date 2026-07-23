package ThreeSumClosest;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.threeSumClosest(new int[]{-1,2,1,-4}, 1));  // esperado: 2
        System.out.println(s.threeSumClosest(new int[]{0,0,0}, 1));       // esperado: 0
        System.out.println(s.threeSumClosest(new int[]{1,1,1,0}, 100));   // esperado: 3
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int resp = nums[0] + nums[1] + nums[2]; //Primeira soma possivel

        Arrays.sort(nums); //ordena p fazer o 3sum

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1; //So checa o i pra frente, pra nao repetir combinacoes
            int r = nums.length - 1;
            
            while (l < r) {
                int sum = nums[r] + nums[l] + nums[i];
                if (sum == target) return sum; //early return

                if (Math.abs(target - resp) > Math.abs(target - sum)) resp = sum;
                if (sum > target) r--;
                else l++;
            }
        }

        return resp;
    }
}

//Ordenar vetor
//Varificar combinacoes com tres pointers, o fixo do for + l, r
//l = i + 1, pra evitar repetir combinacoes
//Comparar somatórios e substituir se a nova soma for menor
//Decrementar r se soma maior ou aumentar l se menor