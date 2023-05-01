package leetcode.arrays;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[] {5,1,10,13,9,2,8,4,7,12,20,18};
        System.out.println(Arrays.toString(array));
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }


    private static void selectionSort(int[] array){
        for (int i = 0; i < array.length; i++){
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
