import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp, t, p;
    static int n;
    
    
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        t = new int[n + 1];
        p = new int[n + 1];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(i + t[i] <= n) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i + 1] =  Math.max(dp[i], dp[i + 1]);
        }
       
        System.out.print(dp[n]);
    }
}
