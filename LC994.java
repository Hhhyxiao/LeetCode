package LeetCode;

import java.util.Arrays;

public class LC994 {
    public static void main(String[] args){
        int[][] grid = {{1,2}};
        System.out.print(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        int cnt = 0;
        boolean flag = true;
        boolean flag1 = false;
        while(flag){
            flag = false;
            int[][] temparr = new int[grid.length][grid[0].length];
            for(int i = 0;i < grid.length;i++){
                temparr[i] = grid[i].clone();
            }
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 2){
                        if(i - 1 >= 0 && temparr[i-1][j] == 1) temparr[i-1][j] = 2;
                        if(j - 1 >= 0 && temparr[i][j-1] == 1) temparr[i][j-1] = 2;
                        if(j + 1 < temparr[0].length && temparr[i][j+1] == 1) temparr[i][j + 1] = 2;
                        if(i + 1 < temparr.length && temparr[i + 1][j] == 1) temparr[i + 1][j] = 2;
                    }
                }
            }
            cnt++;
            for(int i = 0;i < grid.length;i++){
                if(!Arrays.equals(temparr[i], grid[i].clone())){
                    flag = true;
                    break;
                }
            }
            for(int i = 0;i < temparr.length;i++){
                grid[i] = temparr[i].clone();
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) flag1 = true;
            }
        }
        if(flag1) return -1;
        return cnt -1;
    }

}
