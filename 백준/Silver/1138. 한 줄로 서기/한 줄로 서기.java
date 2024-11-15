import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int line[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//빈칸 개수 셌을때 맞으면 +1인덱스가 자리. 그자리 차있으면 한칸뒤로반복
		for(int i=0; i<N; i++) {
			int leftCount = Integer.parseInt(st.nextToken());
			int count = 0;
			
			for (int j = 0; j < N; j++) {
				if(line[j] == 0) {
					if(count == leftCount) {
						line[j] = i + 1;
						break;
					}
					
					count++;
					
				}
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(line[i] + " ");
		}
		System.out.println(sb);
			
	}
}
