import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int l, r, c, result;
    static int [] dx = {1, -1, 0, 0, 0, 0};
    static int [] dy = {0, 0, 1, -1, 0, 0};
    static int [] dz = {0, 0, 0, 0, 1, -1};
    static char [][][] arr;
    static ArrayDeque<Node> queue;
    static boolean[][][] visited;
    static Node start, end;

    static class Node {
        int x, y, z, cnt;

        Node(int z, int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {

        while(true){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0){
                break;
            }

            arr = new char[l][r][c];
            result = 0;

            for(int i = 0; i < l; i++){
                for(int j = 0; j < r; j++){
                    String str = br.readLine();
                    for(int k = 0; k < c; k++){
                        if(str.charAt(k) == 'S'){
                            start = new Node(i, j, k, 0);
                        }

                        if(str.charAt(k) == 'E'){
                            end = new Node(i, j, k, 0);
                        }

                        arr[i][j][k] = str.charAt(k);
                    }
                }
                br.readLine();
            }

            if(bfs(start.z, start.x, start.y)){

            sb.append("Escaped in ").append(result).append(" minute(s).\n");
            }else{
                sb.append("Trapped!\n");
            }

        }

        System.out.println(sb);


    }

    static boolean bfs(int z, int x, int y){
        queue = new ArrayDeque<>();
        visited = new boolean[l][r][c];
        queue.add(new Node(z, x, y, 0));
        visited[z][x][y] = true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();


            if(end.z == cur.z && end.x == cur.x && end.y == cur.y){
                result = cur.cnt;
                return true;
            }

            for(int i = 0; i < 6; i++){
                int az = cur.z + dz[i];
                int ax = cur.x + dx[i];
                int ay = cur.y + dy[i];

                if(check(az, ax, ay) && !visited[az][ax][ay]){

                    queue.add(new Node(az, ax, ay, cur.cnt + 1));
                    visited[az][ax][ay] = true;
                }
            }
        }

        return false;
    }

    static boolean check(int az, int ax, int ay){
        return az >= 0 && az < l && ax >= 0 && ax < r && ay >= 0 && ay < c && arr[az][ax][ay] != '#';
    }
}