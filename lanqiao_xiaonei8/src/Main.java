import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] code=new int[n];
        for(int i=0;i<n;i++)
            code[i]=sc.nextInt();
        int result=0;
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++)
                for(int p=0;p<n-1;p++)
                    for(int q=p+1;q<n;q++)
                        if(p!=i&&p!=j&&q!=i&&q!=j)
                            if (code[i] + code[j] == code[p]+code[q])
                                result++;
                            System.out.println(result);
    }
}
