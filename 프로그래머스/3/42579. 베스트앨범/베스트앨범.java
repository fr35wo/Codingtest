import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
    	 List<Integer> answer = new ArrayList<>();
    	 
         Map<String, Integer> num = new HashMap<>(); // 장르별 총 개수
         Map<String, Map<Integer, Integer>> music = new HashMap<>(); // 장르에 속하는 노래 및 재생횟수
    	
    	for(int i=0; i<plays.length; i++) {
    		if(!num.containsKey(genres[i])) {
    			Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
    		} else {
    			music.get(genres[i]).put(i, plays[i]);
    			num.put(genres[i], num.get(genres[i]) + plays[i]);
    		}
    	}
    	
    	List<String> keySet = new ArrayList(num.keySet());
    	Collections.sort(keySet, (s1, s2) -> num.get(s2) - (num.get(s1))); // 값을 기준으로 정렬
    	
    	for(String key : keySet) {
    		Map<Integer, Integer> map = music.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());
            
            Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1)));
            answer.add(genre_key.get(0));
            if(genre_key.size()>1) {
            	answer.add(genre_key.get(1));
            }
    	}

    	int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
