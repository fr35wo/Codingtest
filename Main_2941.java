package bak;

import java.util.Scanner;

public class Main_2941 {
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		String word = input.next();
		
		char [] array = new char [word.length()];
		int count= 0;
		
		for(int i=0;i<array.length;i++) { //입력받은 문자열 배열에 넣기
			array[i] = word.charAt(i);
		}
		
		for(int i=0;i<array.length;i++) {
			if(array[i] == 'd') {
				if(i<array.length-1) { //array.length+1로 하면 맨 뒤에 검사시 에러남
					if(array[i+1] == 'z') {
						if(i<array.length-2) {
							if(array[i+2] == '=') {
								i++;
							}
						}
					}
				}
			}
			if(array[i] == 'c') {
				if(i<array.length-1) {
					if(array[i+1] == '=') {
						i++;
					}
				}
			}
			if(array[i] == 'c') {
				if(i<array.length-1) {
					if(array[i+1] == '-') {
						i++;
					}
				}
			}
			if(array[i] == 'd') {
				if(i<array.length-1) {
					if(array[i+1] == '-') {
						i++;
					}
				}
			}
			if(array[i] == 'l') {
				if(i<array.length-1) {
					if(array[i+1] == 'j') {
						i++;
					}
				}
			}
			if(array[i] == 'n') {
				if(i<array.length-1) {
					if(array[i+1] == 'j') {
						i++;
					}
				}
			}
			if(array[i] == 's') {
				if(i<array.length-1) {
					if(array[i+1] == '=') {
						i++;
					}
				}
			}
			if(array[i] == 'z') {
				if(i<array.length-1) {
					if(array[i+1] == '=') {
						i++;
					}
				}
			}
			
			
			count++;
		}
		System.out.print(count);
		
	}
}
