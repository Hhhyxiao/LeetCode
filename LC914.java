package LeetCode;

import java.util.Arrays;

public class LC914 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,2,3,4};
        System.out.println(hasGroupsSizeX(arr));
    }
    public static boolean hasGroupsSizeX(int[] deck) {
        Arrays.sort(deck);
        boolean flag = true;
        int pre = deck[0];
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < deck.length; i++){
            if(deck[i] != pre || i == deck.length - 1){
                if(flag){
                    if(deck[i] == pre) return help(deck.length);
                    count2 = count1;
                    count1 = 1;
                    pre = deck[i];
                    flag = false;
                }
                else{
                    if(deck[i] == pre) count1++;
                    count2 = fun(count2, count1);
                    if(count2 == 1) return false;
                    pre = deck[i];
                    count1 = 1;
                }
            }
            else count1++;
        }
        return true;
    }
    public static int fun(int m,int n){
        int rem;
        while(n > 0){
            rem = m % n;
            m = n;
            n = rem;
        }
        return m;			//将结果返回
    }
    public static boolean help(int n){
        if(n < 3) return false;
        for(int i = 2; i <= Math.sqrt(n); i ++){
            if(n % i == 0) return true;
        }
        return false;
    }
}
