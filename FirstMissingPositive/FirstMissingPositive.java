package FirstMissingPositive;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.firstMissingPositive(new int[]{1,2,0}));       // esperado: 3
        System.out.println(s.firstMissingPositive(new int[]{3,4,-1,1}));    // esperado: 2
        System.out.println(s.firstMissingPositive(new int[]{7,8,9,11,12})); // esperado: 1
        System.out.println(s.firstMissingPositive(new int[]{1}));            // esperado: 2
        System.out.println(s.firstMissingPositive(new int[]{1,2,3}));        // esperado: 4
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        //Remover negativos
        for(int i = 0; i < len; i++){
            if (nums[i] < 0) nums[i] = 0;
        }

        //Marcar nums existentes/flaguear
        for(int i = 0; i < len; i++){
            int val = Math.abs(nums[i]);
            if (val == len + 1) val = 0; // era um zero marcado
            int index = val - 1;

            if (index < len && index >= 0) {
                if (nums[index] == 0) nums[index] = - (len + 1);
                else if (nums[index] > 0) { nums[index] *= -1;} //Flag
            }
        }

        //Buscar resp
        for(int i = 1; i <= len ; i++) {
            if (nums[i-1] >= 0) return i;
        }
        
        return len + 1;
    }
}

//Marcar os negativos como 0, para serem irrelevantes
//A resposta esta entre 1 e len do array
//Usar o indice do array como set.
// Ou seja, marcar o numero presente no i como negativo para indicar se o valor de i existe no array
//No fim, percorrer de 1 até len, verificando pelo indice se o valor existe no array
//[3,4,-1,1] -> [-3,4,0,-1] -> como 4 +, nao tem o 2
//[1,2,3,4] -> que numeros os indices representam