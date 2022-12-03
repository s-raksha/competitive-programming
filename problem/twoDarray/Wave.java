package twoDarray;

public class Wave {
    /*
    Time complexity is m*n
    auxiliary memory is o(1)
    If even column move downwards
    If odd column move upwards
     */
    public static void main(String[] args) {
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] result = new int[3*4];
        int c=0;
        for(int j=0; j<4; j++){
            if(j%2 == 0){
                for(int i=0; i<3; i++) {
                    result[c] =  input[i][j];
                    c++;
                }
            }else{
                for(int i=2; i>=0; i--) {
                    result[c] =  input[i][j];
                    c++;
                }
            }
        }
        for(int i=0; i<c; i++){
            System.out.printf("%d \t",result[i]);
        }
    }
}