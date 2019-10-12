package LeetCode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class LC5198 {
    public static void main(String[] args) {
        String s = "dcab";
        List<Integer> a = new LinkedList<Integer>();
        a.add(0);
        a.add(3);
        List<Integer> b = new LinkedList<Integer>();
        b.add(1);
        b.add(2);
        List<List<Integer>> c = new LinkedList<List<Integer>>();
        c.add(a);
        c.add(b);
        System.out.println(smallestStringWithSwaps(s,c));
    }
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] map = new int[s.length()];
        for(int i = 0; i < map.length; i++){
            map[i] = i;
        }
        char[] res = s.toCharArray();
        for(List<Integer> temp0: pairs){
            int[] temp = new int[2];
            int p = 0;
            for(Integer temp9: temp0){
                temp[p] = temp9;
                p++;
            }
            combine(temp[0], temp[1], map);
        }
        List<List<Character>> mapc = new LinkedList<List<Character>>();
        List<List<Integer>> mapp = new LinkedList<List<Integer>>();
        int[] sign = new int[res.length + 1];
        int index = 1;
        for (int i = 0; i < res.length; i++) {
            int p = root(i, map);
            if (sign[p] == 0) {
                sign[p] = index;
                mapc.add(new LinkedList<Character>());
                mapp.add(new LinkedList<Integer>());
                index++;
            }
            mapc.get(sign[p]).add(res[i]);
            mapp.get(sign[p]).add(i);
        }
        for (int p = 0; p < res.length; p++) {
            if (sign[p] != 0) {
                Character[] tempcc = new Character[mapc.get(sign[p]).size()];
                mapc.get(sign[p]).toArray(tempcc);
                Arrays.sort(tempcc);
                for(int i = 0; i < mapp.get(sign[p]).size(); i++){
                    res[mapp.get(sign[p]).get(i)] = tempcc[i];
                }
            }
        }
        return new String(res);
    }


    public static void combine(int i, int j, int[] map){
        int temp1 = root(i, map);
        int temp2 = root(j, map);
        if(temp1 != temp2) map[temp1] = map[temp2];
    }
    public static int root(int i, int[]map){
        if(i == map[i]) return i;
        map[i] = root(map[i], map);
        return map[i];
    }
}
