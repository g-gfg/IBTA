public class RegMatch {
    
    public static int dp[][], uselessInd;
    
    public static int getDP(String str, String patt, int i, int j) {
        if(i == str.length() && j == patt.length())
            return 1;
        if(i < str.length() && j == patt.length()) {
            return 0;
        }
        if(i == str.length()) {
            if(j >= uselessInd)
                return 1;
            else
                return 0;
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(str.charAt(i) != patt.charAt(j) && patt.charAt(j) != '.') {
            if(j+1<patt.length() && patt.charAt(j+1) == '*')
                dp[i][j] = getDP(str, patt, i, j+2);
            else
                dp[i][j] = 0;
        }
        else {
            if(j+1<patt.length() && patt.charAt(j+1) == '*') {
                int res1 = getDP(str, patt, i+1, j);
                int res2 = getDP(str, patt, i, j+2);
                
                if(res1==1 || res2==1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = 0;
            }
            else
                dp[i][j] = getDP(str, patt, i+1, j+1);
        }
        
        return dp[i][j];
    }
    
    public static int isMatch(final String str, final String patt) {
        int lenStr = str.length(), lenPatt = patt.length();
        dp = new int[lenStr][lenPatt];
        for(int i=0; i<lenStr; i++)
            Arrays.fill(dp[i], -1);
        int i = lenPatt - 1;
        while(i >= 0 && patt.charAt(i) == '*')
            i -= 2;
        
        uselessInd = i + 1;
        return getDP(str, patt, 0, 0);
    }
    
    public static void main(String[] args) {
        String str = "bbbbbb", patt = "b*b";
        System.out.println(isMatch(str, patt));
    }
}
