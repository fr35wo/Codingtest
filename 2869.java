package bak;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();  // 낮에 올라가는 높이
        int b = input.nextInt();  // 밤에 내려가는 높이
        int v = input.nextInt();  // 나무 막대의 높이

        int c;  // 걸리는 일수

        // (v - a)는 마지막 날을 제외한 높이
        // (a - b)는 하루에 올라갔다 내려온 높이 차이
        // (v - a) % (a - b)는 마지막 날을 제외한 높이를 (a - b)로 나눈 나머지
        // 나머지가 0인 경우, 마지막 날에 정상에 도달한 것이므로 일수는 (v - a) / (a - b) + 1
        // 나머지가 0이 아닌 경우, 일수는 (v - a) / (a - b) + 2 (마지막 날에 정상에 도달하기 위해 하루 더 걸림)
        if ((v - a) % (a - b) == 0) {
            c = ((v - a) / (a - b)) + 1;
        } else {
            c = ((v - a) / (a - b)) + 2;
        }

        System.out.print(c);
    }
}

