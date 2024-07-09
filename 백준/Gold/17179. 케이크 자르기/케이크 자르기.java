import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m, l, result;
    static int[] cutPoints;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        cutPoints = new int[m + 1];

        for (int i = 0; i < m; ++i) {
            cutPoints[i] = Integer.parseInt(br.readLine());
        }
        cutPoints[m] = l; // 롤 케이크의 끝 지점 추가

        // 각 자를 횟수에 대해 최대의 최소 조각 길이 계산
        for (int i = 0; i < n; ++i) {
            int cuts = Integer.parseInt(br.readLine());
            int left = 0;
            int right = l;

            // 이분 탐색을 통해 최대의 최소 조각 길이 찾기
            while (left <= right) {
                int cnt = 0;
                int prevCut = 0;
                int mid = (left + right) / 2;

                // 자를 수 있는 지점 순회하며 자르기
                for (int j = 0; j <= m; ++j) {
                    if (cutPoints[j] - prevCut >= mid) {
                        ++cnt;
                        prevCut = cutPoints[j];
                    }
                }

                // 자른 횟수가 원하는 횟수보다 많다면 최소 길이를 늘림
                if (cnt > cuts) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(right).append("\n"); // 결과 저장
        }

        // 결과 출력
        System.out.println(sb);
    }
}