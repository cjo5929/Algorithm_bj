import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] indegree, temp; 
    static ArrayDeque<Integer> q;
    
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        indegree = new int[n + 1];
        temp = new int[n + 1];
        
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            temp[i] = a;
            for(int j = 0; j < b; j++) {
                int node = Integer.parseInt(st.nextToken());
            
                list.get(node).add(i);
                indegree[i]++;
            }
        }
        
        System.out.print(bfs());
        
    }
    
    static int bfs() {
        q = new ArrayDeque<>();
        
        int[] result = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            result[i] = temp[i];
        
            
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : list.get(cur)) {
                indegree[next]--;
                
                result[next] = Math.max(result[next], result[cur] + temp[next]); 
                
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans = Math.max(ans, result[i]);
        }
        
        return ans;
    }
}
