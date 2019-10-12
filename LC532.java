package LeetCode;

import java.util.Arrays;

public class LC532 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 0;
        System.out.println(findPairs(nums, k));
    }
    public static int findPairs(int[] nums, int k) {
        k = Math.abs(k);
        int res = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        while(j < nums.length){
            int temp = nums[j] - nums[i];
            if(temp == k) {
                res++;
                int pre = nums[i];
                while(i != nums.length && nums[i] == pre){
                    i++;
                }
                int pre2 = nums[j];
                while(j != nums.length && nums[j] == pre2){
                    j++;
                }
            }
            else if(temp > k){
                int pre = nums[i];
                while(i != nums.length && nums[i] == pre){
                    i++;
                }
            }
            else {
                int pre2 = nums[j];
                while(j != nums.length && nums[j] == pre2){
                    j++;
                }
            }
            if(i == j) j++;
        }
        return res;
    }
}
