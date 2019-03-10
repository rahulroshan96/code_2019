package Karumanchi;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Sorting {
    public static void main(String args[]){
        Sorting sorting = new Sorting();
        Random rand = new Random();
        ArrayList A = new ArrayList();
        int n=0;
        for(int i=0;i<10;i++){
            n = Math.abs(rand.nextInt()%500);
            A.add(n);
        }

//        sorting.printArrayList(A);
//        sorting.insertionSort(A);
//        sorting.bubbleSort(A);
        sorting.selectionSort(A);
    }
    void printArrayList(ArrayList A){
        for(int i=0;i<A.size();i++){
            System.out.print(A.get(i)+" ");
        }
        System.out.println();
    }
    void insertionSort(ArrayList A){
        ArrayList<Integer> B = new ArrayList(A);
        int n = B.size();
        for(int i=1;i<B.size();i++){
            int k = B.get(i);
            int j;
            for(j=i-1;j>=0;j--){
//                // replace the next element with current element
                if(B.get(j)>k){
                    B.set(j+1, B.get(j));
                }else{
                    break;
                }
            }
            B.set(j+1,k);
        }
        this.printArrayList(B);
    }
    boolean isSorted(ArrayList<Integer> A){
        for(int i=0;i<A.size()-1;i++){
            if(A.get(i)>A.get(i+1)) {
                return false;
            }
        }
        return true;
    }
    void bubbleSort(ArrayList A){
        ArrayList<Integer> B = new ArrayList(A);
        for(int i=B.size()-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(B.get(j)> B.get(j+1)){
                    int temp = B.get(j);
                    B.set(j, B.get(j+1));
                    B.set(j+1, temp);
                }
            }
        }
        this.printArrayList(B);
        System.out.println(isSorted(B));
    }
    void selectionSort(ArrayList<Integer> A){
        ArrayList<Integer> B = new ArrayList<>(A);
        for(int i=0;i<B.size();i++){
            int k = B.get(i);
            for(int j=i+1;j<B.size();j++){
                if(B.get(j) < k){
                    k = A.get(j);
                }
            }
            B.set(i,k);
        }
        this.printArrayList(B);
        System.out.println(isSorted(B));
        }

}
