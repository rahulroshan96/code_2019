package Basics;
import java.util.*;

public class StackExample {
    public  static void main(String args[]){
        Stack s = new Stack();
        s.push(10);
        s.push(30);
        s.push(20);
        s.push(50);
        s.push(80);
        StackExample se = new StackExample();
        se.printStack(s);

    }
    public void printStack(Stack s){
        while(!s.empty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
