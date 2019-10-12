package LeetCode;

import java.util.HashMap;

public class LC1010 {
    public static void main(String[] args) {
        int[] time = {15,63,451,213,37,209,343,319};
        System.out.println(numPairsDivisibleBy60(time));
    }
    public static int numPairsDivisibleBy60(int[] time) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < time.length; i++){
            time[i] = time[i] % 60;
            map.put(time[i], map.getOrDefault(time[i], 0) + 1);
        }
        for(int i = 0; i < time.length; i++){
            if(time[i] == 0 || time[i] == 30) cnt += map.get(time[i]) - 1;
            else cnt += map.getOrDefault(60 - time[i],0);
            map.put(time[i], map.get(time[i]) - 1);
        }
        return cnt;
    }
}
