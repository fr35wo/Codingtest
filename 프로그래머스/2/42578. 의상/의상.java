import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
    	
    	Map<String,Integer> map = new HashMap<>();
    	
        for(int i = 0; i < clothes.length; i++) {
            // 의상 종류 별로 몇개씩 있는지 hash에 저장해주기 
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); 
        }
    	
        int answer = 1;
        
        for(String key : map.keySet()) {
        	answer = answer * (map.get(key) + 1);
        }

        answer = answer - 1;
        
        return answer;
    }
}