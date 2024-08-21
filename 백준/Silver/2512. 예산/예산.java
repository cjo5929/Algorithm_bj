import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, result;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }

        m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int start = 0;
        int end = arr[n - 1];

        while(start <= end) {
            int mid = (start + end) / 2;
            result = 0;

            for(int i = 0; i < n; i++) {
                if(arr[i] > mid) {
                    result += mid;
                }else{
                    result += arr[i];
                }
            }

            if (result > m) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }

        }

        System.out.println(end);

    }
}