package leetcode.searchInsert;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.


Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104 */

public class Solution {

    public static void main(String[] args) {
        Assertions.assertEquals(Integer.valueOf(0), searchInsertMy(new int[]{5}, 5));
        Assertions.assertEquals(Integer.valueOf(0), searchInsertMy(new int[]{2,2}, 1));
        Assertions.assertEquals(Integer.valueOf(1), searchInsertMy(new int[]{2,3,4,5}, 3));
        Assertions.assertEquals(Integer.valueOf(2), searchInsertMy(new int[]{2,7,11,15}, 9));
        Assertions.assertEquals(Integer.valueOf(7), searchInsertMy(new int[]{2,7,11,12,15,16,19}, 20));
    }

    public static int searchInsertMy(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int middle = (start + end)/2;
            if (target < nums[middle]){
                end = middle;
            } else if (target > nums[middle]) {
                start = middle + 1;
            } else {
                start = middle;
                break;
            }
        }
        return start;
    }

    public static int searchInsert(int[] nums, int target) {

        int low = 0, high = nums.length;
        while(low < high) {

            // Calculate middle index
            int mid = low + (high - low)/2;
            if(target > nums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    //not O(log n)
    public static int searchInsertBad(int[] nums, int target) {
        int i = 1;

        if (target <= nums[0]){
            return 0;
        }
        if (target > nums[nums.length - 1]){
            return nums.length;
        }

        while (i < nums.length) {
            if (nums[i] == target){
                break;
            }
            if (nums[i-1] < target && target < nums [i]){
                break;
            }
            i++;
        }

        return i;
    }
}
