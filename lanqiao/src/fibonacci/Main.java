package fibonacci;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		int[] result;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n > 0){
			result = new int[n + 1];
			if(n == 1)
				System.out.println(1);
			else{
				result[1] = result[2] = 1;
				for(int i = 3; i < n + 1; i++)
					result[i] = (result[i - 1] % 10007 + result[i - 2] % 10007) % 10007;
				System.out.println(result[n]);
			}
		}
	}
}
