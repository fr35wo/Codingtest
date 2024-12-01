import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        int newArr = N;

        int[] dx = {0, 1, 0, 1};
        int[] dy = {0, 0, 1, 1};

        for (int i = 0; i < newArr; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < newArr; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (newArr != 1) {
            newArr = newArr / 2;
            int[][] answer = new int[newArr][newArr];
            for (int i = 0; i < newArr; i++) {
                for (int j = 0; j < newArr; j++) {
                    int[] second = new int[4];
                    for (int k = 0; k < 4; k++) {
                        int x = i * 2 + dx[k];
                        int y = j * 2 + dy[k];
                        second[k] = arr[x][y];
                    }
                    Arrays.sort(second);
                    answer[i][j] = second[2];
                }
            }
            arr = answer;
        }

        System.out.println(arr[0][0]);
    }
}
