import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        // 초기값 설정
        dp[0] = 0;

        // dp[i]를 최댓값으로 초기화
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 최악의 경우 i는 1의 제곱수 i개로 표현될 수 있다.
        }

        // 제곱수들을 사용하여 dp 배열을 갱신
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            for (int j = square; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }

        // 결과 출력
        System.out.println(dp[n]);

    }
}