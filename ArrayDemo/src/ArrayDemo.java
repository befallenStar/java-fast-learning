import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args){
        int[] data={12,-1,23,32,3,-5,2,0,-19,47,56,86,-95};
        Arrays.sort(data);
        printArray(data);
    }
    public static void printArray(int[] data){
        for(int x:data)
            System.out.print(String.valueOf(x)+' ');
        System.out.println();
    }
}
