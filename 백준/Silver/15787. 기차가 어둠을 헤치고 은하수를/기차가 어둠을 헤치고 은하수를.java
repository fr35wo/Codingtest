import java.io.*;
import java.util.*;

public class Main {

	static int[] trains;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		trains = new int[N+1];
		
		for(int i=0;i<M;i++) {
			excute(br.readLine());
		}
		
		HashSet<Integer> set = new HashSet<>();
		for(int i=1;i<N+1;i++) {
			set.add(trains[i]);
		}
		
		System.out.println(set.size());
		
	}
	
	public static void excute(String command) {
		StringTokenizer st = new StringTokenizer(command);
		
		int c = Integer.parseInt(st.nextToken()); // 명령
		int i = Integer.parseInt(st.nextToken()); // 기차 번호
		int x = -1; // 좌석 번호 (1-based -> 0-based)
		
		switch (c){
		// i번째 기차 x번째 좌석에 사람 태우기
		case 1:
			x += Integer.parseInt(st.nextToken());
			trains[i] |= (1 << x);
			break;
		// i번째 기차 x번째 좌석의 사람 하차시키기
		case 2:
			x += Integer.parseInt(st.nextToken());
			trains[i] &= ~(1 << x);
			break;
		// i번째 기차 한 칸씩 뒤로 밀고 맨 뒤 사람 하차시키기
		case 3:
			trains[i] = (trains[i] & ~(1 << 19)) << 1 ;
			break;
		// i번째 기차 맨 앞 사람 하차시키고 한 칸씩 앞으로 당기기
		case 4:
			trains[i] = (trains[i] & ~(1 << 0)) >> 1 ;
			break;
		}
	}

}
