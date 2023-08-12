package bak;

import java.io.*;
import java.util.*;

public class Main_2477 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); // 참외 개수

        // 각 변의 방향과 길이를 저장할 배열
        int[] direction = new int[6];
        int[] length = new int[6];

        int finalHigh = 0; // 최종 높이
        int finalWidth = 0; // 최종 너비
        int noArea = 0; // 제외되는 넓이

        // 6개의 변 정보 입력받기
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            direction[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());

            // 방향에 따라 최종 너비 또는 높이 갱신
            if (direction[i] == 1 || direction[i] == 2) {
                finalWidth = Math.max(finalWidth, length[i]);
            } else if (direction[i] == 3 || direction[i] == 4) {
                finalHigh = Math.max(finalHigh, length[i]);
            }
        }

        // 제외되는 영역의 넓이 계산
        for (int i = 0; i < 6; i++) {
            if (direction[i] == direction[(i + 2) % 6] && direction[(i + 1) % 6] == direction[(i + 5) % 6]) {
                noArea = length[i] * length[(i + 1) % 6];
                break;
            } else if(direction[i] == direction[(i + 1) % 6] && direction[(i + 2) % 6] == direction[(i + 4) % 6]) {
                noArea = length[i] * length[(i + 2) % 6];
                break;
            }
        }

        // 총 넓이 계산 및 출력
        int totalArea = (finalHigh * finalWidth - noArea) * K;
        System.out.println(totalArea);

        br.close();
    }
}
