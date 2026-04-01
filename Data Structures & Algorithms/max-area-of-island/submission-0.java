class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        Queue<int[]> toProcess = new ArrayDeque<>();
        int maxArea = 0;

        int rowSize = grid.length, colSize = grid[0].length;

        for (int i = 0; i < grid.length; i++){

            for (int j = 0; j < grid[i].length; j++){

                if (grid[i][j] == 1){

                    int currArea = 1;
                    grid[i][j] = 0;
                    toProcess.offer(new int[] {i, j});

                    while (!toProcess.isEmpty()){

                        int[] currSpot = toProcess.poll();
                        int row = currSpot[0], col = currSpot[1];

                        if (row > 0 && grid[row - 1][col] == 1){
                            grid[row - 1][col] = 0;
                            toProcess.offer(new int[] {row - 1,col});
                            currArea++;
                        }
                        if (row < rowSize - 1 && grid[row + 1][col] == 1){
                            grid[row + 1][col] = 0;
                            toProcess.offer(new int[] {row + 1, col});
                            currArea++;
                        }
                        if (col > 0 && grid[row][col - 1] == 1){
                            grid[row][col - 1] = 0;
                            toProcess.offer(new int[] {row, col - 1});
                            currArea++;
                        }
                        if (col < colSize - 1 && grid[row][col + 1] == 1){
                            grid[row][col + 1] = 0;
                            toProcess.offer(new int[] {row, col + 1});
                            currArea++;
                        }

                    }

                    maxArea = Math.max(maxArea, currArea);


                }

            }
        }

        return maxArea;

    }
}
