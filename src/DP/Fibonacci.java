package DP;


import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String args[]){
        Fibonacci hs = new Fibonacci();
        Map<Integer, Integer> mm = new HashMap<Integer, Integer>();
        System.out.println(hs.getFibTopDown(10, mm));
        System.out.println(hs.getFibBottomUp(10));
    }
    int getFibTopDown(int n, Map<Integer,Integer> mm){
        if(n==1 || n==2){
            return 1;
        }else{
            if(mm.containsKey(n)){
                return mm.get(n);
            }
            mm.put(n,(getFib(n-1,mm) + getFib(n-2,mm)));
            return mm.get(n);
        }
    }
    int getFibBottomUp(int n){
        int a=0,b=1;
        int c=0;
        if(n==0) return 0;
        if(n==1) return 1;
        for(int i=2;i<=n;i++){
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
