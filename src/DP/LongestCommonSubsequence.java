package DP;

public class LongestCommonSubsequence {
    public static void main(String args[]){
        String s1 = "abcdefab";
        String s2 = "befab";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int [][]T = new int[s1.length()+1][s2.length()+1];
        System.out.println("Maximum Common Subsequence with Bottom UP approach is: "+lcs.lcsIteration(s1, s2, T, s1.length()+1, s2.length()+1));
        System.out.println("Maximum Common Subsequence with Top Down approach is: "+lcs.lcsRecrsion(s1, s2, 0,0));
    }

    int lcsIteration(String s1, String s2, int [][]T, int m, int n){
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(s1.charAt(i-1)!=s2.charAt(j-1)){ // if s1[i-1] != s2[j-1]
                    T[i][j] = Math.max(T[i-1][j],T[i][j-1]);
                }else{  //s1[i-1] == s2[j-1]
                    T[i][j] = 1+T[i-1][j-1];
                }
            }
        }
        return T[m-1][n-1];
    }

    int lcsRecrsion(String s1, String s2, int i, int j){
        if((i==s1.length()) || (j==s2.length())){
            return 0;
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return 1+lcsRecrsion(s1,s2,i+1,j+1);
        }else{
            return Math.max(lcsRecrsion(s1,s2,i+1,j),lcsRecrsion(s1,s2,i,j+1));
        }
    }
}
