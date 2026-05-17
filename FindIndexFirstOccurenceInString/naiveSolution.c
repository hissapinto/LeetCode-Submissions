int strStr(char* haystack, char* needle) {
    int i = 0;
    int len = strlen(needle);

    while(i < strlen(haystack)) {
        if(strlen(haystack)-i < len) { return -1;} //checa se o que sobra do haystack ainda é maior ou igual ao needle

        if(haystack[i] == needle[0] && haystack[i+len-1] == needle[len-1]) { //Checa último char tb

            for(int j = 0; j <= len; j++) { 

                if (j == strlen(needle)) { return i;} //Se j == len, passou do último char de needle
                if(needle[j] != haystack[i+j]){ break; }

            }

        }

        i++;
    }

    return -1;
}

#include <stdio.h>
#include <string.h>

int main() {
    char haystack[] = "leetcode";
    char needle[] = "leet";

    int result = strStr(haystack, needle);
    printf("%d\n", result);

    return 0;
}