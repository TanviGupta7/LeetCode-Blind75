import java.util.*;

public class Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0});  // Start at square 1 with 0 moves
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int square = curr[0], moves = curr[1];

            if (square == n * n) return moves;

            for (int i = 1; i <= 6; i++) {
                int next = square + i;
                if (next > n * n) continue;

                int[] coords = getCoordinates(next, n);
                int row = coords[0], col = coords[1];

                if (board[row][col] != -1) {
                    next = board[row][col];  // Move via snake or ladder
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, moves + 1});
                }
            }
        }

        return -1;  // If unreachable
    }

    // Converts a square number to board coordinates (row, col)
    private int[] getCoordinates(int square, int n) {
        int row = n - 1 - (square - 1) / n;
        int col = (square - 1) % n;
        if ((n - row) % 2 == 0) {
            col = n - 1 - col;  // Reverse for even rows
        }
        return new int[]{row, col};
    }
}
