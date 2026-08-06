class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length,island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    bfs(i,j,grid);
                    island++;
                }
            }
        }
        return island;
    }
    void bfs(int i,int j,char[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        grid[i][j]='0';
        
        int[][] directions ={{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int r=node[0];
            int c=node[1];
            for(int[] dir:directions){
                int nr=r+dir[0],nc=c+dir[1];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]=='1'){
                    queue.offer(new int[]{nr,nc});
                    grid[nr][nc]='0';
                }
            }
        } 
    }
}
