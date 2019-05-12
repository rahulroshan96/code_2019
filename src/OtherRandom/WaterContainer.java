package OtherRandom;

public class WaterContainer {
    public static void main(String args[]){
        WaterContainer w = new WaterContainer();
        int a[] = {1,2,3,0,5};

        System.out.println(w.maxWater(a));
    }
    int maxWater(int a[]){
        int max = 0;
        int i=0,j=a.length-1;
        while(i<j){
            max = Math.max(max,(j-i)*Math.min(a[i],a[j]));
            if(a[i]<a[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
