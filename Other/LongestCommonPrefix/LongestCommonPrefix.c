//Código eficiente que peguei do Leetcode
//Time: O(n)
//Space: O(1)

char* longestCommonPrefix(char** strs, int strsSize) {
    int a = 0, b = 0;
    
    // Handle basic edge cases
    if (strsSize == 0) return "";
    if (strsSize == 1) return strs[0];
    
    // 'b' tracks the character index we are currently checking in the first string
    while (strs[0][b] != '\0') {
        a = 1; // Start comparing from the second string
        
        // Loop through all other strings in the array
        while (a != strsSize) {
            // Stop if we hit the end of the current string 'a'
            if (strs[a][b] == '\0') {
                return strs[a];
            }
            
            // Stop if we find a character mismatch
            if (strs[a][b] != strs[0][b]) {
                // Truncate the first string exactly where the mismatch happened
                strs[0][b] = '\0';
                return strs[0];
            }
            a++; // Move to the next string
        }
        b++; // Move to the next character index
    }
    
    // If the loop finishes, the entire first string is the common prefix
    return strs[0];
}