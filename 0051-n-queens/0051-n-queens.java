class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board, ans);
        return ans;
    }

    private void backtrack(int row, char[][] board, List<List<String>> ans) {

        if (row == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {

                board[row][col] = 'Q';
                backtrack(row + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // upper left-diagonal check
        for (int i = row - 1, j = col - 1; 
             i >= 0 && j >= 0;
             i--, j--) {
                
            if (board[i][j] == 'Q')
                return false; 
        }

        // upper right-diagonal check
        for (int i = row - 1, j = col + 1; 
             i >= 0 && j < board.length;
             i--, j++) {
                
            if (board[i][j] == 'Q')
                return false; 
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> temp = new ArrayList<>();

        for (char[] row : board) {
            temp.add(new String(row));
        }

        return temp;
    }
}