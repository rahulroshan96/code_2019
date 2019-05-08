package DP;

public class CoinChaningProblem {
    public static void main(String args[]){
        CoinChaningProblem c = new CoinChaningProblem();
        int coins[] = {1,3,5};
        int sum = 11;
        System.out.println(c.minimumNumberOfCoinsTOPDownApproach(coins,sum));
    }

    int minimumNumberOfCoinsTOPDownApproach(int coins[], int sum){
        if(sum==0) return 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(coins[i]>sum) continue;
            int val = minimumNumberOfCoinsTOPDownApproach(coins, sum-coins[i]);
            min = Math.min(min,val);
        }
        if(min != Integer.MAX_VALUE){
            min+=1;
        }
        return min;
    }
}
