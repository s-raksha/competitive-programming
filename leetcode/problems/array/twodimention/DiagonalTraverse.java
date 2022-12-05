package array.twodimention;
/*
https://leetcode.com/problems/diagonal-traverse/description/
 */
public class DiagonalTraverse {
    /*
    Time complexity O(m*n)
    Space complexity O(m*n)
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length==0 || mat[0].length==0)
            return new int[]{};
        int m=mat.length, n=mat[0].length;
        int[] result = new int[m*n];
        int row=0,column=0;
        int index=0;
        boolean up=true;
        while(row<m && column<n){
            if(up){
                while(row>0 && column<n-1){
                    result[index++] = mat[row][column];
                    row--;
                    column++;
                }
                result[index++] = mat[row][column];
                if(column == n-1){
                    row++;
                }
                else
                    column++;
            }else{
                while(column>0 && row<m-1){
                    result[index++] = mat[row][column];
                    row++;
                    column--;
                }
                result[index++] = mat[row][column];
                if(row == m-1){
                    column++;
                }
                else
                    row++;
            }
            up = !up;
        }
        return result;
    }
}
