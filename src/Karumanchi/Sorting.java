package Karumanchi;

import java.util.*;

public class Sorting {
    public static void main(String args[]){
        Sorting sorting = new Sorting();
        ArrayList<Integer> A = sorting.getRandomArrayList();
        System.out.println("Insertion Sort:");
        sorting.printArrayList(A);
        sorting.insertionSort(A);
        sorting.printArrayList(A);
        System.out.println("Bubble Sort:");
        sorting.bubbleSort(A);
        sorting.printArrayList(A);
        System.out.println("Selection Sort:");
        sorting.printArrayList(A);
        sorting.selectionSort(A);
        sorting.printArrayList(A);
        System.out.println("Merge Sort:");
        sorting.printArrayList(A);
        sorting.mergeSort(A, 0, A.size()-1);
        sorting.printArrayList(A);
        System.out.println("Quick Sort:");
        sorting.printArrayList(A);
        sorting.quickSort(A,0,A.size()-1);
        sorting.printArrayList(A);

    }
    ArrayList<Integer> getRandomArrayList(){
        Random rand = new Random();
        ArrayList A = new ArrayList();
        int n=0;
        for(int i=0;i<10;i++){
            n = Math.abs(rand.nextInt()%500);
            A.add(n);
        }
        return A;
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

    void swap(ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j, temp);
    }

    void conquer(ArrayList<Integer> A, int i, int k, int j){
        // 4 5 6 7
        ArrayList<Integer> L = new ArrayList<>();
        ArrayList<Integer> R = new ArrayList<>();
        this.printArrayList(A);

        int ix=i,kx=k+1;
        // populate both the arrays Left and Right
        while(ix<=k){
            L.add(A.get(ix));
            ix++;
        }
        while(kx<=j){
            R.add(A.get(kx));
            kx++;
        }
        ix=0; kx=0;
        int ixEnd = (k-i)+1;
        int kxEnd = (j-k);
        int m = i;
        while(ix<ixEnd && kx<kxEnd){
            if(L.get(ix)<R.get(kx)){
                A.set(m,L.get(ix));
                ix++;
            }else{
                A.set(m,R.get(kx));
                kx++;
            }
            m++;
        }
        if(ix==ixEnd){ // Right array has been fully populated to A array
            while(kx<kxEnd){
                A.set(m,R.get(kx));
                m++;kx++;
            }
        }
        if(kx==kxEnd){ // Means Left array has been populated to A array
            while(ix<ixEnd){
                A.set(m,L.get(ix));
                ix++;m++;
            }
        }
    }

    void mergeSort(ArrayList<Integer> B, int i, int j){
        // 0 1 2 3 4,

        if(i<j) {
            int mid = (i+j)/2;
            mergeSort(B, i, mid);
            mergeSort(B, mid + 1, j);
            conquer(B, i,mid, j);
        }
    }

    Integer getPivot(ArrayList<Integer> A, int i, int j){
        int pivot = A.get(i);
        int pivotIndex = i;
        boolean ix=false;
        i++;
        while(i<j){
            ix=false;
            if(A.get(i)<pivot){
                i++;
            }else{
                ix = true;
            }
            if(A.get(j)>pivot){
                j--;
            }else{
                ix=true;
            }
            if(ix){
                swap(A,i,j);
            }
        }
        swap(A,pivotIndex, i);
        return i;
    }

    void quickSort(ArrayList<Integer> A, int i, int j){
        if(i<j){
            int p = getPivot(A, i, j);
            quickSort(A, i, p-1);
            quickSort(A, p+1, j);
        }
    }



}
