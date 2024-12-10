import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i=0;i<scoville.length; i++) {
			minHeap.add(scoville[i]);
		}
		
		int count = 0;
		
		
		while(minHeap.peek() < K) {
			
			if(minHeap.size() < 2) {
				return -1;
			}
			
			int i = minHeap.poll() + (minHeap.poll() * 2);
			minHeap.add(i);
			count++;
			
		}
       
        return count;
    }
}

