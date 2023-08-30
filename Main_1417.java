package bak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1417 {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[n-1];
        for (int i = 0; i < n-1; i++) arr[i] = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (true) {
            Arrays.sort(arr);
            if (arr[n-2] < a) break;
            cnt++;
            arr[n-2]--;
            a++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main_1417().solution();
    }
}
