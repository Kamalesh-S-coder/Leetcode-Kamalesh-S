// Last updated: 11/09/2026, 09:31:39
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
       int rows=mat.length;
       int cols=mat[0].length;
       if((rows * cols) != (r * c)) return mat;

       int[][] output=new int[r][c];
       int col=0;
       int row=0;
       for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            output[row][col]=mat[i][j];
            col++;
            if(col == c){
                col=0;
                row++;
            }
        }
       } 
       return output;
    }
}