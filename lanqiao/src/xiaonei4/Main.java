package xiaonei4;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] num123 = new int[n];
		for(int i = 0; i < n; i++)
			num123[i] = sc.nextInt();
		int sum = 0;
		for(int i = 0; i < n - 1; i++)
			for(int j = i + 1; j < n - 1; j++)
				for(int k = j + 1; k < n; k++)
					if(num123[i] < num123[j] && num123[j] < num123[k])
						sum++;
		System.out.println(sum);
	}
}
