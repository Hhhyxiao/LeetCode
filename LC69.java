package LeetCode;

public class LC69{
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
    public static int mySqrt(int x){
        int st = 0;
        int end = x;
        int mid = (st + end) / 2;
        while(st < end){
            if(x / mid == mid) return mid;
            else if(x / mid < mid) end = mid;
            else st = mid + 1;
            mid = (st + end) / 2;
        }
        return mid;
    }
}
