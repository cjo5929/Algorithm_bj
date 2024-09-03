import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, a;
     static PriorityQueue<Integer> pq = new PriorityQueue<>(
        new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) * -1;
            }
        }
    );
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());

            if(a == 0 && !pq.isEmpty()){
                sb.append(pq.poll()).append("\n");
            }
            else if(a == 0 && pq.isEmpty()){
                sb.append(-1).append("\n");
            }
            else{
                for(int j = 0; j < a; j++){
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }


        }

        System.out.println(sb);
    }
}
