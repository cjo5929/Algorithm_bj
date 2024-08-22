import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k, result;
    static ArrayList<Integer> list;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++){
            list.add(arr[i] - arr[i - 1]);
        }

        Collections.sort(list);

        for(int i = 0; i < n - k; i++){
            result += list.get(i);
        }

        System.out.println(result);

    }
}