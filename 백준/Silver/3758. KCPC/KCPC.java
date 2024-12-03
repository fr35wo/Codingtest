import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 개수
		
		for(int a=0; a<T; a++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken()); //팀 개수
			int k = Integer.parseInt(st.nextToken()); // 문제의 개수
			int t = Integer.parseInt(st.nextToken()); // 내 팀 ID
			int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수
			
			Team[] list = new Team[n];
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int teamID = Integer.parseInt(st.nextToken());
				int problemNum = Integer.parseInt(st.nextToken());
				int score = Integer.parseInt(st.nextToken());

				if (list[teamID - 1] == null) {
					list[teamID - 1] = new Team();
					list[teamID - 1].id = teamID;
					list[teamID - 1].scoreList = new int[k + 1];
				}
				
				list[teamID - 1].scoreList[problemNum] = Math.max(score, list[teamID - 1].scoreList[problemNum]);
				list[teamID - 1].submitNum++;
				list[teamID - 1].lastSubmit = i;
				
			}
			
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 1; j <= k; j++) {
					sum += list[i].scoreList[j];
				}
				list[i].totalScore = sum;
			}
			
			Arrays.sort(list, (o1, o2) -> {
			    if (o1.totalScore == o2.totalScore) {
			        if (o1.submitNum == o2.submitNum) {
			            // 제출 횟수는 적은 것이 좋다.
			            return o1.lastSubmit - o2.lastSubmit;
			        }
			        return o1.submitNum - o2.submitNum;
			    }
			    // 점수는 높은 것이 좋다.
			    return o2.totalScore - o1.totalScore;
			});
			
			for (int i = 0; i < n; i++) {
				if (list[i].id == t) {
					sb.append(String.valueOf(i + 1) + "\n");
				}
			}
			
		}
		
		System.out.println(sb);
		
	}
	
	static class Team {
		int id;
		int[] scoreList;
		int submitNum;
		int lastSubmit;
		int totalScore;

	}

	
}
