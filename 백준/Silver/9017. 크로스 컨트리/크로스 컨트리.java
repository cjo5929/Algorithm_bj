import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int t, n, teamCount;
    static int [] arr, count, fifth, score, check;


    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        for(int test = 0; test < t; test++) {

            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            count = new int[202];
            fifth = new int[202];
            score = new int[202];
            check = new int[202];
            teamCount = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                count[arr[i]]++;
                teamCount = Math.max(teamCount, arr[i]);

            }

            int cnt = 0;
            for(int i = 1; i <= n; i++){
                if(count[arr[i]] < 6) {
                    cnt++;
                    fifth[arr[i]] = Integer.MAX_VALUE;
                    score[arr[i]] = Integer.MAX_VALUE;
                }else if(check[arr[i]] < 4){
                    score[arr[i]] += i - cnt;
                    check[arr[i]]++;
                }else if(check[arr[i]] == 4) {
                    fifth[arr[i]] = i - cnt;
                    check[arr[i]]++;
                }
            }

            int bestTeam = 0;
            int bestScore = Integer.MAX_VALUE;
            fifth[0] = Integer.MAX_VALUE;

            for(int i = 1; i <= teamCount; i++){
                if(score[i] < bestScore){
                    bestScore = score[i];
                    bestTeam = i;
                }
                else if(score[i] == bestScore && fifth[i] < fifth[bestTeam]){
                    bestTeam = i;
                }
            }
            System.out.println(bestTeam);

        }
    }
}