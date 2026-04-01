class Solution {
    public int numIslands(char[][] grid) {

        Queue<int[]> toProcess = new ArrayDeque<>();
        int rowSize = grid.length, colSize = grid[0].length;
        int totalIslands = 0;

        for (int i = 0; i < grid.length; i++){

            for (int j = 0; j < grid[i].length; j++){

                if (grid[i][j] == '1'){

                    totalIslands++;
                    toProcess.offer(new int[] {i,j});

                    while(!toProcess.isEmpty()){

                        int[] currSpot = toProcess.poll();
                        int row = currSpot[0], col = currSpot[1];
                        grid[row][col] = '0';

                        if (row > 0 && grid[row - 1][col] == '1'){
                            toProcess.offer(new int[] {row - 1, col});
                        }
                        if (row < rowSize - 1 && grid[row + 1][col] == '1'){
                            toProcess.offer(new int[] {row + 1, col});
                        }
                        if (col > 0 && grid[row][col - 1] == '1'){
                            toProcess.offer(new int[] {row, col - 1});
                        }
                        if (col < colSize - 1 && grid[row][col + 1] == '1'){
                            toProcess.offer(new int[] {row, col + 1});
                        }

                    }
                }

            }
        }

        return totalIslands;
        
    }
}
