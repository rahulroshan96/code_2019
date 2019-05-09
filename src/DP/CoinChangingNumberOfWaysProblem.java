package DP;

public class CoinChangingNumberOfWaysProblem {
    public static void main(String args[]){
        CoinChangingNumberOfWaysProblem cc = new CoinChangingNumberOfWaysProblem();
        int coins[] = {1,3,5};
        int sum = 3;
        System.out.println(cc.coinWaysBU(coins,sum));
        System.out.println(cc.coinWaysTD(coins,sum,0));
    }

    int coinWaysTD(int coins[], int sum, int x){
        if(sum==0) return 1;
        if(x==coins.length) return 0;
        if(coins[x]>sum) return 0;
        return coinWaysTD(coins,sum-coins[x],x) + coinWaysTD(coins, sum,x+1);
    }

    int coinWaysBU(int coins[], int sum){
        int T[][] = new int[coins.length+1][sum+1];
        for(int i=0;i<=coins.length;i++){
            T[i][0] = 1;
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=sum;j++){
                if(j<coins[i-1]){
                    T[i][j] = T[i-1][j];
                }else{
                    T[i][j] = T[i][j-coins[i-1]]+T[i-1][j];
                }
            }
        }
        return T[coins.length][sum];
    }
}
