package LeetCode;

public class LC125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        s = s.toLowerCase();
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        int st = 0;
        int end = s.length()-1;
        while(st < end){
            char temp1 = s.charAt(st);
            char temp2 = s.charAt(end);
            if((Character.isLetter(temp1) || Character.isDigit(temp1)) && (Character.isLetter(temp2) || Character.isDigit(temp2))){
                if(temp1 != temp2) return false;
                st++;
                end--;
            }
            if(!(Character.isLetter(temp1) || Character.isDigit(temp1))) st++;
            if(!(Character.isLetter(temp2) || Character.isDigit(temp2))) end--;
        }
        return true;
    }
}
