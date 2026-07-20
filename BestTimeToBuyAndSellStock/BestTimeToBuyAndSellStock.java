package BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4})); // esperado: 5
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}));   // esperado: 0
        System.out.println(s.maxProfit(new int[]{4,2,1,7}));     // esperado: 6
        System.out.println(s.maxProfit(new int[]{1,2}));          // esperado: 1
        System.out.println(s.maxProfit(new int[]{2,1}));          // esperado: 0
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int l = 0;
        int r = 1;
        int resp = Math.max(0, prices[r] - prices[l]);

        while (r < prices.length) {
            if (r < prices.length - 1 && prices[l] > prices[r]) {
                l = r;
                r = l + 1;
                resp = Math.max(resp, prices[r] - prices[l]);
            } else {
                resp = Math.max(resp, prices[r] - prices[l]);
                r++;
            } 
        }

        return resp;
    }
}