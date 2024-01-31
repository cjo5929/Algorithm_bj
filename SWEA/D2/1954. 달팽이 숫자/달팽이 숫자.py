/**
 * @author 강민서  
 * @date 2024.01.31
 * @link https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AY0LFFoqrIIDFAXz&contestProbId=AV5PobmqAPoDFAUq&probBoxId=AY0LFFoqrIMDFAXz&type=PROBLEM&problemBoxTitle=0129%EC%A3%BC&problemBoxCnt=5
 * @keyword_solution  N크기의 달팽이를 출력 => 방향탐색으로 구현
 * @input (1 ≤ N ≤ 10) => 완탐 가능
 * @output '#t'로 시작 N X N 형태로 출력  
 * @time_complex  O(n^2)
 * @perf 18,876 kb 113 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, t, cnt;
    static int[] dx = { 0, 1, 0, -1 }; // 달팽이 탐색이므로 우하좌상 순으로 
    static int[] dy = { 1, 0, -1, 0 }; 
    static int[][] arr;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        t = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= t; test_case++) {
            sb.append("#" + test_case + " " + "\n");
 
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
             
            cnt = 1;
            int x = 0;
            int y = 0;
            int dist = 0;
 
            while (cnt <= n * n) {
                arr[x][y] = cnt;
                int ax = x + dx[dist];
                int ay = y + dy[dist];
                 
                if(ax < 0 || ax >= n | ay < 0 || ay >= n || arr[ax][ay] != 0) {
                    dist = (dist + 1) % 4;
                    ax = x + dx[dist];
                    ay = y + dy[dist];
                }
 
                 
                x = ax;
                y = ay;
                cnt++;
                 
            }
 
 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
 
            }
 
        }
        System.out.println(sb);
 
    }
 
}