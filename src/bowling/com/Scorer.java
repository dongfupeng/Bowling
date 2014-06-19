package bowling.com;

public class Scorer {

	private int[] itsThrows = new int[21];
	private int ball;
	private int itsCurrentThrow = 0;
	
	public void addThrow(int pins){
		itsThrows[itsCurrentThrow++] = pins;
	}
	
	public int scoreForFrame(int theFrame) {

		ball = 0;
		int score = 0;
		for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
			if (strike()) {
				score += 10 + nextTwoBallForStrike();
				ball++;
			} 
			else if (spare()) {
				score += 10 + nextBallForSpare();
				ball += 2;
			} else {
				score += twoBallsInFrame();
				ball += 2;
			}
		}
		return score;
	}
	
	private boolean strike() {
		return itsThrows[ball] == 10;
	}

	private int nextTwoBallForStrike() {
		return itsThrows[ball+1] + itsThrows[ball + 2];
	}
	
	private int twoBallsInFrame(){
		return itsThrows[ball]+itsThrows[ball + 1];
	}

	private boolean spare() {
		return itsThrows[ball] + itsThrows[ball + 1] == 10;
	}

	private int nextBallForSpare() {
		return itsThrows[ball+2];
	}
}
