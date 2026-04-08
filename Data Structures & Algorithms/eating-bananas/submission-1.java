class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        

        int answer = 0;

        for (int pile : piles){

            answer = Math.max(answer, pile);

        }

        int left = 1;
        int right = answer - 1;

        while (left <= right){

            int mid = left + (right - left) / 2;
            int hours = 0;

            for (int pile : piles){
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h){
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return answer;

    }
}
