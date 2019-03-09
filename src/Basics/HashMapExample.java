package Basics;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String args[]){
        HashMap<Integer, String> h = new HashMap<>();

        h.put(1, "Azure");
        h.put(3, "AWS");
        h.put(5, "GCP");

        if(h.containsKey(1)){
            System.out.println("Key is present");
        }

        if(h.containsKey(1)){
            System.out.println(h.get(1));
        }

        for (Map.Entry<Integer, String> e: h.entrySet() ) {
            System.out.println("Key: "+e.getKey()+"          Value: "+e.getValue());
        }
    }
}
