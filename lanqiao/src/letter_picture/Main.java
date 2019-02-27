package letter_picture;

import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i = 0; i < n; i++){
			for(int j = i; j > 0 && j > i - m; j--)
				System.out.print((char) ('A' + j));
			for(int j = 0; j < m - i; j++)
				System.out.print((char) ('A' + j));
			System.out.println();
		}
	}
}

