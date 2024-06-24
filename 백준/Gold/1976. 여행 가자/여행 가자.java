import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] arr;
    static int[] dosi;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        dosi = new int[m];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (i != j && arr[i][j] != 1) {
                    arr[i][j] = 10000000;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            dosi[i] = Integer.parseInt(st.nextToken());
        }


//      플로이드워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] >= arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        // 여행 계획 검증
        boolean possible = true;
        for (int i = 1; i < m; i++) {
            if (arr[dosi[i - 1]][dosi[i]] == 10000000) {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


}