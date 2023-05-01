import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = target - a;
            List<Integer> intList = new ArrayList<>(nums.length);
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

    public int reverse(int x) {
        boolean negative = x < 0;
        if (x == 0) return 0;
        ArrayList<Integer> result = new ArrayList<>();

        while(x != 0){
            int last_digit = Math.abs(x % 10);
            result.add(last_digit);
            x = x / 10;
        }
        String resString = result.stream().map(e -> e.toString()).reduce("", String::concat);
        int i;
        try {
            i = Integer.parseInt(resString);
        } catch (NumberFormatException ex){
            i = 0;
        }

        if (negative){
            i *= -1;
        }
        return i;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        ArrayList<Integer> result = new ArrayList<>();

        while(x != 0){
            int last_digit = Math.abs(x % 10);
            result.add(last_digit);
            x = x / 10;
        }
        int n = result.size() - 1;

        for (int i = 0; i < n; i++) {
            if (!result.get(i).equals(result.get(n))){
                return false;
            }
            n--;
        }
        return true;
    }

    public int myAtoi(String s) {
        String s1 = s.replaceAll(" ", "").toLowerCase();
        String result = "";

        char[] oldChars = s.toCharArray();
        char[] chars = s1.toCharArray();
        if (s.equals("")) return 0;
        if (!(Character.isDigit(chars[0]) || chars[0] == '-' || chars[0] == '+')) return 0;

        for (int i = 0; i < chars.length; i++){
            if (i == 0) {
                if ((chars[0] == '-' || chars[0] == '+') && oldChars[0] == ' ') break;

                result += chars[i];
                continue;
            }
            if (!Character.isDigit(chars[i])){
                break;
            }
            result += chars[i];
        }

        if (result.equals("-") || result.equals("+") || result.equals("")) return 0;

        long res = Long.parseLong(result);
        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;

        if (res > max) return Integer.MAX_VALUE;
        if (res < min) return Integer.MIN_VALUE;

        return (int) res;
    }

    public String longestCommonPrefix(String[] strs) {
        int j = 0;
        int loopCount = 0;
        while (loopCount < strs[0].length()) {
            for (int i = 0; i <= strs.length - 1; i++) {
                char charFirst = strs[0].charAt(j);
                if (j > strs[i].length() - 1){
                    break;
                }
                char currChar = strs[i].charAt(j);
                if (charFirst != currChar) {
                    break;
                }
                if (i == strs.length - 1) {
                    j++;
                }
            }
            loopCount++;
        }

        return strs[0].substring(0,j);

    }

}
