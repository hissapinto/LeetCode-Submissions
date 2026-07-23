#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool isAnagram(char* s, char* t) {
    int lenS = strlen(s);
    int lenT = strlen(t);

    if (lenS != lenT) { return false; }

    int count[26] = {0}; //para alfabeto

    for (int i = 0; i < lenS; i++) {
        count[s[i] - 'a']++; //incrementa no indice letra s[i] - 'a', conta feito em ASCII.
        count[t[i] - 'a']--; //decrementa na segunda palavra
    }

    for (int i = 0; i < 26; i++) { //se tiver algum indice != 0 -> Nao é anagrama
        if (count[i] != 0) { return false; }
    }

    return true;
}

int main() {
    printf("%d\n", isAnagram("anagram", "nagaram")); // esperado: 1 (true)
    printf("%d\n", isAnagram("rat", "car"));          // esperado: 0 (false)
    printf("%d\n", isAnagram("aab", "abb"));           // esperado: 0 (false)

    return 0;
}