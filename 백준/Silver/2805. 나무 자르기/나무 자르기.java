import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static long m;
    static int[] arr;
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(tree());
        
    }
    
    static long tree() {
        long start = 0;
        long end = 1000000000;
        
        while(start <= end) {
            long mid =  start + (end - start) / 2;
            long cnt = 0;
            
            for(int i = 0; i < n; i++) {
                if(mid > arr[i]) continue;
                cnt += arr[i] - mid;
            }
            
            if(cnt >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return end;
    }
}