package BoatsToSavePeople;
import java.util.Arrays;

public class BoatsToSavePeople {
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numRescueBoats(new int[]{1,2}, 3));        // esperado: 1
        System.out.println(s.numRescueBoats(new int[]{3,2,2,1}, 3));    // esperado: 3
        System.out.println(s.numRescueBoats(new int[]{3,5,3,4}, 5));    // esperado: 4
    }
}

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        int l = 0;
        int r = people.length - 1;

        Arrays.sort(people);

        while (l <= r) {
            if (people[l] + people[r] <= limit) { //Se coube 2, anda o l
                l++;
            }
            //Se nao coube, manda o mais pesado (r), apenas
            boats++;
            r--;
        }

        return boats;
    }
}