class Solution {
    private void dfs(int[][] grid, int i, int j, int mins) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] < mins)) {
            return;
        }
        grid[i][j] = mins;
        dfs(grid, i+1, j, mins+1);
        dfs(grid, i-1, j, mins+1);
        dfs(grid, i, j+1, mins+1);
        dfs(grid, i, j-1, mins+1);
    }

    public int orangesRotting(int[][] grid) {

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    dfs(grid, i, j, 2);
                }
            }
        }

        int mins = 2;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                   return -1;
                }

                mins = Math.max(mins, grid[i][j]);
            }
        }
        return mins - 2;
    }
}
