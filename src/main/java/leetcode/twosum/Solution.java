package leetcode.twosum;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Assertions.assertTrue(Arrays.equals(new int[]{0,1}, twoSum(new int[]{2,7,11,15}, 9)));
        Assertions.assertTrue(Arrays.equals(new int[]{1,2}, twoSum(new int[]{3,2,4}, 6)));
        Assertions.assertTrue(Arrays.equals(new int[]{0,1}, twoSum(new int[]{3,3}, 6)));
        Assertions.assertTrue(Arrays.equals(new int[]{0,1}, twoSum(new int[]{3,3}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = target - a;
            List<Integer> intList = new ArrayList<Integer>(nums.length);
            for (int val : nums)
            {
                intList.add(val);
            }
            int j = intList.lastIndexOf(b);
            if (j != -1 && i != j){
                return new int[]{i,j};
            }
        }
        return null;
    }

}
