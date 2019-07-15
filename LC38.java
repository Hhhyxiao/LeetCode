package LeetCode;

public class LC38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n) {
        return help(n);
    }

    private static String help(int n){
        if(n == 1) return "1";
        String tempstring = help(n-1);
        StringBuilder sb = new StringBuilder();
        Character temp = 0;
        int count = 0;
        for(int i = 0; i < tempstring.length(); i++){
            if(i == 0){
                temp = tempstring.charAt(0);
                count = 1;
            }
            if(i != tempstring.length() - 1 && tempstring.charAt(i+1) == tempstring.charAt(i)){
                count++;
            }
            else
            {
                sb.append(Integer.toString(count));
                sb.append(temp);
                count = 1;
                if(i != tempstring.length() - 1){
                    temp = tempstring.charAt(i+1);
                }
            }
        }
        return sb.toString();
    }
}
