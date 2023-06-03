package bak;

import java.util.Scanner;

public class Main_1193 {
	public static void main(String args[]) {
		Scanner input = new Scanner (System.in);
		int a = input.nextInt();
		int b = 0; //알아낸 수
		int i = 1;
		//주어진 값에 1부터 시작하는 오름차순 수를 빼고 남은 값이 다음 오름차순 수 일때
		while(true){
			
			if(b != 0) { //수를 알아내면 break
				break;
			} else if(a <= i ){ //다음 오름차순 수보다 작거나 같다면 
				b = a;
			} else {
				a = a - i;
			}
			i++;
		}
		
		if(i%2 == 0) { //i가 짝수일때
			System.out.print( i-b + "/" + b );
		} else {
			System.out.print( b + "/" + (i-b) );
		}
		
		
	}
}
