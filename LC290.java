package LeetCode;

import java.util.HashMap;

public class LC290 {
    public static void main(String[] args) {
        String str1 = "abba";
        String str2 = "dog cat cat dog";
        System.out.println(wordPattern(str1, str2));

    }
    public static boolean wordPattern(String pattern, String str) {
        int[] map = new int[pattern.length()];
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        int cnt = 0;
        String[] temp = str.split(" ");
        if(temp.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++){
            if(map1.get(pattern.charAt(i)) == null) map1.put(pattern.charAt(i), cnt++);
            map[i] = map1.get(pattern.charAt(i));
        }
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        cnt = 0;
        for(int i = 0; i < temp.length; i++){
            if(map2.get(temp[i]) == null) map2.put(temp[i], cnt++);
            if(map[i] != map2.get(temp[i])) return false;
        }
        return true;
    }
}
