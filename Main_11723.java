package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
//시간초과
public class Main_11723 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int N = Integer.parseInt(br.readLine()); //입력의 개수인 N을 br.readLine()을 통해 읽어 정수로 변환.

		HashSet<Integer> set = new HashSet<Integer>(); // set 선언 //공집합 S
		
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" "); // 입력된 문자열을 공백을 기준으로 나누어서 문자열 배열에 저장
			switch (s[0]) {
			case "add":
				set.add(Integer.parseInt(s[1]));
				break;
			case "remove":
				set.remove(Integer.parseInt(s[1]));
				break;
			case "check":
				 if (set.contains(Integer.parseInt(s[1]))) {
                     System.out.println("1");
                 } else {
                     System.out.println("0");
                 }
				break;
			case "toggle":
				 if (set.contains(Integer.parseInt(s[1]))) {
                     set.remove(Integer.parseInt(s[1]));
                 } else {
                     set.add(Integer.parseInt(s[1]));
                 }
				break;
			case "all":
				set.clear();
				for (int j = 0; j < 20; j++) {
					set.add(j + 1);
				}
				break;
			case "empty":
				set.clear();
				break;

			}

		}

	}
}

//비트마스킹: 정수의 이진수 표현을 자료구조로 쓰는 기법 
//1.빠른 수행시간
//시간복잡도 O(1)에 구현되는 것이 많습니다. 비트마스크를 사용할 수 있다는 말은 원소의 수가 많지 않다는 뜻이기 때문에, 큰 속도 향상을 기대할 수는 없지만 여러번 수행해야 하는 경우에는 작은 최적화도 큰 속도 향상을 가져올 수 있습니다.
//2.간결한 코드
//양한 집합 연사자들을 반복문 없이 한 줄에 쓸 수 있습니다.
//3.작은 메모리 사용량
//적은 메모리를 사용할 수 있다는 말은 데이터를 미리 계산하여 저장해 둘 수 있으므로 캐시 효율이 좋다는 말입니다.
//4.연관 배열을 배열로 대체
//예로 연관 배열 객체 Map<Vector, int>가 있다고 합시다. 이 때 비트마스크를 이용해 정수 변수로 나타내면 단순 배열 int[]로 사용할 수 있습니다.

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int S = 0;
//        int M = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//        while (M-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            String str = st.nextToken();
//            if(str.equals("all")) S = (1 << 21) - 1;
//            else if(str.equals("empty")) S = 0;
//            else {
//                int num = Integer.parseInt(st.nextToken());
//                if(str.equals("add"))
//                    S |= (1 << num);
//                else if(str.equals("remove"))
//                    S &= ~(1 << num);
//                else if(str.equals("check"))
//                    sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
//                else if(str.equals("toggle"))
//                    S ^= (1 << num);
//            }
//        }
//        System.out.println(sb);
//    }
//}
