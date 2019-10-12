package LeetCode;

public class LC338 {
    public static void main(String[] args) {
        System.out.println(countBits(2));
    }

    public static int[] countBits(int num) {
        int[] zero = new int[1];
        zero[0] = 0;
        if(num == 0) return zero;
        int[] res = new int[num + 1];
        System.arraycopy(countBits(num - 1), 0, res, 0, num);
        int count = 0;
        while(num != 0){
            num = num & (num - 1);
            count++;
        }
        res[num] = count;
        return res;
    }
}
