import java.awt.Point;

/**
 * @author 강민서
 * @date 2024.02.05
 * @link https://www.acmicpc.net/problem/2493
 * @keyword_solution  
 * 
 * @input 
 * @output   
 * @time_complex  
 * @perf 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static Deque<Point> input_stack = new ArrayDeque<>();
	static Deque<Point> output_stack = new ArrayDeque<>();
	static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			input_stack.add(new Point(Integer.parseInt(st.nextToken()), i + 1));
		}

		
		for(int i = 0; i < N; i++) {
			Point p = input_stack.pop();
			check = false;
			
			while(!output_stack.isEmpty()) {
				Point compare = output_stack.peek();

				if (compare.x > p.x) {
					sb.append(compare.y + " ");
					output_stack.push(p);
					check = true;
					break;
					
				} else {
					output_stack.pop();
	
				}
				
				
			}
			
			if(check == false) {
				output_stack.push(p);
				sb.append(0 + " ");
			}

		}

	

		

		System.out.println(sb);
	}

}