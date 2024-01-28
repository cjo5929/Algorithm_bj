import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		br = new BufferedReader(new StringReader(str));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sb.append("Case #").append(t).append(": ").append(x + " + " + y + " = ").append(x+y).append("\n");
			
		}
		
		System.out.println(sb);
		
//		String data = "hong:30,20,70";
//		st = new StringTokenizer(data, ":,");
//		String name = st.nextToken();
//		int sum =  0;
//		while(st.hasMoreTokens()) {
//			sum+=Integer.parseInt(st.nextToken());
//		}
//		System.out.println(name+"의 총 합은 "+sum);

	}
	
	private static String str = "5\r\n"
			+ "1 1\r\n"
			+ "2 3\r\n"
			+ "3 4\r\n"
			+ "9 8\r\n"
			+ "5 2";
		
	

}