import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp;
    
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        dp = new int[n + 1];
        
        for(int i = 1; i < m / 2; i++){
            for(int j = i + 1; j < m; j++) {
                dp[0] = i;
                dp[1] = j;
                
                for(int k = 2; k < n; k++) {
                    dp[k] = dp[k - 1] + dp[k - 2];
                }
                
                if(dp[n - 1] == m) {
                    System.out.println(dp[0]);
    				System.out.println(dp[1]);
                    System.exit(0);
                }
                
            }
        }
    }
}
