public class MatrixMulti {
    public static void main(String[] args){

        int[] d={9, 10, 8, 4, 11, 7, 6};
        int n=d.length-1;
        int [][] C=new int[n+1][n+1];

        for (int i=1; i<=n; i++){
            C[i][i] = 0;
        }

        for(int L=1; L<=n-1; L++){
            for(int i=1; i<=n-L; i++){
                int j=i+L;
                C[i][j] = Integer.MAX_VALUE;

                for(int k=i; k<=j-1; k++){
                    int temp = C[i][k] + C[k+1][j] + d[i-1]*d[k]*d[j];

                    if(temp < C[i][j]){
                        C[i][j] = temp;
                    }
                }
            }
        }
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (j < i) {
                    System.out.print("      ");
                } else {
                    System.out.printf("%6d", C[i][j]);
                }
            }
            System.out.println();
        }
        System.out.printf("C[1][%d] = %d%n", n, C[1][n]);
    }
}
