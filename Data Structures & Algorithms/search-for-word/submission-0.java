class Solution {
    public boolean exist(char[][] board, String word) {

        for (int row = 0; row < board.length; row++){

            for (int col = 0; col < board[0].length; col++){

                if (board[row][col] == word.charAt(0)){

                    if (wordSearch(board, word, row, col, 0)){
                        return true;
                    }

                }


            }
        }

        return false;
        
    }

    private boolean wordSearch(char[][] board, String word, int row, int col, int index){

        if (index == word.length()){
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)){
            return false;
        }

        char original = board[row][col];
        board[row][col] = '#';
        index++;

        boolean found = wordSearch(board, word, row + 1, col, index) ||
        wordSearch(board, word, row - 1, col, index) ||
        wordSearch(board, word, row, col + 1, index) ||
        wordSearch(board, word, row, col - 1, index);

        board[row][col] = original;
        return found;
    }
}
