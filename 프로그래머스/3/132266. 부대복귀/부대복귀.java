import java.util.*;
import java.io.*;

class Solution {
    
    private ArrayList<ArrayList<Integer>> map;
    private int[] dist;
    private ArrayDeque<Integer> queue;
    private int N;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        N = n;
        int[] answer = new int[sources.length];
        map = new ArrayList<>();
        dist = new int[n + 1];
        
        for(int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        
        
        for(int i = 0; i < roads.length; i++) {
            map.get(roads[i][0]).add(roads[i][1]);
            map.get(roads[i][1]).add(roads[i][0]);
        }
        
        int index = 0;
        Arrays.fill(dist, -1);
    
        bfs(destination);
        
        for(int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        
        return answer;
    }
    
    
    private int bfs(int start) {
        int cnt = 0;
        queue = new ArrayDeque<>();        
        queue.offer(start);
        dist[start] = 0;
        
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            
            for(int node : map.get(cur)){
                if(dist[node] == -1) {
                    dist[node] = dist[cur] + 1;
                    queue.offer(node);
                }
                
            }
        }
        
        
        
        return -1;
    }
}