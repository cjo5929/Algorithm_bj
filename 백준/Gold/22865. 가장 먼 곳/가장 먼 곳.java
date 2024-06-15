import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] friend;
    static PriorityQueue<Node> pq;
    static ArrayList<Node>[] list;

    static class Node implements Comparable<Node> {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        friend = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            friend[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        list = new ArrayList[m];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));

        }

        int[] distA = dijkstra(friend[0]);
        int[] distB = dijkstra(friend[1]);
        int[] distC = dijkstra(friend[2]);


        int maxDist = -1;
        int result = -1;

        for (int i = 1; i < n + 1; i++) {
            int minDist = Math.min(distA[i], Math.min(distB[i], distC[i]));
            if (maxDist < minDist) {
                maxDist = minDist;
                result = i;
            } else if (minDist == maxDist && i < result) {
                result = i;
            }
        }

        System.out.println(result);

    }

    static int[] dijkstra(int start) {
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.index] < cur.cost) {
                continue;
            }

            for (Node node : list[cur.index]) {
                if (dist[node.index] > cur.cost + node.cost) {
                    dist[node.index] = cur.cost + node.cost;
                    pq.offer(new Node(node.index, dist[node.index]));
                }
            }
        }

        return dist;
    }
}