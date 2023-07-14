package bak;
import java.util.Scanner;
import java.util.Arrays;

public class Main_2108 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

	     int number = input.nextInt(); //수의 개수
	     int array[] = new int[number]; //수의 개수 크기의 배열
	     int result[] = new int[4];//결과 저장 배열
	     
	     for(int i=0;i<number;i++) {
	    	 int a = input.nextInt();
	    	 array[i] = a; //입력받은 수 배열에 넣기
	     }
	     
	     //산술평균
	     double sum = 0;
	     double summ = 0;
	     for(int i=0;i<number;i++) {
	    	 sum = sum + array[i];
	     }
	     summ = (double) sum / number;
	     result[0] = (int) Math.round(summ);
	     
	     //중앙값
	     int[] b = array.clone();
	     Arrays.sort(b);
	     result[1] = b[number/2];
	     
	  // 최빈값
	        int[] best = new int[8001]; // -4000 ~ 4000 까지의 값이 나올 수 있음 (최빈값 카운팅 배열)

	        int maxCount = 0; // 최빈값의 빈도수
	        for (int i = 0; i < number; i++) {
	            best[array[i] + 4000]++; //해당 상수값 카운팅
	            if (best[array[i] + 4000] > maxCount) {
	                maxCount = best[array[i] + 4000];
	            }
	        }

	        boolean isSecond = false; // 두 번째로 작은 최빈값을 찾았는지 여부
	        int mode = 0; // 최빈값
	        int modeCount = 0; // 최빈값의 빈도수
	        for (int i = 0; i < 8001; i++) {
	            if (best[i] == maxCount) {  // best 배열에서 빈도수가 최빈값과 같은 경우 찾기
	            	
	            	//첫번째 최빈값일때 
	                if (!isSecond) {
	                    mode = i - 4000; // 해당 인덱스에서 4000을 뺀 값이 첫 번째로 작은 최빈값
	                    isSecond = true; 
	                }
	                //두번째 최빈값일때
	                else {
	                    mode = i - 4000; // 해당 인덱스에서 4000을 뺀 값이 두 번째로 작은 최빈값
	                    break;
	                }
	            }
	        }
	        result[2] = mode;
	     
	     
	     
	     //범위
	     int min = b[0];
	     int max = b[number-1];
	     
	     result[3] = max - min;
	     
	     for(int i=0;i<4;i++) {
	    	System.out.println(result[i]);
	    	
	     }
	     
	}    
}

//코드리뷰 https://st-lab.tistory.com/108
