import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
    	
    	HashMap<String,Integer> map = new HashMap<>();
    	
        // 참가자 목록을 해시맵에 추가하고, 동명이인일 경우 개수를 증가시킴
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        // 완주자 목록을 해시맵에서 차감하고, 0이 되면 삭제함
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        	
            if (map.get(completion[i]) == 0) {
                map.remove(completion[i]);
            }
        }
        
        // 남아있는 키는 완주하지 못한 사람임
        String answer = map.keySet().iterator().next();
        return answer;
    }
}
