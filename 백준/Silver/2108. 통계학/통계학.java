import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int numbers[] = new int [N];
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		
		double sum = 0;
		
		for(int i=0; i<N; i++) {
			sum += numbers[i]; 
		}
		
		int first = (int)Math.round(sum/(double)N);
		sb.append(first).append("\n");
		
		Arrays.sort(numbers);
		
		int midIndex = N/2;
		
		sb.append(numbers[midIndex]).append("\n");
		
		boolean flag = false;
		int mode_max = 0;
		int mode = 10000;
		
		for(int i = 0; i < N; i++) {
			int jump = 0;	// 동일한 수가 나온만큼 i 값 jump 시킬 변수 
			int count = 1;
			int i_value = numbers[i];
			
			for(int j = i + 1; j < N; j++){
				if(i_value != numbers[j]) {
					break;
				}
				count++;
				jump++;
			}
			
			if(count > mode_max) {
				mode_max = count;
				mode = i_value;
				flag = true;
			}
			else if(count == mode_max && flag == true) {
				mode = i_value;
				flag = false;
			}
			
			i += jump;
		}
		
		sb.append(mode).append("\n");
		sb.append(numbers[N-1] - numbers[0]).append("\n");
		System.out.print(sb);
	}
}
