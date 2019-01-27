import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        if(r>0)
        System.out.format("%.7f",Math.PI*r*r);
    }
}
