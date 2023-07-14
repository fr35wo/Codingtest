package bak;
import java.util.Scanner;

public class Main_2563 {
	public static void main(String args[]) {
		int [][] array = new int [100][100]; //흰색 도화지
		
		Scanner input = new Scanner(System.in);
		int num = input.nextInt(); //색종이의 수
		
		int [] arr = new int [2*num]; //입력 받은 숫자 배열
		
		for(int i=0;i<num*2;i++) {
			int x = input.nextInt();
			arr[i] = x;
		}
		
		for(int k=0;k<arr.length;k+=2) {
			
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					array[arr[k]+i][arr[k+1]+j] = 1;
				}			
			}
			
		}
		
		int count = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(array[i][j] == 1) {
					count++;
				}
							
			}			
		}
		
		System.out.println(count);
		
		
		
	}
}
