package LeetCode;

import java.util.HashMap;

public class LC1122 {
    public static void main(String[] args) {
        int[] arr1 = {28,6,22,8,44,17};
        int[] arr2 = {22,28,8,6};
        System.out.println(relativeSortArray(arr1,arr2));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr2.length; i++){
            map.put(arr2[i], i);
        }
        for(int i = 0; i < arr1.length; i++){
            for(int j = arr1.length-1; j > i; j--){
                int x = map.getOrDefault(arr1[j], Integer.MAX_VALUE);
                int y = map.getOrDefault(arr1[j-1], Integer.MAX_VALUE);
                if(x < y){
                    int temp = arr1[j];
                    arr1[j] = arr1[j-1];
                    arr1[j-1] = temp;
                }
            }
        }
        return arr1;
    }
}
