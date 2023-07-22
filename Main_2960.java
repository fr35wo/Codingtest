package bak;
import java.util.Scanner;
import java.util.ArrayList;

public class Main_2960 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i=2;i<=N;i++) {
			array.add(i);
		}
		
		int count = 0;
		int result = 0;
		
		while(count < K) {
			int min = array.get(0);
			
			for (int i = 0; i < array.size(); i++) {
                if (array.get(i) % min == 0) {
                    result = array.get(i);
                    array.remove(i);
                    count++;
                    
                    if (count == K) {
                        break;
                    }
                    
                    i--; // 배열 크기가 줄어들기 때문에 인덱스를 감소시켜야 다음 요소를 제대로 확인할 수 있음
                }
            }
			
			if (count == K) {
                break;
            }
			
		}
		
		System.out.println(result);
		
	}
}
