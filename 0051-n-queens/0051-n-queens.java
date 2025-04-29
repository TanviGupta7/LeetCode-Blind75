class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solve(0, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);
        return ans;
    }

    private void solve(int col, char[][] board, List<List<String>> ans,
                       int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, int n) {
        if (col == n) {
            // Convert board to list of strings
            List<String> res = new ArrayList<>();
            for (char[] row : board) {
                res.add(new String(row));
            }
            ans.add(res);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 &&
                lowerDiagonal[row + col] == 0 &&
                upperDiagonal[n - 1 + col - row] == 0) {

                // Place the queen
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                // Recurse for next column
                solve(col + 1, board, ans, leftRow, upperDiagonal, lowerDiagonal, n);

                // Backtrack
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
}
