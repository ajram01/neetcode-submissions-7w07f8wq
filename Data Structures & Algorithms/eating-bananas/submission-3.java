class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int min = 1, hi = 0;

        for (int p : piles){

            hi = Math.max(hi, p);

        }

        while (min < hi){

            int mid = min + (hi - min) / 2;

            if (canFinish(piles, mid, h)){
                hi = mid;
            } else {
                min = mid + 1;
            }

        }

        return min;

    }

    private boolean canFinish(int[] piles, int mid, int h){

        long hours = 0;

        for (int p : piles){

            hours += (p + mid - 1) / mid;

            if (hours > h) return false;

        }

        return true;

    }
}
