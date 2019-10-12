package LeetCode;

public class LC665 {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,3};
        System.out.println(checkPossibility(nums));
    }
    public static boolean checkPossibility(int[] nums) {
        Integer pre = null;
        boolean flag = true;
        for(int i = 0; i < nums.length; i++){
            if(pre == null) pre = nums[i];
            else if(pre > nums[i]){
                if(flag) {
                    if(i == nums.length - 1 || i <= 1 || nums[i] >= nums [i - 2]) pre = nums[i];
                    else if(pre > nums[i + 1]) return false;
                    flag = false;
                }
                else return false;
            }
            else pre = nums[i];
        }
        return true;
    }
}
