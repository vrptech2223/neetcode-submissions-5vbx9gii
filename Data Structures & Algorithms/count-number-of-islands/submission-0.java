class Solution {
     private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {

        int row=grid.length; 
        int col= grid[0].length;
        int island=0;

        for(int r=0;r< row;r++)
        {
            for(int c=0;c<col;c++)
            {
                if(grid[r][c] == '1')
                {
                    bfs(grid,r,c);
                    island++;
                }
            }
        }
        return island;
    }


    private void bfs(char[][]grid,int row,int col)
    {
        Queue<int[]> q= new LinkedList<>();
        grid[row][col] = '0';
        q.add(new int[]{row,col});

        while(!q.isEmpty())
        {
            int node[]=q.poll();
            for(int[] dir : directions)
            {
                 row = node[0]; col = node[1];
                int nr = row+dir[0], nc = col+ dir[1];
                if(nr >=0 && nc >=0 && nr < grid.length && nc < grid[0].length)
                {
                    if(grid[nr][nc] == '1')
                    q.add(new int[]{nr,nc});
                    grid[nr][nc]='0';
                } 
            }
        }
    }
}
