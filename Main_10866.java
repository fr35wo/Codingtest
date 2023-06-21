package bak;

import java.io.BufferedReader; //입력을 라인 단위로 읽기 위해 
import java.io.IOException; //입출력 동작 중 발생하는 예외 처리를 위해
import java.io.InputStreamReader; //System.in으로부터 입력을 받기 위해 
import java.util.ArrayDeque;


public class Main_10866{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();

        int N = Integer.parseInt(br.readLine()); //입력의 개수인 N을 br.readLine()을 통해 읽어 정수로 변환.
        
        for (int i = 0; i < N; i++) {
        	String[] s = br.readLine().split(" "); // 입력된 문자열을 공백을 기준으로 나누어서 문자열 배열에 저장
           
            switch (s[0]) {

                case "push_front": {
                    dq.addFirst(Integer.parseInt(s[1])); //문자열을 정수로 변환
                    break;
                }

                case "push_back": {
                    dq.addLast(Integer.parseInt(s[1]));
                    break;
                }

                case "pop_front": {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.pollFirst());
                    }
                    break;
                }

                case "pop_back": {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.pollLast());
                    }
                    break;
                }

                case "size": {
                    System.out.println(dq.size());
                    break;
                }

                case "empty": {
                    if (dq.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                }

                case "front": {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.peekFirst());
                    }
                    break;
                }

                case "back": {
                    if (dq.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq.peekLast());
                    }
                    break;
                }
               
            } 
           
        }
    }
}