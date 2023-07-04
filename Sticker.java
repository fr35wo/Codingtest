package hw9_1;
import java.util.Scanner;
public class Sticker {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int T = scanner.nextInt();
	        //테스트케이스의 개수입력

	        for (int i = 0; i < T; i++) {
	            int n = scanner.nextInt();//스티커 열 입력
	            int[][] ary = new int[2][n + 1];
	            int[][] peb = new int[2][n + 1];//dp를 위해 ary와 똑같은 크기 배열 생성
	            for (int j = 0; j < 2; j++) { 
	                for (int k = 1; k <= n; k++) {
	                	ary[j][k] = scanner.nextInt();//ary배열 값 입력받음
	                }
	            }
	            //peb의 첫줄은 누적된 점수가 없으므로=ary첫줄
	            peb[0][1] = ary[0][1];
	            peb[1][1] = ary[1][1];
	            for (int a = 2; a <= n; a++) {
	            	peb[0][a] = Math.max(peb[1][a - 1], peb[1][a - 2]) + ary[0][a];
	            	peb[1][a] = Math.max(peb[0][a - 1], peb[0][a - 2]) + ary[1][a];
	            }//peb는 채우려는 칸의 다른줄 -1, -2칸 중에 큰 값에다가 ary의 현재점수를 더해야함
	            System.out.println(Math.max(peb[0][n], peb[1][n]));
	            //peb의 마지막 열 중에 더 큰 값이 최고 점수이다
	        }
	    }
	}