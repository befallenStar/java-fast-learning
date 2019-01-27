import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double child=sc.nextDouble();
        double mother=sc.nextDouble();
        String str=String.valueOf(child/mother);
        ArrayList<Integer>  code=new ArrayList<>();
        for(int i=2;i<str.length();i++) {
            int k=str.charAt(i) - '0';
            if (code.indexOf(k)<0)
                code.add(k);
        }
        Integer[] result=new Integer[code.size()];
        code.toArray(result);
        Arrays.sort(result);
        for(int i=0;i<result.length;i++)
            System.out.print(result[i]);
        System.out.println();
    }
}
