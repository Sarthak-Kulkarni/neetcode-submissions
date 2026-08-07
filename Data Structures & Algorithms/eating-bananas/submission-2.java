class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int start = 0, end = Arrays.stream(piles).max().getAsInt();
        int res = end;

        while(start <= end) {
            int k = start + (end-start)/2;
            int timeTaken = 0;
            for(int pile: piles) {
                timeTaken += Math.ceil((double)pile/k);
            }

            if(timeTaken <= h) {
                res = k;
                end = k-1;
            } else {
                start = k + 1;
            }
        }
        return res;
    }
}
