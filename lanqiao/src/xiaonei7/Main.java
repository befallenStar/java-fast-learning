package xiaonei7;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] code = new int[n];
		for(int i = 0; i < code.length; i++)
			code[i] = sc.nextInt();
		int step = 0;
		while(! isE(code)){
			int max = findMax(code);
			for(int i = 0; i < code.length; i++)
				if(i != max)
					code[i] += 1;
			step++;
		}
		System.out.println(step);
	}

	private static int findMax(int[] a){
		int index = 0;
		for(int i = 1; i < a.length; i++){
			if(a[index] < a[i])
				index = i;
		}
		return index;
	}

	private static boolean isE(int[] a){
		boolean flag = true;
		int index = 0;
		for(int i = 1; i < a.length; i++)
			if(a[index] != a[i])
				flag = false;
		return flag;
	}
}
