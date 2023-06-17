package bak;
import java.util.Scanner;

public class Main_7568 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt(); //명수
		int [] number = new int[a]; //등수
		
		int [][] w = new int[a][2];
		
		for(int i=0;i<a;i++) { //입력받은 명수 만큼 몸무게 키, 입력받음
			int weight = input.nextInt();
			w[i][0] = weight; //배열에 넣기
			int height = input.nextInt();
			w[i][1] = height;
		}
		
		for (int i = 0; i < a; i++) {
            int k = 0; //자기보다 덩치 큰 사람
            for (int j = 0; j < a; j++) {

                //몸무게 키 둘 다 나보다 클때
                if (w[i][0] < w[j][0] && w[i][1] < w[j][1]) {
                    k++;
                } else if (w[i][0] < w[j][0] || w[i][1] < w[j][1]) /*둘 중 하나만 클 때*/ {
                    continue;
                } else /*둘 다 나보다 작을때*/ {
                    continue;
                }
            }
            number[i] = k + 1;
        }

        for (int i = 0; i < a; i++) {
            System.out.print(number[i] + " ");
        }
		
		
	}
}
