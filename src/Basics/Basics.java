package Basics;
import com.sun.deploy.util.StringUtils;

import java.util.*;

class Basics{

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> AI = new ArrayList<>();
        for(int i=0;i<5;i++){
            ArrayList temp = new ArrayList();
            for(int j=0;j<5;j++){
                temp.add(j,j);
            }
            AI.add(temp);
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(AI.get(i).get(j)+" ");
            }
            System.out.println();
        }


//        Basics b = new Basics();
//        ArrayList A = new ArrayList();
//        A.add(10);
//        A.add(20);
//        A.add(30);
//        A.add(140);
//        A.add(1, 100);
//        b.print(A);
    }

    void print(ArrayList A){

    }

}









