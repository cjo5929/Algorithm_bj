import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<Character> stack = new ArrayDeque<>();
	static String str;
	static int result, temp;

	public static void main(String[] args) throws IOException {
		str = br.readLine();
		temp = 1;

		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (cur == '(') {
				stack.push(cur);
				temp *= 2;
			} else if (cur == '[') {
				stack.push(cur);
				temp *= 3;
			} else if (cur == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break;
				} else if (str.charAt(i - 1) == '(') {
					result += temp;
				}

				stack.pop();
				temp /= 2;
			} else if (cur == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				} else if (str.charAt(i - 1) == '[') {
					result += temp;
				}

				stack.pop();
				temp /= 3;
			}

		}
		
		if(!stack.isEmpty()) {
			result = 0;
		}
		
		System.out.println(result);

	}

}