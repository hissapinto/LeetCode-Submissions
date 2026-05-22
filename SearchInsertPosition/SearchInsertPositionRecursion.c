#include <stdio.h>

int searchInsert(int* nums, int numsSize, int target) {
    if (numsSize <= 1) {
        if(nums[0] < target) return 1; //se target maior -> soma um no indice
        else return 0;
    }

    int i_mid = numsSize/2 - 1; //Pega num do meio ou meio menor (trunca)

    if (nums[i_mid + 1] > target) {
        return (searchInsert(nums, numsSize/2, target));
    } else {
        //Retorna todos os indices pré essa chamada (i_mid + 1) + o resultado da chamada
        return (i_mid + 1 + searchInsert(nums + i_mid + 1, numsSize - i_mid - 1, target));
        //numsSize - i_mid - 1 pra remover a quantidade do lado esquerdo.
    }
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