package bak;

import java.util.Scanner;

public class Main_10773 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt(); // 입력 받은 크기 만큼 입력받음

		int[] array = new int[a]; // 배열에 입력받기

		for (int i = 0; i < a; i++) {
			array[i] = input.nextInt();
			// 0입력 받으면 앞에거 지우고 배열 크기 줄이기
			if (i > 0 && array[i] == 0) {
				array[i - 1] = 0;
				i = i - 2; // 3
				a = a - 2; // 9
			}
		}

		int sum = 0;

		for (int i = 0; i < a; i++) {
			sum = sum + array[i];
		}
		System.out.print(sum);

	}
}

//1. Stack Class 이용
//
//Stack 클래스를 import 하여 사용할 경우 아래와 같이 간단하게 짤 수 있다.
//
//Stack<Integer> stack = new Stack<Integer>();
//		
//int K = input();	// K 정수 입력(입력 개수)
//		
//for(int i = 0; i < K; i++) {
//	int number = input();	// 정수 입력
//    
//	if(number == 0) {	// 0이라면 스택에 저장된 top 원소를 지운다.
//		stack.pop();
//	}
//	else {	// 아닐경우는 스택에 원소 추가
//		stack.push(number);
//	}
//}
// 
//int sum = 0;
//for(int o : stack) {	// 스택에 담긴 원소 합 구하기 
//	sum += o;
//}

//------------------------------------------------------------

//2. 다른 풀이
//int top = -1;	// 마지막 원소의 위치를 가리키는 변수
//
//int K = input();	// 입력 개수
//int[] arr = new int[K];	// 최대 원소 개수는 K개를 넘지 못함
//		
// 
//for(int i = 0; i < K; i++) {
//			
//	int number = input();	// 정수 입력
//			
//	if (number == 0) {	// 0 이라면 top 위치에 있는 원소를 0으로 초기화 
//		arr[top] = 0;
//		top--;	// top이 가리키는 위치 1 감소
//	} 
//	else {
//		top++;	// top이 가리키는 위치 1 증가
//		arr[top] = number;	// 입력받은 정수로 초기화
//	}
//}
// 
//int sum = 0;
//for(int i = 0; i < K; i++) {	// 배열 원소 전체 합 구하기
//	sum += arr[i];
//}	
