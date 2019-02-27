package xiaonei2;

import java.util.Scanner;

public class Main{
	/**
	 * 题目大意：
	 * 给你一个数N，如果N为偶数则N=N/2，如果N为奇数N=N*3+1
	 * 循环下去问你N最大达到什么位置
	 * 比如N=9
	 * 9,28,14,7,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1
	 * 可以看到，N=9的时候，这个“小冰雹”最高冲到了52这个高度。
	 * <p>
	 * 输入格式：
	 * 一个正整数N（N<1000000）
	 * 输出格式：
	 * 一个正整数，表示不大于N的数字，经过冰雹数变换过程中，最高冲到了多少。
	 * <p>
	 * 样例输入：
	 * 10
	 * 样例输出：
	 * 52
	 * <p>
	 * 样例输入：
	 * 100
	 * 样例输出：
	 * 9232
	 */
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

