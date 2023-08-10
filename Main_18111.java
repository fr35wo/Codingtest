package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 세로 길이
        int M = Integer.parseInt(st.nextToken()); // 가로 길이
        int B = Integer.parseInt(st.nextToken()); // 인벤토리 블록 개수

        int[][] array = new int[N][M]; // 땅 생성

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken()); // array 채우기
            }
        }

        int min_time = Integer.MAX_VALUE;
        int result_height = 0; // 최소 시간에 해당하는 높이

        // 가능한 모든 높이에 대해서 루프
        for (int h = 0; h <= 256; h++) {
            int block = B; // 갖고있는 블록 수
            int time = 0; // 총 시간

            // 모든 칸을 돌면서 높이를 맞추기 위한 블록 사용량과 시간 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = array[i][j] - h; // 현재 칸과 목표 높이의 차이

                    if (diff > 0) { // 현재 칸의 높이가 목표 높이보다 높을 경우
                        time += diff * 2; // 차이만큼 블록 쌓아서 높이를 맞춤
                        block += diff; // 블록 사용
                    } else { // 현재 칸의 높이가 목표 높이보다 낮을 경우
                        time += Math.abs(diff); // 차이만큼 블록 파내서 높이를 맞춤
                        block -= Math.abs(diff); // 블록 회수 (파낸만큼)
                    }
                }
            }

            // 조건을 만족하는 경우에만 결과 업데이트
            if (block >= 0 && time <= min_time) {
                min_time = time;
                result_height = h;
            }
        }

        // 최종 결과 출력
        System.out.println(min_time + " " + result_height);
    }
}
