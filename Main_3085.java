package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3085 {

    static int N;
    static char[][] board;
    static int maxCandies = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) { //사탕 채우기
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 상하좌우로 사탕을 바꾸며 최대 개수 탐색
                swapAndSearch(i, j, i + 1, j);
                swapAndSearch(i, j, i, j + 1);
            }
        }

        System.out.println(maxCandies);
    }

    static void swapAndSearch(int x1, int y1, int x2, int y2) {
        if (x1 < 0 || x1 >= N || y1 < 0 || y1 >= N || x2 < 0 || x2 >= N || y2 < 0 || y2 >= N)
            return;

        // 사탕 위치를 바꿔주고 최대 개수 탐색
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;

        // 최대 개수 갱신
        maxCandies = Math.max(maxCandies, countMaxCandies());

        // 원래대로 돌려놓음
        temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    static int countMaxCandies() { //긴 수열 찾기
        int maxCount = 1;

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}

//행을 기준으로 오른쪽으로 탐색하면서 오른쪽 색상과 현재 색상을 바꿔주고 탐색하고 다시 돌려주기
//열을 기준으로 아래쪽으로 탐색하면서 아래쪽 색상과 현재 색상을 바꿔주고 탐색하고 다시 돌려주기
//행을 기준으로 왼쪽과 색을 변경해 줄 필요 없고 열을 기준으로 위쪽과 색을 변경해줄 필요 없다. 오른쪽 아래쪽을 바꿔가면서 변경했기 때문에 이미 바꿔줬던 색상이기 때문이다.
