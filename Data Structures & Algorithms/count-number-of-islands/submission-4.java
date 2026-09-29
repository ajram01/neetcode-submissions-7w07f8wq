class Solution {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int islandCount = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int row = 0; row < grid.length; row++){

            for (int col = 0; col < grid[0].length; col++){

                if (grid[row][col] == '1'){
                    islandCount++;
                    dfsHelper(row, col, directions, grid);
                }
            }
        }

        return islandCount;
        
    }

    public void dfsHelper(int row, int col, int[][] directions, char[][] grid){

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0'){
            return;
        }

        if (grid[row][col] == '1'){
            grid[row][col] = '0';
        }

        for (int[] dir : directions){

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            dfsHelper(newRow, newCol, directions, grid);

        }

    }
}
