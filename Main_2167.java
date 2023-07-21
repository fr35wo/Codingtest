package bak;
import java.util.Scanner;

public class Main_2167 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int a = sc.nextInt();
                array[i][j] = a;
            }
        }

        int K = sc.nextInt();
        int[] result = new int[K];

        for (int o = 0; o < K; o++) {
            int sum = 0;

            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int r = i - 1; r < x; r++) {
                for (int q = j - 1; q < y; q++) {
                    sum += array[r][q];
                }
            }

            result[o] = sum;
        }

        for (int i = 0; i < K; i++) {
            System.out.println(result[i]);
        }
    }
}
