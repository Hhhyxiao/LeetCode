package LeetCode;

public class LC840 {
    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(numMagicSquaresInside(grid));
    }
    public static int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        for(int i = 0; i < grid.length - 2; i++){
            for(int j = 0; j < grid[i].length - 2; j++){
                if(help(i, j, grid)) cnt++;
            }
        }
        return cnt;
    }

    public static boolean help(int i, int j, int[][] grid){
        int[] map = new int[10];
        for(int a = i; a <= i + 2; a++){
            for(int b = j; b <= j + 2; b++){
                if(map[grid[a][b]] == 1)return false;
                else map[grid[a][b]] = 1;
            }
        }
        return(grid[i][j] + grid[i][j+1] + grid[i][j+2] == 15 && grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2] == 15 && grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2] == 15 && grid[i+1][j] + grid[i+2][j] + grid[i][j] == 15 && grid[i+1][j+1] + grid[i+2][j+1] + grid[i][j+1] == 15 && grid[i+1][j+2] + grid[i+2][j+2] + grid[i][j+2] == 15 && grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2] == 15 && grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2] == 15);
    }
}
