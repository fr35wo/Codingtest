package bak;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1475 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt(); //방 번호 입력
		
		ArrayList<Integer> arrNum = new ArrayList<>(); //방 번호 배열
		while(num > 0) {
			arrNum.add(num %10);
			num /= 10;
		}
		
		int array[] = new int[10]; //0~9까지 visited 배열
		for(int i=0;i<arrNum.size();i++) {
			array[arrNum.get(i)]++; //visited배열에서 카운팅
		}
		
		int sum = array[6] + array[9];
		array[6] = 0;
		array[9] = 0;
		int result = 0;
		if(sum%2 == 1) {
			result = sum/2 +1;
		} else {
			result = sum/2;
		}
		
		Arrays.sort(array);
		if(array[9] > result) {
			System.out.println(array[9]);
		} else {
			System.out.println(result);
		}
		
	}
}

//ArrayList를 사용할 필요없이 처음부터 visited배열에 카운팅을 해야한다. 
