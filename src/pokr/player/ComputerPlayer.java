package pokr.player;

import pokr.game.Card;
import pokr.game.Game.Difficulty;
import pokr.player.strategy.AdeptStrategy;
import pokr.player.strategy.BeginnertStrategy;
import pokr.player.strategy.LegendStrategy;
import pokr.player.strategy.ProfessionalStrategy;
import pokr.player.strategy.Strategy;

public class ComputerPlayer extends Player {
	
	private Strategy strategy;

	public ComputerPlayer(String username, Difficulty difficulty){
		super(username);
		setStrategy(difficulty);
	}
	
	private void setStrategy(Difficulty difficulty) {
		switch(difficulty) {
			case ADEPT:
				this.strategy = new AdeptStrategy();
				break;
			case BEGINNER:
				this.strategy = new BeginnertStrategy();
				break;
			case LEGEND:
				this.strategy = new LegendStrategy();
				break;
			case PROFESSIONAL:
				this.strategy = new ProfessionalStrategy();
				break;
		}
	}

	@Override
	public String determineMove() {
		// TODO Auto-generated method stub
		return null;
	}
}
