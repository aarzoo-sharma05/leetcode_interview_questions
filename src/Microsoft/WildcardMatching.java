package Microsoft;
import java.util.*;

//Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for
// '?' and '*' where:
//
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
// The matching should cover the entire input string (not partial).

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, s, p, dp);
    }
    public boolean solve(int ind1, int ind2, String s, String p, int[][] dp){
        if(ind1 >= s.length() && ind2 < p.length()){
            for(int i = ind2; i < p.length(); i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(ind1 == s.length() && ind2 == p.length()){
            return true;
        }
        if(ind2 >= p.length()){
            return false;
        }
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2] == 0 ? false : true;
        boolean way = false;
        if(s.charAt(ind1) == p.charAt(ind2) || p.charAt(ind2) == '?'){
            way = solve(ind1+1, ind2+1, s, p, dp) ;
        }
        else if(p.charAt(ind2) == '*'){
            way = solve(ind1+1, ind2, s, p, dp) || solve(ind1+1, ind2+1, s, p, dp) || solve(ind1, ind2+1, s, p, dp);
        }
        dp[ind1][ind2] = way ? 1 : 0;
        return way;
    }
}
