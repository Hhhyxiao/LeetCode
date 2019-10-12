/*给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

        示例:
        输入: S = "a1b2"
        输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

        输入: S = "3z4"
        输出: ["3z4", "3Z4"]

        输入: S = "12345"
        输出: ["12345"]。*/

package LeetCode;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class LC784 {
    public static void main(String[] args){
        System.out.print(letterCasePermutation("bfdermiywz"));
    }
    public static List<String> letterCasePermutation(String S) {
        List<String> res = new LinkedList<String>();
        res.add(S);
        {
            for(int i = 0; i < S.length(); i++){
                char ch = S.charAt(i);
                List<String> temp = res;
                int end = temp.size();
                if((Character.isLowerCase(ch)) || Character.isUpperCase(ch))
                {
                    for(int j = 0; j < end; j++){
                        StringBuilder sb =new StringBuilder(res.get(j));
                        if(Character.isLowerCase(ch)) sb.setCharAt(i, Character.toUpperCase(ch));
                        if(Character.isUpperCase(ch)) sb.setCharAt(i, Character.toLowerCase(ch));
                        res.add(sb.toString());
                    }
                }
            }
        }
        return res;
    }
}
