package leetcode.removeDuplicates;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
 */

public class Solution {

    public static void main(String[] args) {
        Assertions.assertEquals(Integer.valueOf(1), removeDuplicatesTemp(new int[]{2,2}));
        Assertions.assertEquals(Integer.valueOf(1), removeDuplicatesTemp(new int[]{2,2,2,2}));
        Assertions.assertEquals(Integer.valueOf(4), removeDuplicatesTemp(new int[]{2,7,11,15}));
        Assertions.assertEquals(Integer.valueOf(4), removeDuplicatesTemp(new int[]{2,7,11,11,15,15,15}));
    }

    public static int removeDuplicatesTemp(int[] nums) {
        int i = 1;
        int j = 0;

        while (i < nums.length) {
            if (nums[i-1] != nums[i]){
                j++;
                nums[j] = nums[i];
            }
            i++;
        }

        System.out.println(Arrays.toString(nums));

        return ++j;
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] == 777) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 777;
                } else if (nums[j] == nums[j + 1]) {
                    nums[j + 1] = 777;
                    count++;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(nums.length - count);

        return nums.length - count;
    }

    public int removeDuplicates_BEST(int[] nums) {
        int j = 1;
        for(int i = 1; i < nums.length; i++) {
            if (!(nums[i - 1] == nums[i])){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}
