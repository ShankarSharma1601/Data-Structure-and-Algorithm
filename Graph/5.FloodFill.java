class Solution{
    int x[] = {-1 , 0 , 1 , 0};
    int y[] = {0 , 1 , 0 , -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        
        int oldColor = image[sr][sc];
        if(image[sr][sc] != newColor){
            solve(image , sr , sc , oldColor , newColor);
        }
        return image;
    }
    
    private void solve(int [][]image , int row , int col , int oldColor , int newColor){
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != oldColor){
            return ;
        }
        
        image[row][col] = newColor;
        for(int i = 0;i < 4;i++){
            solve(image , row + x[i] , col + y[i] , oldColor , newColor);
        }
        
    }
    
}