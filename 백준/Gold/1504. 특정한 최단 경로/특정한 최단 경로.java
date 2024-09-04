import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, e, v1, v2;
    static ArrayList<ArrayList<Node>> list;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dist;
    static PriorityQueue<Node> pq;
    static boolean[] visited;
    
    static class Node implements Comparable<Node>{
        int end, value;
        
        Node(int end, int value) {
            this.end = end;
            this.value = value;
            
        }
        
        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        dist = new int[n + 1];
        
        Arrays.fill(dist, 200000000);
        
        for(int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, v));
            list.get(b).add(new Node(a, v));
        }
        
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        
        // 1 -> 2 -> 3 -> 4
        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, n);
        
        // 1 -> 2 -> 3 -> 4
        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, n);
        
        if(result1 >= 200000000 && result2 >= 200000000) {
            System.out.print(-1);
        }else{
            System.out.print(Math.min(result1, result2));
        }

        
        
    }
    
    static int dijkstra(int start, int end) {
        Arrays.fill(dist, 200000000);
        dist[start] = 0;
        pq = new PriorityQueue<>();
        visited = new boolean[n + 1];
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (visited[cur.end]) continue;
            visited[cur.end] = true;
            
            for(Node next : list.get(cur.end)) {
                if(dist[next.end] > dist[cur.end] + next.value) {
                    dist[next.end] = dist[cur.end] + next.value;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
        
        return dist[end];
    }
    
    
}
