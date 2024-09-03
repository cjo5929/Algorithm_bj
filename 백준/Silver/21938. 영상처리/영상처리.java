import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, t, result;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayDeque<Point> q;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        result = 0;
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[i][j] = (r + g + b) / 3;
            }
        }
        
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] >= t) {
                    arr[i][j] = 255;
                    continue;
                }
                
                arr[i][j] = 0;
            }
        }
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 255 && !visited[i][j]) {
                    result++;
                    bfs(i, j);
                }
 
            }
        }
        
        System.out.print(result);
        
    }
    
    static void bfs(int x, int y){
        q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            
            for(int i = 0; i < 4; i++){
                int ax = cur.x + dx[i];
                int ay = cur.y + dy[i];
                
                if(check(ax, ay) && arr[ax][ay] == 255 && !visited[ax][ay]) {
                    visited[ax][ay] = true;
                    q.offer(new Point(ax, ay));
                }
            }
        }
    }
    
    static boolean check(int ax, int ay){
        return ax >= 0 && ax < n && ay >= 0 && ay < m;
    }
}
