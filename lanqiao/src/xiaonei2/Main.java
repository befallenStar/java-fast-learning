package xiaonei2;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		for(int i = start; i < end; i++){
			if((int) Math.sqrt(i) * (int) Math.sqrt(i) == i){
				String str = String.valueOf(i);
				for(int j = 1; j <= str.length() - 1; j++){
					int high = i / (int) Math.pow(10, str.length() - j);
					int low = i % (int) Math.pow(10, str.length() - j);
					if((int) Math.sqrt(high) * (int) Math.sqrt(high) == high && (int) Math.sqrt(low) * (int) Math.sqrt(low) == low && low != 0)
						System.out.println(i);
				}
			}
		}
	}
}

