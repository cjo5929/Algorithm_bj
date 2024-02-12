import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] p = new int[N];
        for(int i = 0 ; i<N; i++) {
            p[i] = sc.nextInt();
        }
        
		if(np(p)) {
			for(int val : p) {
				sb.append(val).append(" ");
			}
		}else {
			sb.append("-1");
		}
	
		System.out.println(sb);
    }
    
    //순열의 뒷쪽부터 작은 변화를 준다.
    public static boolean np(int[] p) { //현순열의 사전 순 다음 순열 생성(p:현 순열)
        final int N = p.length;
        //step1 : 교환위치 찾기(뒤쪽부터 꼭대기를 찾으면 꼭대기 이전이 교환 위치가 됨)
        int i = N-1;
        while(i>0 && p[i-1]>=p[i]) --i;
        
        if(i==0) return false; //현 순열의 상태가 가장 큰 순열이므로 np 없다.
        
        
        //step 2 : 교환위치(i-1)에 넣을 값 뒤쪽부터 찾기(큰 값 중 최소값)
        int j = N-1;
        while(p[i-1] >= p[j]) --j;
        
        //step3 : 교환위치(i-1) 값과 찾은 위치(j)값 교환
        swap(p, i-1,j);
        
        //step4 : 꼭대기(i)위치부터 맨뒤까지 오름차순 정렬
        int k= N - 1;
        while(i<k) swap(p, i++, k--);
        
        return true;
    }
    
    public static void swap(int[] p, int i, int j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }
    

    
}