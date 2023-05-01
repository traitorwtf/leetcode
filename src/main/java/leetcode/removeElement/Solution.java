package leetcode.removeElement;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted. */

public class Solution {

    public static void main(String[] args) {
        Assertions.assertEquals(Integer.valueOf(2), removeElement(new int[]{2,2}, 0));
        Assertions.assertEquals(Integer.valueOf(0), removeElement(new int[]{2,2,2,2}, 2));
        Assertions.assertEquals(Integer.valueOf(3), removeElement(new int[]{2,7,11,15}, 11));
        Assertions.assertEquals(Integer.valueOf(5), removeElement(new int[]{2,7,11,11,15,15,15}, 11));
        Assertions.assertEquals(Integer.valueOf(8), removeElement(new int[]{2,7,11,11,15,15,15,11,20,20,20,11,11}, 11));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            if (nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
            i++;
//            System.out.println(Arrays.toString(nums));
        }

//        System.out.println(Arrays.toString(nums));

        return j;
    }

}
