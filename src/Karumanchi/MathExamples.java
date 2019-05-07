package Karumanchi;



class MathExamples {
    public static void main(String args[]){
        MathExamples t = new MathExamples();
        int []a = {1,2,3};
        t.permutation(a, 0,a.length);

    }
    void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    void permutation(int a[], int i, int n){
        if(i==n){
            printArray(a);
            return;
        }
        for(int x=i;x<a.length;x++){
            swap(a, i,x);
            permutation(a,i+1,n);
            swap(a,i,x);
        }
    }
    void printArray(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}





