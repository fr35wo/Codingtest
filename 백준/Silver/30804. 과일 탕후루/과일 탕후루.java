import java.io.*;
import java.util.*;

public class Main { //투포인터(슬라이딩 윈도우)
	public static void main(String args[]) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());  
	        int[] fruits = new int[N]; // 과일 종류 배열

	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < N; i++) {
	            fruits[i] = Integer.parseInt(st.nextToken());
	        }

	        HashMap<Integer, Integer> fruitsCnt = new HashMap<>(); // 종류, 개수
	        int maxLength = 0; 
	        int left = 0 ;
	        
	        for(int right=0; right<N; right++) {
	        	fruitsCnt.put(fruits[right], fruitsCnt.getOrDefault(fruits[right], 0) + 1);
	        
	        	while (fruitsCnt.size() > 2) {
	                fruitsCnt.put(fruits[left], fruitsCnt.get(fruits[left]) - 1); //현재 윈도우의 가장 왼쪽에 있는 과일의 개수를 하나 줄입니다.

	                if (fruitsCnt.get(fruits[left]) == 0) {
	                    fruitsCnt.remove(fruits[left]);
	                }

	                left++;
	            }
	            maxLength = Math.max(maxLength, right - left + 1);
	        
	        }
	        
	       System.out.println(maxLength);
		
	}
}
