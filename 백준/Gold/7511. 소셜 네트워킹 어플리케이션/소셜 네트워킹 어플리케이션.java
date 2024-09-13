import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int t, n, k, m;
    static int[] parent;
    
    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());
        
        for(int test_case = 0; test_case < t; test_case++) {
            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());
            sb.append("Scenario ").append(test_case + 1).append(":\n");
            parent = new int[n + 1];
            
            for(int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if(find(a) != find(b)) {
                    union(a, b);
                }
            }
            
            m = Integer.parseInt(br.readLine());
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if(find(a) != find(b)) {
                    sb.append(0 + "\n");
                    continue;
                }
                sb.append(1 + "\n");
            }
            
            sb.append("\n");
        }
        System.out.print(sb);
        
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a != b) {
            parent[b] = a;
        }
    }
    
    static int find(int a) {
        if(parent[a] == a){
            return a;
        }
        
        return parent[a] = find(parent[a]);
    }
}
