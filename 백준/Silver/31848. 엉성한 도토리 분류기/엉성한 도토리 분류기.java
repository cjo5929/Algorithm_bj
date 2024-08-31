import java.io.*;
import java.util.*;

public class Main {
    static int n, q, cur;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
          
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) +i;
            if(i - 1 >= 0) arr[i] = Math.max(arr[i], arr[i - 1]);
        }
        

        q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < q; i++) {
            cur = Integer.parseInt(st.nextToken());
            int left = 0, right = n - 1;
            int result = Integer.MAX_VALUE;
            
            while(left <= right) {
                int mid = (left + right) / 2;
                
                if(arr[mid] >= cur) {
                    result = Math.min(result, mid);
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
                
            }
            
            sb.append(result + 1).append(" ");
        }
        
        System.out.println(sb);
    }
}
