class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    markGrid(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public boolean check(char[][]grid,int row,int col){
         return(row>=grid.length || row<0 || col>=grid[0].length || col<0 || grid[row][col]!='1');
    }
    public void markGrid(char[][] grid,int row,int col){
        if(!(check(grid,row,col))){
            grid[row][col]='2';
            markGrid(grid,row,col-1);
            markGrid(grid,row,col+1);
            markGrid(grid,row+1,col);
            markGrid(grid,row-1,col);
            
        }
        
    }
}