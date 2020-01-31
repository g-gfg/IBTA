public class PaintPart {
    public final int MOD = 10000003;
    
    public boolean canBeDone(int painters, int unitTime, ArrayList<Integer> C, long expTime) {
        int i = 0, n = C.size();
        while(i < n && painters > 0) {
            int j = i;
            long currentPainterTime = 0;
            long currentBoardTime = (long) C.get(j) * (long) unitTime;
            while((currentPainterTime + currentBoardTime) <= expTime) {
                currentPainterTime += currentBoardTime;
                j++;
                if(j >= n)
                    break;
                currentBoardTime = (long) C.get(j) * (long) unitTime;
            }
            painters--;
            i = j;
        }
        if(i == n)
            return true;
        return false;
    }
    
    public int paint(int A, int B, ArrayList<Integer> C) {
        long l = 0, r = Long.MAX_VALUE;
        long minTime = r;
        while(l <= r) {
            long m = l + ((r - l) / 2);
            if(canBeDone(A, B, C, m)) {
                minTime = m;
                r = m - 1;
            }
            else
                l = m + 1;
        }
        
        return (int) (minTime % MOD);
    }
}