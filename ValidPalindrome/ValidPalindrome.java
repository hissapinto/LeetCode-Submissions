package ValidPalindrome;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama")); // esperado: true
        System.out.println(s.isPalindrome("race a car"));                      // esperado: false
        System.out.println(s.isPalindrome(" "));                               // esperado: true
        System.out.println(s.isPalindrome("0P"));                              // esperado: false
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        int esq = 0, dir = s.length() - 1;

        while (esq <= dir) {
            while(!isAlpNum(s.charAt(esq)) && esq < dir) {
                esq++;
            }
            while (!isAlpNum(s.charAt(dir)) && esq < dir) {
                dir--;
            }

            if (Character.toLowerCase(s.charAt(esq)) == Character.toLowerCase(s.charAt(dir))) {
                esq++;
                dir--;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isAlpNum(char c) {
        return ('A' <= c && c <= 'Z' ||
                'a' <= c && c <= 'z' ||
                '0' <= c && c <= '9');
    }
}

//Funçao que checa se é alfanumerico
//Criar dois ponteiros, um para o inicio e um para o final
//while ponteiros nao se cruzam -> compara os chars
//Se char nao for do alfabeto, anda o ponteiro
//Se igual, anda os dois, se nao retorna false