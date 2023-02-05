import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
	static SLL player1 = new SLL();
	static SLL player2 = new SLL();
	static SLL PlayerandScore = new SLL();
	static Node playerNode = new Node(null);
	static Player p = new Player(null,null);
	
	public static void main(String[] args) throws IOException {
		Yahtzee myGame = new Yahtzee();				
			
		int turn = 0;
		int p1score=0;
		int p2score=0;
		
		while(!myGame.turnControl(turn)) {
			turn++;	
			System.out.println("Turn: " + turn);
			
			//player 1
			myGame.randomThreeDice(player1);
			System.out.print("Player1: ");
			player1.display();
			
			//yahtzee and large straight control. 
			//arrange the single linked list.
			//add score.
			if(myGame.yahtzeeControl(player1)|| myGame.largeStraightControl(player1)) {
				for(int i=0;i<player1.size();i++) {
					if(myGame.largeStraightControl(player1)) {
						for(int j=1;j<=6;j++) {
							player1.deleteNodeByValue(j,player1.size());							
						}
						p1score = p1score + 30;
					}
					if(player1.count(i)>=4) {
						myGame.deleteFirstSameFour(player1,i);
						p1score = p1score + 10;
					}								
				}
			}			
			System.out.printf("%12s%n","Score: "+ p1score);
			
			//player 2			
			myGame.randomThreeDice(player2);
			System.out.print("Player2: ");
			player2.display();
			
			//yahtzee and large straight control. 
			//arrange the single linked list.
			//add score.
			if(myGame.yahtzeeControl(player2)|| myGame.largeStraightControl(player1)) {
				for(int i=0;i<player2.size();i++) {
					if(myGame.largeStraightControl(player2)) {
						for(int j=1;j<=6;j++) {
							player2.deleteNodeByValue(j,player2.size());						
						}
						p2score = p2score + 30;
					}
					if(player2.count(i)>=4) {
						myGame.deleteFirstSameFour(player2,i);
						p2score = p2score + 10;
					}										
				}
			}
			System.out.printf("%12s%n","Score: "+p2score);
			System.out.print("\n");			
												
		}
		
		myGame.printGameResult(p1score, p2score);
		highScore(p1score,p2score);
		}
		
	public static void highScore(int p1score, int p2score) throws IOException {
		//read file
		Path scorePath = Paths.get("h.txt");											
		Scanner scores = new Scanner(scorePath);	
		
		
		//add player1 and player2 to PlayerandScore single linked list.
		System.out.print("Enter your name: ");	
		try (Scanner scannerFile = new Scanner(System.in)) {
			String winner = scannerFile.nextLine();
			if(p1score>=p2score) {
				PlayerandScore.addInsertSort(new Node(new Player(winner,p1score)));
			}
			else if(p1score<p2score) {
				PlayerandScore.addInsertSort(new Node(new Player(winner,p2score)));
			}
		}
		//read text and add single linked list	
		while (scores.hasNext())  {					
			p = new Player(scores.next(),Integer.valueOf( scores.next() ));			
            playerNode = new Node(p);
            PlayerandScore.addInsertSort(playerNode);			           
                     
		}		
		scores.close();
		
		System.out.print("\n");
		System.out.println("High Score Table");
		System.out.println("----------------");
		//write high score table to text file and console screen. 
		Node temp = PlayerandScore.head();	
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("h.txt"))); 
		for(int i=0;i<10;i++) {
			System.out.print(temp.getData()+"\n");
			writer.write(temp.getData()+"\n");
			temp = temp.getLink();
			if(temp==null) {
				break;
			}
		}
		
		writer.close();
						
		
	}	 

}
