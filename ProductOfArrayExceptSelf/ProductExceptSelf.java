import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Pra compilar:
//javac ProductOfArrayExceptSelf/ProductExceptSelf.java && java -cp ProductOfArrayExceptSelf ProductExceptSelf

public class ProductExceptSelf {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] t1 = {1,2,3,4};
        int[] t2 = {-1,1,0,-3,3};
        int[] t3 = {1};

        System.out.println("=== productExceptSelf ===");
        System.out.println(Arrays.toString(s.productExceptSelf(t1)));  // [24,12,8,6]
        System.out.println(Arrays.toString(s.productExceptSelf(t2)));  // [0,0,9,0,0]
        System.out.println(Arrays.toString(s.productExceptSelf(t3)));  // [1]

        System.out.println("=== productExceptSelfImproved ===");
        System.out.println(Arrays.toString(s.productExceptSelfImproved(t1)));  // [24,12,8,6]
        System.out.println(Arrays.toString(s.productExceptSelfImproved(t2)));  // [0,0,9,0,0]
        System.out.println(Arrays.toString(s.productExceptSelfImproved(t3)));  // [1]

        System.out.println("=== productExceptSelfMemoryImproved ===");
        System.out.println(Arrays.toString(s.productExceptSelfMemoryImproved(t1)));  // [24,12,8,6]
        System.out.println(Arrays.toString(s.productExceptSelfMemoryImproved(t2)));  // [0,0,9,0,0]
        System.out.println(Arrays.toString(s.productExceptSelfMemoryImproved(t3)));  // [1]
    }
}

record Tupla(Integer pref, Integer suf) {}

class Solution {

    //Versão naive O(n), mas consome mais memória e tempo de acesso as variáveis
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1) {return nums;}
        Map<Integer, Tupla> map = new HashMap<>();

        //Preencher prefixo
        for(int i = 0; i < nums.length; i++) {
            if (i == 0) {
                Tupla t = new Tupla(1,1);
                map.put(i, t);
            } else {
                int v = map.get(i-1).pref();
                Tupla t = new Tupla(1*v*nums[i-1],1);
                map.put(i,t);
            }
        }

        //Preencher sufixo
        for(int j = nums.length-2; j>=0; j--){
            int v = map.get(j+1).suf(); //Valor suf do index anterior
            Tupla p = new Tupla(map.get(j).pref(), map.get(j).suf()*v*nums[j+1]); //multiplica suf pelo suf no i anterior e pelo num desse i anterior
            map.put(j,p); //salva
        }

        //Preencher resp
        int[] resp = new int[nums.length];
        for (Map.Entry<Integer, Tupla> entry : map.entrySet()) {
            resp[entry.getKey()] = entry.getValue().pref() * entry.getValue().suf();
        }

        return resp;
    }

    //Mesmo tempo O(n), mas com melhor performance por acessar vetores em vez de map e tupla
    public int[] productExceptSelfImproved(int[] nums) {
        int len = nums.length;
        if(len == 1) {return nums;}

        int[] pref = new int[len];
        int[] suf = new int[len];

        //Preencher prefixo
        for(int i = 0; i < len; i++) {
            if (i == 0) {
                pref[i] = 1;
            } else {
                int v = pref[i-1];
                pref[i] = v * nums[i-1];
            }
        }

        //Preencher sufixo
        for(int j = len-1; j>=0; j--){
            if (j == len-1) {
                suf[j] = 1;
            } else {
                int v = suf[j+1];
                suf[j] = v * nums[j+1];
            }
        }

        //Preencher resp
        int[] resp = new int[nums.length];
        for (int k = 0; k < len; k++) {
            resp[k] = pref[k] * suf[k];
        }

        return resp;
    }

    //Com performance O(1) extra space complexity
    public int[] productExceptSelfMemoryImproved(int[] nums) {
        int len = nums.length;
        int[] resp = new int[len];

        // Primeira passada: preenche resp com prefixos
        resp[0] = 1;
        for (int i = 1; i < len; i++) {
            resp[i] = resp[i-1] * nums[i-1];
        }

        // Segunda passada: multiplica pelos sufixos on the fly
        int suf = 1;
        for (int j = len-1; j >= 0; j--) {
            resp[j] *= suf;
            suf *= nums[j];
        }

    return resp;
    }
}