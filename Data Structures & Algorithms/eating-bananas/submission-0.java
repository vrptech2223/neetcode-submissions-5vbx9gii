class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }

        int l = 1;
        int r = max;
        int res = max;

        while (l <= r) {
            int k = (l + r) / 2;

            int hr = 0;
            for (int p : piles) {
                hr += (int)Math.ceil((double)p / k);
            }

            if (hr > h) {
                l = k + 1;   // need more speed
            } else {
                res = k;     // valid answer
                r = k - 1;   // try smaller
            }
        }

        return res;
    }
}