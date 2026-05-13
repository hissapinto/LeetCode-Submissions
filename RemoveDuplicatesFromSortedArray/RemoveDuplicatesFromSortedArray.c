#include <stdlib.h>
#include <assert.h>
#include <stdio.h>

int removeDuplicates(int* nums, int numsSize) {
    int index = 0;
    int k = 0;
    int *aux = malloc(numsSize * sizeof(int));

    if (aux == NULL) {
        return -1;
    }

    for (int i = 0; i < numsSize; i++) {

        if (i == 0) {
            aux[index] = nums[i];
            k++;
        } else {
            if (nums[i] != aux[index]) {
                index++;
                aux[index] = nums[i];
                k++;
            }
        } 
    }

    for (int j = 0; j < numsSize; j++) {
        nums[j] = aux[j];
    }
    return k;
}

int main() {
    int nums[] = {0,0,1,1,1,2,2,3,3,4};
    int expectedNums[] = {0,1,2,3,4};
    int numsSize = 10;
    int expectedSize = 5;

    int k = removeDuplicates(nums, numsSize);

    assert(k == expectedSize);
    for (int i = 0; i < k; i++) {
        assert(nums[i] == expectedNums[i]);
    }

    for(int i = 0; i < 5; i++) {
        printf("\n%d", nums[i]);
    }

    printf("\n");
}