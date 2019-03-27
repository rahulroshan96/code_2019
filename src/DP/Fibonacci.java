package DP;


import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String args[]){
        Fibonacci hs = new Fibonacci();
        Map<Integer, Integer> mm = new HashMap<Integer, Integer>();
        System.out.println(hs.getFib(10, mm));
    }
    int getFib(int n, Map<Integer,Integer> mm){
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
}
