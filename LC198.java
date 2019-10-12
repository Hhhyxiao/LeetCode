package LeetCode;

import java.util.HashMap;

public class LC198 {
    public static void main(String[] args) {
        int[] num = {2,1};
        System.out.println(rob(num));
    }
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        map.put(0, nums[0]);
        map.put(1, nums[1]);
        return help(nums, nums.length-1);
    }

    public static int help(int[] nums, int num){
        if(num < 0) return 0;
        if(map.get(num) == null){
            int temp = Math.max(help(nums, num - 1), help(nums, num - 2) + nums[num]);
            map.put(num, temp);
        }
        return map.get(num);
    }
}
