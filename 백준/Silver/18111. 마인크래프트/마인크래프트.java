import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int [][] arr = new int [N][M];
		int min = 256;
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(min > arr[i][j]) min = arr[i][j];
				if(max < arr[i][j]) max = arr[i][j];
			}
		}
		
		int time = Integer.MAX_VALUE;
		int high = 0;
		
		for(int k = max; k >= min; k-- ) { // 높이가 제일 높은곳 부터 시작
			int count = 0;
			int block = B;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					//인벤토리 블록으로 가능한지
					if(arr[i][j] < k) {
						block -= (k - arr[i][j]);	//인벤토리에서 블록 꺼내기
						count += (k - arr[i][j]);	//시간 늘리기
					} else if(arr[i][j] == k) {
						continue;
					} else {
						count += ((arr[i][j] - k) * 2);
						block += (arr[i][j] - k);
					}
				}
			}
			
			if(block < 0) continue;
			
			if(time > count || (time == count && high < k)) {
				time = count;
				high = k;
			}
			
		}
		
		sb.append(time).append(" ").append(high);
		System.out.print(sb);
		
	}
}
