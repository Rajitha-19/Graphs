
/*
Given a boolean matrix,find the number of islands.
What is an island?
A group of connected 1s forms an island. For example, the below matrix contains 5 islands

                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
Input Format
Number of rows ,number of columns in the first line.
Followed by the matrix.

Sample Input 

5 5 
1 1 0 0 0
0 1 0 0 1
1 0 0 1 1
0 0 0 0 0
1 0 1 0 1

Sample Output 
5
*/


import java.io.*;
import java.util.*;

public class Solution {
    public static void dfs(int[][] arr,int N,int M,int i,int j){
        if(i<0 || i>=N || j<0 || j>=M || arr[i][j]!=1){
            return;
        }
        arr[i][j]=2;
        dfs(arr,N,M,i-1,j-1);
        dfs(arr,N,M,i-1,j);
        dfs(arr,N,M,i,j-1);
        dfs(arr,N,M,i-1,j+1);
        dfs(arr,N,M,i,j+1);
        dfs(arr,N,M,i+1,j);
        dfs(arr,N,M,i+1,j+1);
        dfs(arr,N,M,i+1,j-1);
        
    }
    public static int countIslands(int[][] arr,int N,int M){
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==1){
                    count++;
                    dfs(arr,N,M,i,j);
                }
            }
        }
        return count;
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(countIslands(arr,n,m));

    }
}
