class Solution {
    public int orangesRotting(int[][] grid) {

        Deque<int[]> toProcess = new ArrayDeque<>();

        int rows = grid.length;
        int cols = grid[0].length;
        int freshFruit = 0;
        int currSpread = 0;

        for (int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){

                if (grid[row][col] == 2){
                    currSpread++;
                    toProcess.offer(new int[] {row, col});
                } else if (grid[row][col] == 1){
                    freshFruit++;
                }

            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
        };

        int turns = 0;

        while (freshFruit > 0 && !toProcess.isEmpty()){

            int newSpread = 0;

            for (int i = 0; i < currSpread; i++){

                int[] curr = toProcess.poll();

                for (int[] dir : directions){

                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];

                    if (newRow >= 0 &&
                        newRow < rows &&
                        newCol >= 0 &&
                        newCol < cols &&
                        grid[newRow][newCol] == 1){
                            grid[newRow][newCol] = 2;
                            freshFruit--;
                            toProcess.offer(new int[] {newRow, newCol});
                            newSpread++;
                        }

                }

            }

            turns++;

            currSpread = newSpread;

        }

        return freshFruit == 0 ? turns : -1;

    }
}
