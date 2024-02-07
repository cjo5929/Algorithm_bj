/**
 * @author 강민서
 * @date 2024.02.07
 * @link 
 * @keyword_solution  케이스 별로 돌리는 조건을 잘 확인! 
 * 연산은 공백으로 구분되어져 있고, 문제에서 설명한 연산 번호이며, 순서대로 적용시켜야 한다. => 한 가지만 주어지지 않음 
 * @input 
 *  2 ≤ N, M ≤ 100
	1 ≤ R ≤ 1,000
    N, M은 짝수
    1 ≤ Aij ≤ 108
    => 최악의 경우 O(N^2) 완전탐색해도 무방
 * @output  배열의 형태로 출력 
 * @time_complex   O(N^2)
 * @perf 71676	744
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, R, turn, answer, n_half, m_half;
	static int[][] arr, copied;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		copied = new int[N][M];
		n_half = N / 2;
		m_half = M / 2;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			answer = Integer.parseInt(st.nextToken());

			switch (answer) {
			case 1:
				case_1();
				break;

			case 2:
				case_2();
				break;
				
			case 3:
				case_3();
				break;
				
			case 4:
				case_4();
				break;
				
			case 5:
				case_5();
				break;
				
			case 6:
				case_6();
				break;

			}
		}


//		기본출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(copied[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void case_1() {
//		case 1 : 상하반전

		copied = new int[N][M];
		for (int i = 0; i < N; i++) {
			copied[i] = Arrays.copyOf(arr[N - i - 1], M);
		}
		
		arr = copied;
	}

	static void case_2() {
//		case 2 : 좌우반전
		
		copied = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copied[i][j] = arr[i][M - j - 1];
			}
		}
		
		arr = copied;

	}

	static void case_3() {
//		case 3 : 오른쪽 90도 회전
		
		copied = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				copied[i][j] = arr[N - j - 1][i];
			}
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		arr = copied;

	}

	static void case_4() {
		
//		case 4 : 왼쪽 90도 회전
		copied = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				copied[i][j] = arr[j][M - i - 1];
			}
		}
		
		int temp = N;
		N = M;
		M = temp;
		
		arr = copied;

	}

	static void case_5() {


//		case 5 : 1 > 2 > 3 > 4 > 1

		copied = new int[N][M];
		n_half = N / 2;
		m_half = M / 2;
		
		for (int i = 0; i < n_half; i++) {
			for (int j = 0; j < m_half; j++) {
				copied[i][j] = arr[i + n_half][j];
			}
		}

		for (int i = 0; i < n_half; i++) {
			for (int j = m_half; j < M; j++) {
				copied[i][j] = arr[i][j - m_half];
			}
		}

		for (int i = n_half; i < N; i++) {
			for (int j = m_half; j < M; j++) {
				copied[i][j] = arr[i - n_half][j];
			}
		}

		for (int i = n_half; i < N; i++) {
			for (int j = 0; j < m_half; j++) {
				copied[i][j] = arr[i][j + m_half];
			}
		}
		
		arr = copied;

	}

	static void case_6() {
//		case 6 : 1 > 2 > 3 > 4 > 1
		
		copied = new int[N][M];
		n_half = N / 2;
		m_half = M / 2;
		
		for (int i = 0; i < n_half; i++) {
			for (int j = 0; j < m_half; j++) {
				copied[i][j] = arr[i][j + m_half];
			}
		}

		for (int i = 0; i < n_half; i++) {
			for (int j = m_half; j < M; j++) {
				copied[i][j] = arr[i + n_half][j];
			}
		}

		for (int i = n_half; i < N; i++) {
			for (int j = m_half; j < M; j++) {
				copied[i][j] = arr[i][j - m_half];
			}
		}

		for (int i = n_half; i < N; i++) {
			for (int j = 0; j < m_half; j++) {
				copied[i][j] = arr[i - n_half][j];
			}
		}
		
		arr = copied;

	}

}