class Solution {
    int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    int m , n ;
    public int countIslands(int[][] grid, int k) {
        m = grid.length ;
        n = grid[0].length ;

        boolean[][] vis = new boolean[m][n];
        int count = 0;

         for(int i = 0; i < m;i++){
            for(int j =0;j < n;j++){
                if(grid[i][j] > 0 && !vis[i][j]){
                    long sum = dfs(grid,vis,i,j);

                    if(sum % k == 0) count++;
                }
            }
         }
         return count ;  
    }
    long dfs(int grid[][],boolean [][] vis,int i,int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] <= 0 || vis[i][j]){
            return 0 ;
        }
        vis[i][j] = true ;

        long sum = grid[i][j];

        for(int d[] : dir){
            sum += dfs(grid,vis,i+d[0] ,j + d[1]) ;
        }
        return sum ;
    }
}