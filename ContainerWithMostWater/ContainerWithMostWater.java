package ContainerWithMostWater;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // esperado: 49
        System.out.println(s.maxArea(new int[]{1,1}));                 // esperado: 1
        System.out.println(s.maxArea(new int[]{1,2,4,3}));             // esperado: 4
        System.out.println(s.maxArea(new int[]{4,3,2,1,4}));           // esperado: 16
    }
}

class Solution {
    public int maxArea(int[] height) {
        if (height.length == 2) return Math.min(height[0], height[1]);
        int resp = 0;

        for(int i = 0; i < height.length; i++) {
            int r = height.length - 1;
            int last = -1;

            while(height[i] >= height[r] || last <= height[i]) {
                int area = Math.min(height[i], height[r]) * (r-i);

                if(area > resp) {
                    resp = area;
                    last = height[r];
                } 
                if (height[i] == height[r]) break;
                r--;
            }

        }

        return resp;
    }
}