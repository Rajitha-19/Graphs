import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution
{
    public boolean is_Possible(int[][] grid)
    {
        int m=grid.length;
        int n=grid[0].length;
        boolean res=false;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    res=dfs(grid,i,j,visited);
                    break;
                }
            }
        }
        return res;
    }
    public boolean check(int[][]grid,int row,int col,boolean[][] visited){
        return(row>=grid.length || row<0 || col>=grid[0].length || col<0 || grid[row][col]==0 || visited[row][col]);
    }
    public boolean dfs(int[][] grid,int row,int col,boolean[][] visited){
        if(check(grid,row,col,visited)){
            return false;
        }
        visited[row][col]=true;
        if(grid[row][col]==2)
            return true;
        return (dfs(grid,row-1,col,visited) || dfs(grid,row+1,col,visited) || dfs(grid,row,col+1,visited) || dfs(grid,row,col-1,visited));
    }
    
}