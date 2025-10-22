class Solution {
    //memoisation
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        int[][] dp = new int[n1][n2];
        return memo(s, p, 0, 0, dp);
    }
    public boolean memo(String s, String p, int i, int j, int[][] dp){
        if(i == s.length() && j == p.length()) return true;
        if(i == s.length() && j != p.length()){
            if(j+1<p.length() && p.charAt(j+1) == '*') return memo(s, p, i, j+2, dp);
            else return false;
        }
        if(i != s.length() && j == p.length()) return false;
        if(dp[i][j] != 0){
            return dp[i][j] == 1;
        }
        if(s.charAt(i) == p.charAt(j)){
            if(j+1<p.length() && p.charAt(j+1) == '*'){
                dp[i][j] = memo(s, p, i+1, j, dp) || memo(s, p, i, j+2, dp)?1:-1;
                return dp[i][j] == 1;
            }
            else{
                dp[i][j] = memo(s, p, i+1, j+1, dp)?1:-1;
                return dp[i][j] == 1;
            }
        }
        else{
            if(p.charAt(j) == '.'){
                if(j+1<p.length() && p.charAt(j+1) == '*'){
                    dp[i][j] = memo(s, p, i+1, j, dp) || memo(s, p, i, j+2, dp)?1:-1;
                    return dp[i][j]==1;
                }
                else{
                    dp[i][j] = memo(s, p, i+1, j+1, dp)?1:-1;
                    return dp[i][j]==1;
                }
            }
            else{
                if(j+1<p.length() && p.charAt(j+1) == '*'){
                    dp[i][j] = memo(s, p, i, j+2, dp) ? 1 :-1;
                    return dp[i][j] == 1;
                }
                else{
                    dp[i][j] = -1;
                    return false;
                }
            }
        }
    }
}
