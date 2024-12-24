import java.util.*;

class Solution {
    public String solution(int[] numbers) {
    	String arr[] = new String [numbers.length];
    	for(int i=0;i<arr.length;i++) {
    		arr[i] = String.valueOf(numbers[i]);
    	}
    	
    	//숫자들의 앞자리 숫자가 큰 수가 먼저 와야 가장 큰 수를 만들 수 있기 때문에 두 수를 이어붙혀서 비교
    	Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
    	
    	if(arr[0].equals("0")) {
    		return "0";
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0;i<arr.length;i++) {
    		sb.append(arr[i]);
    	}
       
        return sb.toString();
    }
}