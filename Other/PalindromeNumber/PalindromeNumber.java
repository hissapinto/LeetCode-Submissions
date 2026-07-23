package PalindromeNumber;

class Solution {
    public boolean isPalindromeString(int x) {
        if (x < 0) { return false; }

        String s = String.valueOf(x);
        int size = s.length();

        for (int i = 0; i<(size/2); i++) {
            if (s.charAt(i) != s.charAt((size -1)-i)) {
                return false;
            }
        }  

        return true;      
    }

    //Inverte metade do num e compara
    public boolean isPalindrome(int x) {
        if (x < 0 || (x!=0 && x%10 == 0)){ return false; } //x neg e final de x == 0 quando x nao for zero

        int reverse = 0;

        while (x > reverse) {
            reverse = reverse*10 + x%10;
            x /= 10;
        }

                //se par       //se impar
        return (x == reverse || x == reverse/10);
        // se par compara metade do num, que é o que sobra de x, com a outra metade, que fica guardada no reverse
        //se impar o reverse acaba com um dígito a mais, o digito do meio, por isso ele é truncado para se comparar só a parte que repete
    }

    //Inverte todo o numero e compara
    public boolean isPalindromeFull(int x) {
        if (x < 0){ return false; } 

        int reverse = 0;
        int xcpy = x;

        while (xcpy > 0) {
            reverse = reverse*10 + xcpy%10;
            xcpy /= 10;
        }

        return (x == reverse);
    }
}


public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121;
        Solution s = new Solution();

        System.out.println("");
        System.out.println(s.isPalindromeFull(x));
        System.out.println(s.isPalindrome(10));
        System.out.println(s.isPalindromeString(-121));
    }
}
