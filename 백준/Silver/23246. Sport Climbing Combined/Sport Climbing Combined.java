import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static ArrayList<Player> list;

	static class Player implements Comparable<Player> {
		int num, lead, speed, rank, mul, sum;

		public Player(int num, int lead, int speed, int rank, int mul, int sum) {
			super();
			this.num = num;
			this.lead = lead;
			this.speed = speed;
			this.rank = rank;
			this.mul = mul;
			this.sum = sum;
		}

		@Override
		public int compareTo(Player o) {
			if (o.mul == this.mul) {
				if (o.sum == this.sum) {
					return Integer.compare(o.num, this.num) * -1;
				}

				return Integer.compare(o.sum, this.sum) * -1;
			}
			return Integer.compare(o.mul, this.mul) * -1;
		}

		@Override
		public String toString() {
			return "Player [num=" + num + ", lead=" + lead + ", speed=" + speed + ", rank=" + rank + ", mul=" + mul
					+ ", sum=" + sum + "]";
		}

		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int lead = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int rank = Integer.parseInt(st.nextToken());
			int mul = lead * speed * rank;
			int sum = lead + speed + rank;
			list.add(new Player(num, lead, speed, rank, mul, sum));


		}
		Collections.sort(list);
		for(int i = 0; i < 3; i++) {
			System.out.print(list.get(i).num + " ");
		}
		

	}

}