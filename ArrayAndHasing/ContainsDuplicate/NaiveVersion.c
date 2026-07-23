#include <stdio.h>
#include <stdbool.h>

// Não passa nmo tempo do leetcode quando o array é muito grande O(nˆ2)

bool containsDuplicate(int* nums, int numsSize) {
    int index = 1;

    for (int i = 0; i < numsSize - 1; i++) {
        for(int j = index; j < numsSize; j++) {

            if (nums[i] == nums[j]) {
                return true;
                }
            else if (j == numsSize - 1) {
                index++;
            }
        }
    }

    return false;
}

int main() {
    int nums1[] = {1,2,3,1};
    int nums2[] = {1,2,3,4};
    int nums3[] = {1,1,1,3,3,4,3,2,4,2};

    printf("%d\n", containsDuplicate(nums1, 4)); // esperado: 1 (true)
    printf("%d\n", containsDuplicate(nums2, 4)); // esperado: 0 (false)
    printf("%d\n", containsDuplicate(nums3, 10)); // esperado: 1 (true)

    return 0;
}