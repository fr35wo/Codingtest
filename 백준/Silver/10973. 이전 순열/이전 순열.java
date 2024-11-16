import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        int[] arr = new int[N];
	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < N; i++) {
	            arr[i] = Integer.parseInt(st.nextToken());
	        }
	        
	        if (previousPermutation(arr)) {
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < N; i++) {
	                sb.append(arr[i]).append(" ");
	            }
	            System.out.println(sb);
	        } else {
	            System.out.println(-1);
	        }
	    }

	    private static boolean previousPermutation(int[] arr) {
	    
	    	int i = arr.length - 1;
	    	
	    	//규칙이 깨지는 지점
	    	while (i > 0 && arr[i - 1] <= arr[i]) {
	            i--;
	        }
	    	
	    	if (i == 0) {
	            return false;
	        }
	    	
	    	int j = arr.length - 1;
	    	while(arr[i-1] <= arr[j]) {
	    		j--;
	    	}
	    	
	    	swap(arr, i - 1, j);
	    	
	    	int k = arr.length - 1;
	    	while(i < k) {
	    		swap(arr, i++, k--);
	    	}
	    	
	    	return true;
	    	
	    }
	    
	    private static void swap(int[] arr, int i, int j) {
	    	int temp = arr[i];
	    	arr[i] = arr[j];
	    	arr[j] = temp;
	    }
		
	}
