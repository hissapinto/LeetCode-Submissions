#include <stdio.h>

int searchInsert(int* nums, int numsSize, int target) {
    int left = 0;
    int right = numsSize - 1;


    while (left <= right) {
        int mid = left + (right - left)/2;

        if(nums[mid] == target) return mid;
        else if (nums[mid] < target) left = mid + 1; //Se num menor -> left vira o dps do mid, que ja foi verificado
        else right = mid -1; //Se num menor -> right vira o antes do mid
    }

    //Como saiu do loop, o num deveria estar entre left e right.
    //E left e right estao trocados (condição do loop), logo
    // o num deveria estar na posição de right, que agora é left
    return left;
}

int main() {
    int nums[] = {1,3,5,6};
    int numsSize = 4;

    printf("%d\n", searchInsert(nums, numsSize, 5)); // esperado: 2
    printf("%d\n", searchInsert(nums, numsSize, 2)); // esperado: 1
    printf("%d\n", searchInsert(nums, numsSize, 7)); // esperado: 4
    printf("%d\n", searchInsert(nums, numsSize, 0)); // esperado: 0

    return 0;
}