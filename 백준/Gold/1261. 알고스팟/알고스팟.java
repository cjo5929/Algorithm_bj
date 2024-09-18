import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static PriorityQueue<Node> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x, y, cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }


    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];


        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {
        q = new PriorityQueue<>();
        visited = new boolean[n][m];
        q.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == n - 1 && cur.y == m - 1) {
                return cur.cnt;
            }

            for(int i = 0; i < 4; i++) {
                int ax = cur.x + dx[i];
                int ay = cur.y + dy[i];

                if(check(ax, ay) && !visited[ax][ay]) {
                    if(arr[ax][ay] == 1){
                        visited[ax][ay] = true;
                        q.offer(new Node(ax, ay, cur.cnt + 1));
                    }else {
                        visited[ax][ay] = true;
                        q.offer(new Node(ax, ay, cur.cnt));
                    }


                }
            }

        }

        return 0;
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
