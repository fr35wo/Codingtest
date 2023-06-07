package bak;

import java.util.Scanner;

public class Main_1316 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 단어의 개수 n
        int count = 0; // 그룹 단어 개수

        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.next();
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[26]; // 알파벳 방문 여부를 체크하는 배열

            for (int j = 0; j < array[i].length(); j++) {
                char c = array[i].charAt(j);
                if (j > 0 && c != array[i].charAt(j - 1) && visited[c - 'a']/*0부터니까*/) {
                    break; // c가 이전에 나온 문자와 같지 않고 이미 visited[c - 'a']가 true인 경우
                }
                visited[c - 'a'] = true; // 문자 방문 표시
                if (j == array[i].length() - 1) { //반복문이 종료 되지 않았다면
                    count++; // 그룹 단어인 경우 카운트를 증가합니다.
                }
            }
        }
        System.out.println(count);
    }
}