package xiaonei1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
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

