class Solution {
    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        Deque<int[]> toProcess = new ArrayDeque<>();
        int freshOranges = 0;

        for (int row = 0; row < grid.length; row++){

            for (int col = 0; col < grid[0].length; col++){

                if (grid[row][col] == 2){
                    toProcess.offer(new int[] {row, col});
                } else if (grid[row][col] == 1){
                    freshOranges++;
                }

            }
        }

        int minMinutes = 0;
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        
        while (!toProcess.isEmpty() && freshOranges > 0){

            int currWindow = toProcess.size();
            for (int i = 0; i < currWindow; i++){

                int[] curr = toProcess.poll();

                for (int[] dir : directions){

                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];

                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        freshOranges--;
                        toProcess.offer(new int[] {newRow, newCol});
                    }

                }
            }

            minMinutes++;

        }

        return freshOranges == 0 ? minMinutes : -1;
    }
}
