class Solution {

    private void dfs(char[][]grid, int i, int j, int islands) {
        if(i >=0 && i < grid.length && j >=0 && j < grid[0].length && grid[i][j] == '1') {
            islands++;
            grid[i][j] = '0';
            dfs(grid, i+1, j, islands);
            dfs(grid, i-1, j, islands);
            dfs(grid, i, j+1, islands);
            dfs(grid, i, j-1, islands);
        }
    }

    public int numIslands(char[][] grid) {

        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int islands = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j, islands);
                }
            }
        }

        return islands;
        
    }
}
