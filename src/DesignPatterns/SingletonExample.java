package DesignPatterns;

/*
* DesignPatterns: Creational, Structural, Behavioral
* Singleton is Creational design patterns
* Only one instance is possible for Student class
* The constructor of the Student class should be private
* */

class Student {
    int number;
    int age;
    String name;
    private static Student s;
    private Student(){}
    public static Student getInstance(int number, int age, String name){ // this method is responsible for instance creation
        // without creation of Student class instance
        if(s==null){
            s = new Student();
            s.name = name;
            s.number = number;
            s.age = age;
        }
        return s;
    }
}

class Student1 {
    int number;
    int age;
    String name;
    static int count=0;
    Student1(int number, int age, String name){
        if(count==0){
            this.number = number;
            this.name = name;
            this.age = age;
            count++;
        }
    }
}


public class SingletonExample {
    public static void main(String args[]){
        Student s1 = Student.getInstance(1,25,"rahul");
        Student s2 = Student.getInstance(2,25,"kokil");
        System.out.println(s1.name); // "rahul"
        System.out.println(s2.name); // "rahul"

        Student1 ss1 = new Student1(1,22,"rahul");
        Student1 ss2 = new Student1(2, 23, "rohit");

        System.out.println(ss1.name);
        System.out.println(ss2.name); // null because we are not creating a 2nd instance
    }
}
