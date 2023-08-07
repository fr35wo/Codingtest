package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1748 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 입력
        int count = Integer.toString(N).length();
        int result = 0;

        for (int i = 1; i < count; i++) {
            result = result + i * (9 * (int) Math.pow(10, i - 1));
        }

        result = result + count * (N - (int) Math.pow(10, count - 1) + 1);
        System.out.println(result);
    }
}

//자릿수 별로 누적 하는 방법
//int n = Integer.parseInt(br.readLine());
//int num = 1;
//int cnt = 0;
//while(num <= n)
//{
//    cnt += (n - num + 1);
//    num *= 10;
//}
//System.out.print(cnt);
//}
