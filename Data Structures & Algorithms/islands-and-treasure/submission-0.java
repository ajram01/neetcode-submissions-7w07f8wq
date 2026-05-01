class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        Deque<int[]> toProcess = new ArrayDeque<>();
        int rowSize = grid.length;
        int colSize = grid[0].length;

        for (int row = 0; row < rowSize; row++){
            for (int col = 0; col < colSize; col++){

                if (grid[row][col] == 0){
                    toProcess.offer(new int[] {row, col});
                }

            }
        }

        int[][] directions = {
            {1, 0}, // down
            {-1, 0}, // up
            {0, 1}, // right
            {0, -1} // left
        };

        while (!toProcess.isEmpty()) {
            int[] curr = toProcess.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= rowSize || newCol < 0 || newCol >= colSize || grid[newRow][newCol] != Integer.MAX_VALUE){
                    continue;
                }

                grid[newRow][newCol] = grid[row][col] + 1;
                toProcess.offer(new int[] {newRow, newCol});
            }
        }
    }
}
