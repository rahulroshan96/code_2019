package DP;

public class EditDistanceProblem {
    public static void main(String args[]){
        EditDistanceProblem ed = new EditDistanceProblem();
        String s1 = "ABCDE";
        String s2 = "ABE";
//        System.out.println(ed.editDistanceTDApproach(s1,s2,s1.length()-1,s2.length()-1));
        System.out.println(ed.editDistanceBUApproach(s1,s2));
    }

    int editDistanceTDApproach(String s1, String s2, int i, int j){
        if(i==0) return j;
        if(j==0) return i;
        if(s1.charAt(i)==s2.charAt(j)){
            return editDistanceTDApproach(s1,s2,i-1,j-1);
        }else{
            int a = editDistanceTDApproach(s1,s2, i-1, j);
            int b = editDistanceTDApproach(s1,s2,i,j-1);
            int c = editDistanceTDApproach(s1,s2,i-1,j-1);
            return Math.min(a,Math.min(b,c))+1;
        }
    }

    int editDistanceBUApproach(String s1, String s2){
        int T[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    T[i][j] = T[i - 1][j - 1];
                } else {
                    T[i][j] = Math.min(T[i - 1][j], Math.min(T[i][j - 1], T[i - 1][j - 1]))+1;
                }
            }
        }
        return T[s1.length()][s2.length()];
    }
}
