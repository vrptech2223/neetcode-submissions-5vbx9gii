class Solution {
    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Add boundary 'O's
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if ((r == 0 || c == 0 || r == row - 1 || c == col - 1) 
                    && board[r][c] == 'O') {

                    q.offer(new int[]{r, c});
                    board[r][c] = 'T'; // mark safe
                }
            }
        }

        // Step 2: BFS to mark all safe 'O'
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < row && nc < col 
                    && board[nr][nc] == 'O') {

                    board[nr][nc] = 'T';
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 3: Flip remaining 'O' → 'X'
        // Step 4: Convert 'T' → 'O'
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
