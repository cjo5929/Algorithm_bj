import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, student;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = (st.nextToken().equals("1"));
        }
        
        student = Integer.parseInt(br.readLine());
        for(int i = 0; i < student ; i++){
            st = new StringTokenizer(br.readLine());
            
            int gender = Integer.parseInt(st.nextToken()); 
            int num = Integer.parseInt(st.nextToken()); 
            
            if(gender == 1){
                for(int j = num; j <= n; j += num) { 
                    arr[j] = !arr[j];
                }
            } else {
                arr[num] = !arr[num];
                int left = num - 1;
                int right = num + 1;
                while(left >= 1 && right <= n && arr[left] == arr[right]) {
                    arr[left] = !arr[left];
                    arr[right] = !arr[right];
                    left--;
                    right++;
                }
            }
        }
        
  
        for(int i = 1; i <= n; i++) {
            sb.append(arr[i] ? "1 " : "0 ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.print(sb);
    }
}