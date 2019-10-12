package LeetCode;

public class LC541 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    public static String reverseStr(String s, int k) {
        int lon = s.length();
        int a = 0;
        int b = k - 1;
        int cnt = 0;
        StringBuilder sb = new StringBuilder(s);
        while(lon >= 2*k){
            while(a < b){
                sb.setCharAt(a, s.charAt(b));
                sb.setCharAt(b, s.charAt(a));
                a++;
                b--;
            }
            cnt += 2*k;
            a = cnt;
            b = cnt + k - 1;
            lon -= 2*k;
        }
        if(lon >= k){
            while(a < b){
                sb.setCharAt(a, s.charAt(b));
                sb.setCharAt(b, s.charAt(a));
                a++;
                b--;
            }
        }
        else{
            a = cnt;
            b = s.length()-1;
            while(a < b){
                sb.setCharAt(a, s.charAt(b));
                sb.setCharAt(b, s.charAt(a));
                a++;
                b--;
            }
        }
        return s.toString();
    }
}
