class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++){

            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();

        }

        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){

                char currVal = board[row][col];

                if (currVal == '.') continue;

                int currBox = (row / 3) * 3 + (col / 3);

                if (rows[row].contains(currVal) || cols[col].contains(currVal) || boxes[currBox].contains(currVal)){
                    return false;
                }

                rows[row].add(currVal);
                cols[col].add(currVal);
                boxes[currBox].add(currVal);

            }
        }

        return true;


        
        
    }
}
