class Solution {
    public int numIslands(char[][] grid) {

        Deque<int[]> toProcess = new ArrayDeque<>();

        int rowLength = grid.length;
        int colLength = grid[0].length;

        int totalIslands = 0;

        for (int row = 0; row < rowLength; row++){

            for (int col = 0; col < colLength; col++){

                if (grid[row][col] == '1'){

                    toProcess.offer(new int[] {row, col});
                    totalIslands++;

                }

                while (!toProcess.isEmpty()){

                    int[] curr = toProcess.poll();

                    int currRow = curr[0];
                    int currCol = curr[1];

                    grid[currRow][currCol] = '0';

                    if (currRow > 0 && grid[currRow - 1][currCol] == '1'){
                        toProcess.offer(new int[] {currRow - 1, currCol});
                    }
                    if (currRow < rowLength - 1 && grid[currRow + 1][currCol] == '1'){
                        toProcess.offer(new int[] {currRow + 1, currCol});
                    }
                    if (currCol > 0 && grid[currRow][currCol - 1] == '1'){
                        toProcess.offer(new int[] {currRow, currCol - 1});
                    }
                    if (currCol < colLength - 1 && grid[currRow][currCol + 1] == '1'){
                        toProcess.offer(new int[] {currRow, currCol + 1});
                    }

                }

            }

        }

        return totalIslands;

        
    }
}
