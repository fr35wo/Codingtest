class Solution {
    public int solution(int[][] sizes) {
        
        
        int max_l = 0;
        int max_h = 0;
        
        for(int i=0; i<sizes.length; i++) {
        	int length = Math.max(sizes[i][0], sizes[i][1]);
        	int height = Math.min(sizes[i][0], sizes[i][1]);
        	max_l=Math.max(max_l,length);
            max_h=Math.max(max_h,height);
        }
        
        return max_l*max_h;
    }
}