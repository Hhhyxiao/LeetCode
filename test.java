package LeetCode;
public class test {
    public static void main(String[] args) {        String str = "AAaaaAAAA";
        int flag = 0;
        int cap = 1;
        int preflag = 1;
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            if('a' <= str.charAt(i) && str.charAt(i) <= 'z') flag =1;
            else flag = 0;
            if(flag == cap){
                cnt++;
            }
            else{
                if(flag == preflag){
                    cnt ++;
                    cap = flag;
                }
                else{
                    cnt += 2;
                }
            }
            preflag = flag;
        }
        System.out.println(cnt);
    }
}