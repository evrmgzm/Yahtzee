import java.util.Random;

public class Yahtzee {
	Random rnd = new Random();
	int dice;
	
	public void randomThreeDice(SLL player) {
		for(int i=0;i<3;i++) {						
			dice = rnd.nextInt(6) + 1;
			player.addLast(dice);
		}
	}
	
	public void printGameResult(int p1score, int p2score) {
		System.out.println("Game is over!!");
		if(p1score>p2score) {
			System.out.println("The winner is Player 1");
		}
		else if(p1score<p2score) {
			System.out.println("The winner is Player 2");
		}
		else {
			System.out.println("Tie.");
		}
	}
	public void deleteFirstSameFour(SLL player,int dice) {
		for(int i=0;i<4;i++) {									
			player.deleteFront(dice);
		}
	}
	public boolean yahtzeeControl(SLL player) {
		boolean flag = false;
		for(int i=0;i<player.size();i++) {
			if(player.count(i)>=4) {
				flag = true;
			}
			
		}
		return flag;
	}
	public boolean largeStraightControl(SLL player) {
		boolean flag = false;		
		for(int i=0;i<player.size();i++) {
			if(Consecutive(player)) {
				flag = true;
			}
		}
		return flag;
	}
	public boolean Consecutive(SLL player) {
		boolean flag = false;
		int count = 0;
		for(int i=1;i<=6;i++) {
			if(player.search(i)) {
				count++;
			}
		}
		if(count==6) {
			flag = true;
		}
		return flag;
	}
	public boolean turnControl(int turn) {
		boolean flag = false;
		if(turn == 10) {
			flag = true;
		}
		return flag;
	}
	
	
	
	
	
	
}
