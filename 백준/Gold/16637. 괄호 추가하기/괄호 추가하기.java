import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, result;
	static ArrayList<Integer> num;
	static ArrayList<Character> oper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		num = new ArrayList<Integer>();
		oper = new ArrayList<Character>();
		result = Integer.MIN_VALUE;

		String str = br.readLine();
		for (int i = 0; i < N; i++) {

			if (i % 2 == 0) {
				num.add(str.charAt(i) - '0');
			} else {
				oper.add(str.charAt(i));
			}
		}
		
		dfs(0, num.get(0));
		
		System.out.println(result);
	}

	static void dfs(int now, int sum) {
		if(now == oper.size()) {
			result = Math.max(result, sum);
			
			return;
		}
		
//		괄호 없이
		int no = calc(now, sum, num.get(now + 1));
		dfs(now + 1, no);
		
//		괄호 있이
		if(now + 1 < oper.size()) {  // 연산자 뒤에 숫자가 존재해야하기 때문에 
			int yes = calc(now + 1, num.get(now + 1), num.get(now + 2));
			int answer = calc(now, sum, yes);
			dfs(now + 2, answer);
		}

	}

	static int calc(int index, int num1, int num2) {
		switch (oper.get(index)) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		}
		return 1;
	}

}