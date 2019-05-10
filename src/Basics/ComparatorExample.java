package Basics;

/*
* Comparator: we can write custom multilevel sorting logic using compare method
* Comparable: Student class itself has compareTo method to compare fields
* Comparator: here used to sort a priority queue
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Student implements Comparable<Student>{
    int number;
    String name;

    Student(int number, String name){
        this.number = number;
        this.name = name;
    }
    public int compareTo(Student a){
        return this.number-a.number;
    }
}


class StudentComparator implements Comparator<Student>{
    public int compare(Student a, Student b){
        if(a.number>b.number) return 1;
        else return -1;
    }
}

public class ComparatorExample {
    public static void main(String args[]){
        ArrayList<Student> slist = new ArrayList<Student>();
        slist.add(new Student(2,"Rahul"));
        slist.add(new Student(1, "Rohit"));
        slist.add(new Student(3, "Sharad"));
        slist.add(new Student(3, "X"));
        ArrayList<Student> temp = slist;
        Collections.sort(temp);
        for(int i=0;i<temp.size();i++){
            System.out.print(temp.get(i).number+" ");
        }
        System.out.println();
        Collections.sort(slist,new StudentComparator());
        for(int i=0;i<slist.size();i++){
            System.out.print(slist.get(i).number+" ");
        }

        // Priority Queue comparator example
        System.out.println();
        PriorityQueue<Student> pq = new PriorityQueue<Student>(new StudentComparator());
        pq.add(new Student(2,"Rahul"));
        pq.add(new Student(1, "Rohit"));
        pq.add(new Student(3, "Sharad"));
        pq.add(new Student(3, "X"));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().number);
            pq.remove();
        }
    }
}
