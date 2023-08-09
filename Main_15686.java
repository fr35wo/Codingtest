package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_15686 {

	static int N;
	static int M;
	static int[][] array;
	static ArrayList<Point> person;
	static ArrayList<Point> chicken;
	static int ans;
	static boolean[] open;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 결과 값 출력위해 쌓아둘 곳
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // array 길이
		M = Integer.parseInt(st.nextToken()); // 치킨집 개수

		array = new int[N][N]; // array 생성

		person = new ArrayList<>();
		chicken = new ArrayList<>();

		// 입력된 지도 정보를 읽고, 집과 치킨집의 좌표를 ArrayList에 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken()); // array 채우기

				if (array[i][j] == 1) {
					person.add(new Point(i, j)); // 집 좌표 저장
				} else if (array[i][j] == 2) {
					chicken.add(new Point(i, j)); // 치킨집 좌표 저장
				}
			}
		}

		ans = Integer.MAX_VALUE; // 정답 초기화
		open = new boolean[chicken.size()]; // 선택된 치킨집 여부 배열 초기화

		DFS(0, 0); // 조합을 이용하여 최적 치킨집 선택 및 최소 거리 계산
		System.out.println(ans); // 최종 결과 출력
	}

	// 조합을 구하는 함수
	public static void DFS(int start, int cnt) {
		if (cnt == M) { // 치킨집을 M개 선택한 경우
			int res = 0; // 현재 선택된 M개의 치킨집과 모든 집과의 최소 거리를 계산하기 위한 변수

			for (int i = 0; i < person.size(); i++) {
				int temp = Integer.MAX_VALUE; // 현재 집과 선택된 M개의 치킨집 중 가장 가까운 거리를 저장하는 변수

				// 현재 집과 선택된 M개의 치킨집 중 가장 가까운 거리 계산
				for (int j = 0; j < chicken.size(); j++) {
					if (open[j]) {
						int distance = Math.abs(person.get(i).x - chicken.get(j).x)
								+ Math.abs(person.get(i).y - chicken.get(j).y);

						temp = Math.min(temp, distance);
					}
				}
				res += temp; // 모든 집에 대한 최소 거리를 누적하여 계산
			}
			ans = Math.min(ans, res); // 최소 거리의 합과 현재까지의 최소 거리의 합 비교하여 갱신
			return;
		}

		// 백트래킹
		for (int i = start; i < chicken.size(); i++) {
			open[i] = true; // 현재 치킨집 선택
			DFS(i + 1, cnt + 1); // 다음 치킨집을 선택하기 위해 재귀 호출
			open[i] = false; // 현재 치킨집 선택 해제
		}
	}

}
