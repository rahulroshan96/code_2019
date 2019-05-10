package DesignPatterns;

/*
* Goal: Make one object of a class, and use that object to clone and return other objects of same class
* Here we are creating s1 object first, and then using getClone method to create new other objects of same class
* */

interface prototypeInterface {
    public prototypeInterface getClone();
}

class Student2 implements prototypeInterface{
    int number;
    int age;
    String name;

    Student2(int number, int age, String name){
        this.number = number;
        this.age = age;
        this.name = name;
    }

    @Override
    public prototypeInterface getClone(){
        return new Student2(number, age, name);
    }
}

public class PrototypeExample {
    public static void main(String args[]){
    Student2 s1 = new Student2(10,22,"Rahul");

    Student2 s2 = (Student2) s1.getClone();
    System.out.println(s2.name+" "+s2.age+" "+s2.number);
    }
}
