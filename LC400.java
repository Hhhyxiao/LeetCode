package LeetCode;

public class LC400 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(11));
    }
    public static int findNthDigit(int n) {
        if (n < 10)  return n;//step 1
        long length = 0, cnt = 9, i = 1;
        for(; length + cnt * i < n; i++){
            length += cnt * i;
            cnt *= 10;
        }
        n -= length;
        long num = (long)Math.pow(10, i - 1);
        num += (n - 1) / i ;
        n = (n - 1) % (int)i;
        long res = 0;
        while(n != (int)i){
            res = num % 10;
            num = num / 10;
            n++;
        }
        return (int)res;
    }
}
