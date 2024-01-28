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
		
		char[] s = br.readLine().toCharArray();
		
		for(int i = 1; i <= s.length; i++) {
			sb.append(s[i-1]);
			if(i % 10 == 0) {
				sb.append("\n");
			}
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
	
	private static String str = "OneTwoThreeFourFiveSixSevenEightNineTen";
		
	

}