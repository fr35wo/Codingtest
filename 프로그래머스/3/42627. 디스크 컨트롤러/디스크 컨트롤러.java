import java.util.*;

class Solution {
	public int solution(int[][] jobs) {
		// 작업을 요청 시간 기준으로 정렬
		Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

		// 소요 시간 기준으로 정렬하는 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		int answer = 0;
		int end = 0; // 수행되고난 직후의 시간
		int jobsIdx = 0; // jobs 배열의 인덱스
		int count = 0; // 수행된 요청 갯수
		
		// 요청이 모두 수행될 때까지 반복
		while (count < jobs.length) {

			// 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
			while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
				pq.add(jobs[jobsIdx++]); //인덱스의 행 전체를 추가 (2차원 배열의 특정 행 자체가 1차원 배열 객체)
			}

			// 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
			// (end를 요청의 가장 처음으로 맞춰줌)
			if (pq.isEmpty()) {
				end = jobs[jobsIdx][0];

				// 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
			} else {

				int[] temp = pq.poll();
				answer += temp[1] + end - temp[0];
				end += temp[1];
				count++;
			}
		}

		return (int) Math.floor(answer / jobs.length);
	}
}
