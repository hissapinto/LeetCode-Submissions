package LongestCommonPrefix;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("\n\n\n" + s.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder r = new StringBuilder();
        boolean isEqual = true;

        if (strs.length == 1) { return strs[0]; }

        for(int j = 0; j < strs[0].length(); j++) { //j percorre char
            char temp = strs[0].charAt(j);

            for(int i = 1; i < strs.length; i++) { //i percorre array     
                if (j > strs[i].length() -1 || temp != strs[i].charAt(j)) {
                    isEqual = false;
                    break;
                }
            }

            if (!isEqual) {return r.toString();}
            r.append(temp);
        }

        return r.toString();
    }
}