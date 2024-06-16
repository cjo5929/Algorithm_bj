import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int t, n, m;
    static int[] a, b;
    static ArrayList<Integer> listA = new ArrayList<>();
    static ArrayList<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());

        }
        m = Integer.parseInt(br.readLine());
        b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

//      A의 부 배열 합 listA에 저장
        for(int i = 0; i < n; i++){
            int sum  = 0;
            for(int j = i; j < n; j++){
                sum += a[j];
                listA.add(sum);
            }
        }
//      B의 부 배열 합 listB에 저장
        for(int i = 0; i < m; i++){
            int sum  = 0;
            for(int j = i; j < m; j++){
                sum += b[j];
                listB.add(sum);
            }
        }



        Collections.sort(listA);
        Collections.sort(listB);


//       투포인터로 합이 T가 되는 경우 찾기
        long cnt = 0;
        int start = 0;
        int end = listB.size() - 1;

        while(start < listA.size() && end >= 0){
            int sum = listA.get(start) + listB.get(end);

//          연속된 숫자가 나올 때 경우의 수
            if(sum == t){

                int a = listA.get(start);
                int b = listB.get(end);
                long startCnt = 0;
                long endCnt = 0;

                while(start < listA.size() && listA.get(start) == a){
                    startCnt++;
                    start++;
                }
                while(end >= 0 && listB.get(end) == b){
                    endCnt++;
                    end--;
                }


                cnt += startCnt * endCnt;
            }else if(sum < t){
                start++;
            }else if(sum > t){
                end--;
            }

        }

        System.out.println(cnt);
    }

}