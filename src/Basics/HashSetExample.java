package Basics;

import java.util.*;
public class HashSetExample {
    public static void main(String args[]){
        HashSet s = new HashSet();
        s.add(1);
        s.add(1);
        s.add(1);
        s.add(1);

        Iterator<Integer> i = s.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        s.remove(1);
        System.out.println(s.contains(1));
    }
}
