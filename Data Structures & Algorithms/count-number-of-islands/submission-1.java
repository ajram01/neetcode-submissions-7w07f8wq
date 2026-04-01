class Solution {
    public int numIslands(char[][] grid) {
        
        Queue<int[]> toProcess = new ArrayDeque<>();
        int islandCount = 0;
        int rows = grid.length, columns = grid[0].length;

        for (int i = 0; i < grid.length; i++){

            for (int j = 0; j < grid[i].length; j++){

                if (grid[i][j] == '1'){
                    islandCount++;
                    grid[i][j] = '0';
                    toProcess.add(new int[] {i, j});

                    while(!toProcess.isEmpty()){

                        int[] currSpot = toProcess.poll();
                        int row = currSpot[0], col = currSpot[1];

                        if (row + 1 < rows && grid[row + 1][col] == '1'){
                            grid[row + 1][col] = '0';
                            toProcess.add(new int[] {row + 1, col});
                        }
                        if (col + 1 < columns && grid[row][col + 1] == '1'){
                            grid[row][col + 1] = '0';
                            toProcess.add(new int[] {row, col + 1});
                        }
                        if (row - 1 >= 0 && grid[row - 1][col] == '1'){
                            grid[row - 1][col] = '0';
                            toProcess.add(new int[] {row - 1, col});
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1'){
                            grid[row][col - 1] = '0';
                            toProcess.add(new int[] {row, col - 1});
                        }

                    }

                }

            }

        }

        return islandCount;

    }
}
