import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int t, n, k, result, cnt, value;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);


            int start = 0;
            int end = n - 1;
            int minValue = Integer.MAX_VALUE;
            cnt = 0;
            result = 0;
            value = 0;

            while (start < end) {
                result = arr[start] + arr[end];
                value = Math.abs(result - k);

                if (minValue >= value) {
                    if (value < minValue) {
                        cnt = 0;
                    }
                    minValue = value;
                    cnt++;

                }

                if (result >= k) {
                    end--;
                } else {
                    start++;
                }


            }

            sb.append(cnt + "\n");

        }
        System.out.println(sb);


    }
}