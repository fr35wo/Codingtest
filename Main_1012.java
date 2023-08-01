package bak;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1012 {
	
	static int M, N, K;
	static int count = 0;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] array;
	
	public static void DFS(int x, int y) {
		
		array[x][y] = 2;
		
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cy >= 0 && cx < N && cy < M) { 
				if (array[cx][cy] == 1) {
					DFS(cx, cy);
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 결과 값 출력위해 쌓아둘 곳
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 입력

		for (int i = 0; i < T; i++) { // 테스트 케이스 개수
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 가로 길이
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			K = Integer.parseInt(st.nextToken()); // 배추 개수

			array = new int[N][M]; // 배추밭 생성

			int[] x = new int[K]; // 배추 x위치
			int[] y = new int[K]; // 배추 y위치

			for (int j = 0; j < K; j++) { // 배추 심기
				st = new StringTokenizer(br.readLine(), " ");
				int Kx = Integer.parseInt(st.nextToken());
				int Ky = Integer.parseInt(st.nextToken());

				array[Ky][Kx] = 1; 

				x[j] = Ky; // x[j]에 Ky를 저장합니다.
				y[j] = Kx; // y[j]에 Kx를 저장합니다.
			}

			// 저장된 배추 위치에서 dfs 탐색
			for (int j = 0; j < K; j++) {
				if (array[x[j]][y[j]] == 1) {
					DFS(x[j], y[j]);
					count++;
				}
			}

			sb.append(count).append("\n"); 
		}

		System.out.print(sb);
	}
}
