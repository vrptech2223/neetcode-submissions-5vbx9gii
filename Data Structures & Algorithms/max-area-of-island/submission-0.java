class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {

        int max=0;
        int row=grid.length;
        int col=grid[0].length;
        
        for(int r=0;r<row;r++)
        {
            for(int c=0;c<col;c++)
            {
                if(grid[r][c] == 1)
                max=Math.max(bfs(grid,r,c),max);
            }
        }
        
        return max;
    }

    private int bfs(int[][] grid,int row,int col)
    {
        Queue<int[]> q=new LinkedList<>();
        int maxCount=1;
        grid[row][col]=0;
        q.offer(new int[]{row,col});
        while(!q.isEmpty())
        {
            int[] node=q.poll();
            int r= node[0],c = node[1]; 
            for(int[] dir:directions)
            {
                int nr = r + dir[0];
                int nc = c + dir [1];

                if(nr >=0 && nc >=0 && nr < grid.length && nc < grid[0].length)
                {
                    if(grid[nr][nc] == 1 ){
                    q.offer(new int[]{nr,nc});
                    grid[nr][nc]=0;
                    maxCount++;
                    }
                }
            }
        }

        return maxCount;

    }
}
