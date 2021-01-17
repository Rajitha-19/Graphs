class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        change(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    public void change(int[][] image,int row,int col,int Color, int newColor){
        if(row>=image.length || row<0 || col>=image[0].length ||col<0){
            return;
        }
        else if(image[row][col]==Color){
            image[row][col]=newColor;
            change(image,row,col-1,Color,newColor);
            change(image,row+1,col,Color,newColor);
            change(image,row-1,col,Color,newColor);
            change(image,row,col+1,Color,newColor); 
        }
    }
}