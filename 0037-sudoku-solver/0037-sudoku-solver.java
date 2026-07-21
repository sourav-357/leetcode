class Solution {
    public void solveSudoku(char[][] board) {

        List<int[]> empty = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                
                if (board[i][j] == '.')
                    empty.add(new int[]{i, j});
            }
        }

        backtrack(board, empty, 0);
    }

    private boolean backtrack(char[][] board, List<int[]> empty, int index) {

        if (index == empty.size()) 
            return true;

        int row = empty.get(index)[0];
        int col = empty.get(index)[1];

        for (char ch = '1'; ch <= '9'; ch++) {

            if (isSafe(board, row, col, ch)) {
                board[row][col] = ch;

                if (backtrack(board, empty, index + 1)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char ch) {

        // check row 
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == ch) 
                return false;
        }

        // check col 
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == ch)
                return false;
        }

        // check the current square
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {

                if (board[i][j] == ch)
                    return false;
            }
        }

        return true;
    }
}