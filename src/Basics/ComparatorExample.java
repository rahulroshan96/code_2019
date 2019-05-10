package Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{
    int number;
    String name;

    Student(int number, String name){
        this.number = number;
        this.name = name;
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

        Collections.sort(slist, new StudentComparator());
        for(int i=0;i<slist.size();i++){
            System.out.print(slist.get(i).number+" ");
        }
    }
}
