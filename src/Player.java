
public class Player {
	Object playerName = null;
	Object playerScore = null;
	
	public Player(Object name, Object score)
	{
	    playerName = name;
	    playerScore = score;
	    
	}

	public Object getPlayerName() {
		return playerName;
	}
	public void setPlayerName(Object playerName) {
		this.playerName = playerName;
	}
	public Object getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(Object playerScore) {
		this.playerScore = playerScore;
	}
	 public String toString()
	    {
	        return playerName + " " + playerScore;  
	    }
}
