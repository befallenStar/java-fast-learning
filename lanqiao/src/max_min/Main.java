package max_min;

import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		ArrayList<Integer> n = new ArrayList<>();
		sc.nextLine();
		for(int i = 0; i < number; i++)
			n.add(sc.nextInt());
		Integer[] ns = new Integer[n.size()];
		n.toArray(ns);
		Arrays.sort(ns);
		System.out.println(ns[number - 1]);
		System.out.println(ns[0]);
		int sum = 0;
		for(int i = 0; i < number; i++)
			sum += ns[i];
		System.out.println(sum);
	}
}

