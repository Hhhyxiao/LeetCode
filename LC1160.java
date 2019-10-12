package LeetCode;

import java.util.HashMap;

public class LC1160 {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;
        for(int j = 0; j < chars.length(); j++){
            char ch = chars.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }
        for(int j = 0; j < words.length; j++){
            HashMap<Character, Integer> temp = map;
            String st = words[j];
            int i;
            for(i = 0; i < st.length(); i++){
                char ch1 = st.charAt(i);
                if(temp.getOrDefault(ch1, 0) == 0) {
                    res -= st.length();
                    break;
                }
                temp.put(ch1, temp.get(ch1) - 1);
            }
            res += st.length();
        }
        return res;
    }
}
