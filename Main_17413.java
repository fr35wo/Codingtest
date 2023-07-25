package bak;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); //결과 값 출력위해 쌓아둘 곳
		String str = br.readLine();// 입력 문자열
		Stack<Character> stack = new Stack<>(); //char형 스택 선언
		
		boolean flag = false; // < >구분위한 flag
		
		for(int i=0;i<str.length();i++) {
			
			if (str.charAt(i) == '<') { //< 일때 스택 안비워져 있으면 비워주고 
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
            } else if (str.charAt(i) == '>'){ //> 일때 flag바꿔주고 그대로 출력
            	flag = false;
                sb.append(str.charAt(i));
                continue;
            }
			
			if(flag == true) { //flag 가 true일땐 > 전까지 그대로 입력
				sb.append(str.charAt(i));
			} else if (flag == false) { //flag false일때 < > 이외 문자 처리
				
				if(str.charAt(i) == ' ') { //공백일때 모든 문자 pop 후 공백 추가
					while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;                   
				} else {
					stack.push(str.charAt(i));
				}
			}
			
			if(i == str.length()-1) { //마지막에 스택 비우고 pop
				while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
			}
			
		}
		
		 System.out.println(sb);
		 
	}
}
