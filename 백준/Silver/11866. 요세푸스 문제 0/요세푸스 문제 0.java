import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> deque = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		sb.append('<');
		
		while(deque.size() > 1) {
			
			for(int i=0; i< K-1; i++) {
				deque.offer(deque.poll());
			}
			
			sb.append(deque.poll() + ", ");
			
		}
		
		sb.append(deque.poll()).append('>');
		System.out.println(sb);
	}
}
