import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 사진틀 개수
		int total_reco = Integer.parseInt(br.readLine()); // 총 추천 개수

		int arr[] = { 1, 0 }; // index 0추천수 1오래된순

		Map<Integer, int[]> hashMap = new HashMap<>(N);
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < total_reco; i++) {
			int student_num = Integer.parseInt(st.nextToken());

			if (hashMap.containsKey(student_num)) { // 추천 수 증가
				hashMap.get(student_num)[0]++;
			} else {

				if (hashMap.size() >= N) {
					int minRecommend = Integer.MAX_VALUE;
					int oldestIndex = -1;
					int keyToRemove = -1;

					for (Map.Entry<Integer, int[]> entry : hashMap.entrySet()) {
						int key = entry.getKey();
						int[] value = entry.getValue();
						if (value[0] < minRecommend) {
							minRecommend = value[0];
							oldestIndex = value[1];
							keyToRemove = key;
						} else if (value[0] == minRecommend) {
							// 추천 수가 같은 경우, 오래된 순서를 비교
							if (value[1] < oldestIndex) {
								oldestIndex = value[1];
								keyToRemove = key;
							}
						}
					}

					// 가장 적은 추천 수이면서 오래된 순서의 학생 제거
					hashMap.remove(keyToRemove);
				}

				// 새로 추가
				hashMap.put(student_num, new int[] { 1, i });
			}

		}

		List<Integer> result = new ArrayList<>(hashMap.keySet());
		Collections.sort(result);
		for (int student : result) {
			sb.append(student).append(" ");
		}
		System.out.println(sb);

	}
}
