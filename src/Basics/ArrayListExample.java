package Basics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String args[]){
        ArrayListExample ale = new ArrayListExample();
        ArrayList a = new ArrayList();
        a.add(10);
        a.add(40);
        a.add(30);
        a.add(50);
        a.add(70);
        ale.sort(a);
    }
    void print_list(ArrayList a){
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i)+ " ");
        }
        System.out.println();
    }
    void sort(ArrayList a){
        Collections.sort(a, Collections.reverseOrder());
        this.print_list(a);
    }
}
