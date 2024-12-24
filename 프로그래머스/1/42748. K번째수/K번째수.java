import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
    	
    	int[] answer = new int[commands.length];
    	
    	for(int m=0; m<commands.length; m++) {
    		int i=0, j=0, k=0;
    		
    		for(int n=0; n<commands[m].length; n++) {
    			if(n==0) {
    				i = commands[m][n];
    			} else if(n==1) {
    				j = commands[m][n];
    			}else if(n==2) {
    				k = commands[m][n];
    			}
    		}
    		
    		int newArr[] = Arrays.copyOfRange(array, i-1, j);
    		Arrays.sort(newArr);
    		
    		answer[m] = newArr[k-1];
    		
    	}
    	
        return answer;
    }
}