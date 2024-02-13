import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, total;
	static ArrayList<Node> list = new ArrayList<>();

	public static class Node {
		int weight;
		int price;

		public Node(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			total += weight;
			list.add(new Node(weight, price));
			
		}
		
		if(total < M) {
			System.out.println(-1);
			return;
		}

		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.price == o2.price) {
					return o2.weight - o1.weight;
				}
				return o1.price - o2.price;

			}
		});
		
		int sum_weight = 0;
		int result_price = 0;
		int temp_price = 0;
		int min = Integer.MAX_VALUE;
		
		for(Node n : list) {
			sum_weight += n.weight;  // 무게 계속 더해주기 
			 
			if(temp_price != n.price) {  // 전에 저장된 가격과 다른 가격이라면 더 비싼 것 이므로 교체
				temp_price = result_price = n.price;
			}else if(temp_price == n.price) { // 같은 거라면 result_price에 더해주기 (싼 고기들만 공짜로 얻는 거고 같은 건 비용지불)
				result_price += n.price;
			}
			
			if(sum_weight >= M) {  // 목표 M보다 크거나 같아지면 최소 비용 갱신
				min = Math.min(result_price, min);
			}
			
		}
		
		System.out.println(min);
		


	}

}