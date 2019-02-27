package xiaonei1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	/**
	 * 【问题描述】
	 * 某机构举办球票大奖赛。获奖选手有机会赢得若干张球票。
	 *
	 * 主持人拿出 N 张卡片（上面写着 1~N 的数字），打乱顺序，排成一个圆圈。
	 * 你可以从任意一张卡片开始顺时针数数: 1,2,3.....
	 * 如果数到的数字刚好和卡片上的数字相同，则把该卡片收入囊中，从下一个卡片重新数数。
	 * 直到再无法收获任何卡片，游戏结束。囊中卡片数字的和就是赢得球票的张数。
	 *
	 * 比如：
	 * 卡片排列是：1 2 3
	 * 我们从1号卡开始数，就把1号卡拿走。再从2号卡开始，但数的数字无法与卡片对上，
	 * 很快数字越来越大，不可能再拿走卡片了。因此这次我们只赢得了1张球票。
	 *
	 * 还不算太坏！如果我们开始就傻傻地从2或3号卡片数起，那就一张卡片都拿不到了。
	 *
	 * 如果运气好，卡片排列是 2 1 3
	 * 那我们可以顺利拿到所有的卡片！
	 *
	 * 本题的目标就是：已知顺时针卡片序列。
	 * 随便你从哪里开始数，求最多能赢多少张球票（就是收入囊中的卡片数字之和）
	 *
	 * 输入数据：
	 * 第一行一个整数N(N<100)，表示卡片数目
	 * 第二行 N 个整数，表示顺时针排列的卡片
	 *
	 * 输出数据：
	 * 一行，一个整数，表示最好情况下能赢得多少张球票
	 *
	 * 样例输入：
	 * 3
	 * 1 2 3
	 *
	 * 样例输出：
	 * 1
	 *
	 * 样例输入：
	 * 3
	 * 2 1 3
	 *
	 * 样例输出：
	 * 6
	 */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		ArrayList<Character> alist = new ArrayList<>();
		ArrayList<Character> blist = new ArrayList<>();
		for(int i = 0; i < a.length(); i++)
			alist.add(a.charAt(i));
		for(int j = 0; j < b.length(); j++)
			blist.add(b.charAt(j));
		ArrayList<Character> board = new ArrayList<>();
		int turn = 0;
		char ch;
		int index;
		while(alist.size() != 0 && blist.size() != 0){
			switch(turn % 2){
				case 0:
					ch = alist.get(0);
					board.add(ch);
					alist.remove(0);
					index = board.indexOf(ch);
					turn = getTurn(alist, board, turn, index);
					if(alist.size() == 0){
						for(Character character : blist) System.out.print(character);
						break;
					}
					break;
				case 1:
					ch = blist.get(0);
					board.add(ch);
					blist.remove(0);
					index = board.indexOf(ch);
					turn = getTurn(blist, board, turn, index);
					if(blist.size() == 0){
						for(Character character : alist) System.out.print(character);
						break;
					}
					break;
				default:
					break;
			}
			turn++;
		}
		System.out.println();
	}

	private static int getTurn(ArrayList<Character> alist, ArrayList<Character> board, int turn, int index){
		if(index >= 0 && index < board.size() - 1){
			for(int k = board.size() - 1; k >= index; k--){
				alist.add(board.get(k));
				board.remove(k);
			}
			turn++;
		}
		return turn;
	}
}

