package Basics;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(4);
        ll.add(5);
        ll.add(9);
        for(int i=0;i<ll.size();i++){
            System.out.println(ll.get(i));
        }
        System.out.println(ll.contains(1));

        System.out.println(ll.indexOf(9));
    }
}
