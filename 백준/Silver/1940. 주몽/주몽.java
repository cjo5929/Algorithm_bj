import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;
	static int n, m, cnt, start, end, sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		
		int[] arr = new int[n];
		
		
		st = new StringTokenizer(br.readLine());
		
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		start = 0;
		end = n - 1;
		sum = arr[start] + arr[end];
		while(start != end) {
			if(sum < m) {
				
				start++;
				sum = arr[start] + arr[end];
				
			}else if(sum > m) {
				
				end--;
				sum = arr[start] + arr[end];
				
			}else {
				cnt++;
				start++;
				
				sum = arr[start] + arr[end];
			}
			
		}
		
		
//		2중 반복문으로 완탐
//		for(int i = 0; i < n - 1; i++) {
//			for(int j = i + 1; j < n; j++) {
//				if (arr[i] + arr[j] == m) {
//					cnt++;
//				}
//			}
//		}
		
	
		System.out.println(cnt);
		
		
		

	}

}