package LeetCode;

public class LC374 {
    public static void main(String[] args) {
        System.out.println(guessNumber(10));

    }
    public static int guessNumber(int n) {
        int st = 1;
        int end = n;
        int mid = (1+n)/2;
        int res = guess(mid);
        while(res != 0 && end >= st){
            res = guess(mid);
            if(res == 1){
                st = mid + 1;
            }
            else if(res == -1){
                end = mid - 1;
            }
            else return mid;
            mid = (st + end) / 2;
        }
        return 0;
    }
    public static int guess(int res){
        if(res == 1) return 0;
        if(res > 1) return  -1;
        return 1;
    }
}
