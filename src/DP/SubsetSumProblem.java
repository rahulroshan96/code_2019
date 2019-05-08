package DP;

public class SubsetSumProblem {
    public static void main(String args[]){
        SubsetSumProblem ss = new SubsetSumProblem();
        int set[] = {2,3,5,7};
        int sum = 14;
        System.out.println(ss.subsetSumProblemTDApproach(set,0,sum));
        System.out.println(ss.subsetSumProblemBUApproach(set, sum));
    }
    boolean subsetSumProblemTDApproach(int set[], int i, int sum){
        if(sum==0) return true;
        if(sum!=0 && i==set.length) return false;
        if(set[i]<=sum){
            return (subsetSumProblemTDApproach(set, i+1,sum-set[i])||subsetSumProblemTDApproach(set,i+1,sum));
        }else{
            return subsetSumProblemTDApproach(set,i+1,sum);
        }
    }

    boolean subsetSumProblemBUApproach(int set[], int sum){
        boolean T[][] = new boolean[set.length+1][sum+1];
        for(int i=0;i<=set.length;i++){
            T[i][0] = true;
        }
        for(int i=1;i<=set.length;i++){
            for(int j=1;j<=sum;j++){
                if(j>=set[i-1]){
                    T[i][j] = (T[i-1][j] || T[i-1][j-set[i-1]]); // 2nd part is showing that we are taking
                    // one element one time. in case of taking one element multiple times we do
                    // T[i][j-set[i-1]] and for one time only T[i-1][j-set[i-1]]
                }else{
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[set.length][sum];
    }
}
