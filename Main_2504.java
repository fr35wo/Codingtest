package bak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> ch = new Stack<Character>();

        String line = br.readLine();
        boolean isCheck = true; // 올바른 괄호열인지
        int count = 1;
        int result = 0; // 결과값
        char temp;

        for (int j = 0; j < line.length(); j++) {
            temp = line.charAt(j);

            if (temp == '(') {
                ch.push(temp);
                count *= 2;
            } else if (temp == '[') {
                ch.push(temp);
                count *= 3;
            } else {
                if (temp == ')') {
                    if (ch.isEmpty() || ch.peek() != '(') { // 올바르지 않은 괄호열
                        isCheck = false;
                        break;
                    }
                    if (j > 0 && line.charAt(j - 1) == '(') { // 올바르게 닫히면 result에 값 추가
                        result += count;
                    }
                    ch.pop();
                    count /= 2;
                } else if (temp == ']') {
                    if (ch.isEmpty() || ch.peek() != '[') { // 올바르지 않은 괄호열
                        isCheck = false;
                        break;
                    }
                    if (j > 0 && line.charAt(j - 1) == '[') { // 올바르게 닫히면 result에 값 추가
                        result += count;
                    }
                    ch.pop();
                    count /= 3;
                } else {
                    isCheck = false;
                    break;
                }

            }

        }
        if (!isCheck || !ch.isEmpty()) { // 올바르지 않은 괄호열
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }
}


//정수와 문자가 섞여 있으므로 스택 내부에서 사칙연산을 처리하기에는 어려움이 있었다. 그래서 스택 외부에서 결과값을 구해냈다.
//곱셈을 해주기 위해 count값을 따로 설정하였다.