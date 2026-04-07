class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int answer = 0;

        for (int i = 0; i < piles.length; i++){
            answer = Math.max(answer, piles[i]);
        }

        int left = 1;
        int right = answer - 1;

        while (left <= right){
            
            int mid = left + (right - left) / 2; // 1 + 7 / 2

            long hours = 0;

            for (int pile: piles){
                hours += (pile + mid - 1) / mid; // ceil(pile / mid)
            }

            if (hours <= h){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return answer;

        // []
        
    }
}
