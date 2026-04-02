class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer, HashSet<Character>> boxes = new HashMap<>();

        for (int r = 0; r < board[0].length; r++){
            for (int c = 0; c < board.length; c++){
                char val = board[r][c];

                if (val == '.'){
                    continue;
                }

                int currBox = (r / 3) * 3 + (c / 3);

                rows.putIfAbsent(r, new HashSet<>());
                cols.putIfAbsent(c, new HashSet<>());
                boxes.putIfAbsent(currBox, new HashSet<>());

                if (rows.get(r).contains(val) || cols.get(c).contains(val) || boxes.get(currBox).contains(val)){
                    return false;
                }

                rows.get(r).add(val);
                cols.get(c).add(val);
                boxes.get(currBox).add(val);
            }
        }

        return true;
        
    }
}
