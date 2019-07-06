package LeetCode;

public class LC748 {
    public static void main(String[] args){
        String s1 = "1s3 PS";
        String[] words  =  {"step","steps","stripe","stepple"};
        System.out.print(shortestCompletingWord(s1, words));

    }
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        String ans = null;
        int len = Integer.MAX_VALUE;
        licensePlate = licensePlate.toLowerCase();
        for(int i = 0; i < words.length; i++){
            int reallo = words[i].length();
            String realst = words[i];
            int lo = words[i].length();
            int j;
            for(j = 0; j < licensePlate.length(); j++){
                if(Character.isLetter(licensePlate.charAt(j))){
                    int index = words[i].indexOf(licensePlate.charAt(j));
                    if(index != -1){
                        words[i] = words[i].substring(0,index) + words[i].substring(index+1, lo);
                        lo--;
                    }
                    else break;
                }
            }
            if (j == licensePlate.length())
            {
                if(reallo < len){
                    len = reallo;
                    ans = realst;
                }
            }
        }
        return ans;
    }
}
