package LeetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC989 {
    public static void main(String[] args){
        int[] words = {0};
        for(int temp: addToArrayForm(words, 10000))
        System.out.print(temp);
    }
    public  static List<Integer> addToArrayForm(int[] A, int K) {
        int i = A.length - 1;
        while(i >= 0 && K != 0){
            K += A[i];
            A[i] = K % 10;
            K = K / 10;
            i--;
        }
        List<Integer> res = new LinkedList<Integer>();
        if(K != 0){
            int temp = K % 10;
            res.add(temp);
            K = K / 10;
        }
        Collections.reverse(res);
        for(int tempint: A){
            res.add(tempint);
        }
        return res;
    }
}
