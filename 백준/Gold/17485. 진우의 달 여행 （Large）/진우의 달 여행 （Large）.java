import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][][] dp;
    static int[][] arr;
    
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n][m][3];
        arr = new int[n][m];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j< m; j++){
                Arrays.fill(dp[i][j], 1000001);
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < 3; j++){
                dp[0][i][j] = arr[0][i];
            }
        }
        

        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(j == 0){
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + arr[i][j];
                    continue;
                }
                
                if(j == m - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + arr[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + arr[i][j];
                    continue;
                }
                
                dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
                dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + arr[i][j];

                
            }
        }
        

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.min(result, dp[n - 1][i][j]);
            }
        }
        System.out.println(result);
    }
}
