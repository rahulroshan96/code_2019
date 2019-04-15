package Karumanchi;


import java.util.LinkedList;
import java.util.Queue;

public class GraphExamples {
    public static void main(String args[]){
        GraphExamples t = new GraphExamples();
        int [][]a = {
                {0,1,0,1,1},
                {0,0,1,0,0},
                {0,0,0,0,1},
                {0,0,0,0,1},
                {0,0,0,0,0}
        };
        int []visited = new int[5];
        visited[0]=1;
//        t.DFS(a,5,0,visited);
        t.BFS(a,5,0, visited);
    }
    void printArray(int []a, int n){
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    void DFS(int [][]a, int n,int s, int []visited){
        System.out.println(s+" ");
        for(int i=0;i<n;i++){
            if(a[s][i]==1 && visited[i]!=1){
                visited[i]=1;
                DFS(a,n,i,visited);
            }
        }
    }
    void BFS(int [][]a, int n, int s, int []visited){
        Queue<Integer> myQ = new LinkedList<>();
        myQ.add(s);
        visited[s] = 1;
        while(!myQ.isEmpty()){
            int u = myQ.remove();
            System.out.print(u+" ");
            for(int i=0;i<n;i++){
                if(a[u][i]==1 && visited[i]==0){
                    visited[i] = 1;
                    myQ.add(i);
                }
            }
        }
    }
}
