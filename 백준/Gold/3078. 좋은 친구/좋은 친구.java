import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static long result;
    static Queue<Integer>[] q = new Queue[21];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 21; i++) {
            q[i] = new ArrayDeque<>();
        }


        for (int i = 0; i < n; i++) {
            String name = br.readLine().trim();
            int len = name.length();

            if (q[len].isEmpty()) {
                q[len].offer(i);
            } else {
                while(i - q[len].peek() > k){
                    q[len].poll();

                    if(q[len].isEmpty()){
                        break;
                    }
                }

                result += q[len].size();
                q[len].offer(i);
            }



        }

        System.out.println(result);
    }

}