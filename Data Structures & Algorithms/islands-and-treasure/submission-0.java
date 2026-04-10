class Solution {
    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public void islandsAndTreasure(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {

                // Run BFS only for empty land
                if (grid[r][c] == Integer.MAX_VALUE) {
                    bfs(grid, r, c);
                }
            }
        }
    }

    private void bfs(int[][] grid, int row, int col) {

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        q.offer(new int[]{row, col, 0});
        visited[row][col] = true;

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            int count = node[2];

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                // ✅ Fixed boundary condition
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length
                        && !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    if (grid[nr][nc] == 0) {
                        min = count + 1;
                        grid[row][col] = min;
                        return; // ✅ stop early (nearest found)
                    }

                    if (grid[nr][nc] != -1) {
                        q.offer(new int[]{nr, nc, count + 1}); // ✅ fixed count
                    }
                }
            }
        }
    }
}
