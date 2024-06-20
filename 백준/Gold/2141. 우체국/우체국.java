import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static long result, total;
    static long[][] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new long[n][2];
        total = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            total += arr[i][1];

        }

//       마을 위치를 기준으로 정렬
        Arrays.sort(arr, new Comparator<long[]>(){

            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] == o2[0]){
                    return (int)(o1[1] - o2[1]);
                }
                return (int)(o1[0] - o2[0]);
            }
        });


        long mid = (total + 1) / 2;

//      total 인구수의 중간 값 확인
        for(long[] point : arr){
            result += point[1];

//         중간값을 넘는 첫 번째 마을의 위치
            if(result >= mid){
                sb.append(point[0]);
                break;
            }
        }


        System.out.println(sb);

    }
}