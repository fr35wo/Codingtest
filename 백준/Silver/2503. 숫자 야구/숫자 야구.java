import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		boolean answer[] = new boolean[1000];

		for (int i = 123; i < 1000; i++) {
			String str = Integer.toString(i);

			// 문제에 따르면 숫자 내부에 0이 있을 경우는 정답으로 가능하지 않으므로 제외
			if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0')
				continue;

			// 문제에 따르면 모든 자릿수의 숫자가 달라야 하기 때문에 같은 숫자가 있을 경우 제외
			if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2))
				continue;
			answer[i] = true;
		}

		for (int i = 0; i < N; i++) {
			// 입력받은 값과 정답과의 스트라이크와 볼 값
			st = new StringTokenizer(br.readLine());
			int req = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for (int j = 123; j < 1000; j++) {

				if (answer[j]) {
					int ns = 0;
					int nb = 0;

					for (int k = 0; k < 3; k++) {
						char req_num = Integer.toString(req).charAt(k);

						for (int h = 0; h < 3; h++) {

							char ans_num = Integer.toString(j).charAt(h);

							if (req_num == ans_num && k == h)
								ns++;
							else if (req_num == ans_num && k != h)
								nb++;
						}
					}

					if(ns == s && nb == b) {
						answer[j] = true;
					} else {
						answer[j] = false;
					}
					
				}

			}

		}
		int ans = 0;
		
        for(int i=123;i<1000;i++){
            if(answer[i]) ans++;
        }

        System.out.println(ans);
	}
}
