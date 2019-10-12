package LeetCode;

public class LC680 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(validPalindrome(s));
    }

    static int flag = 1;
    public static boolean validPalindrome(String s) {
        int st = 0;
        int end = s.length() - 1;
        while(st < end){
            if(s.charAt(st) != s.charAt(end)){
                if(flag == 0) return false;
                flag = 0;
                boolean temp;
                if(end == s.length() - 1) temp = validPalindrome(s.substring(st + 1));
                else temp = validPalindrome(s.substring(st + 1, end +1));
                return temp || validPalindrome(s.substring(st, end));
            }
            st++;
            end--;
        }
        return true;
    }
}
