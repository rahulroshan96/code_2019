package DP;

import java.util.HashMap;

public class BinaryKnapsackProblem {
    public static void main(String args[]){
        int []itemsWeight = {1,2,2,3,4};
        int []itemsProfit = {2,3,5,2,5};
        int MaximumWeight = 5;
        int [][]T = new int[itemsWeight.length+1][MaximumWeight+1]; // 2D Array initializes with zeros by default

        BinaryKnapsackProblem b = new BinaryKnapsackProblem();
        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.println("Tha Maximum Profit by Bottom Up Approach is "+b.getMaximumProfitIterative(itemsWeight, itemsProfit,
                MaximumWeight, itemsWeight.length+1, MaximumWeight+1, T));
        System.out.println("The maximum Profit by Top Down Approach is: "+b.getMaximumProfitRecursive(itemsWeight, itemsProfit,MaximumWeight,map,0));
        System.out.println();
//        b.print2DArray(T, itemsWeight.length+1, MaximumWeight+1);
    }

    int getMaximumProfitIterative(int []itemsWeight, int []itemsProfit, int MaximumWeight, int m, int n, int [][]T){
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(j<itemsWeight[i-1]){ // items weight is greater than knapsack's capacity
                    T[i][j] = T[i-1][j]; // we don't take item
                }else{
                    T[i][j] = Math.max(T[i-1][j],
                            (itemsProfit[i-1]+T[i][j-(itemsWeight[i-1])])); // max of take item+previous profit, and not take item
                }
            }
        }
        return T[m-1][n-1];
    }

    int getMaximumProfitRecursive(int []itemsWeight, int []itemsProfit, int MaximumWeight, HashMap<Integer, Integer> m, int i){
        if(i==itemsWeight.length) return 0;
        if(MaximumWeight==0) return 0;
        if(m.containsKey(MaximumWeight)) return m.get(MaximumWeight); // memoization

        if(itemsWeight[i]>MaximumWeight){ // we don't take the item
            return getMaximumProfitRecursive(itemsWeight, itemsProfit, MaximumWeight, m, i+1);
        }else{
            // return take item or don't take item
            int result = Math.max(getMaximumProfitRecursive(itemsWeight, itemsProfit, MaximumWeight, m, i+1),
                    itemsProfit[i]+getMaximumProfitRecursive(itemsWeight, itemsProfit, MaximumWeight-itemsWeight[i], m,i));
            m.put(MaximumWeight, result);
            return result;
        }
    }

    void print2DArray(int [][]T, int m, int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(T[i][j]+" ");
            }
            System.out.println();
        }
    }
}
