package leetcode.arrays;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[] {5,1,10,13,9,2,8,4,7,12,20,18};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = array.length-1; j > i; j-- ) {
                if (array[j] < array [j-1]) {
                    int temp = array[j];
                    array[j] = array [j-1];
                    array [j-1] = temp;
                }
            }
        }
    }
}
