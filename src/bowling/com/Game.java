package bowling.com;

public class Game {

	private int itsCurrentFrame = 1;
	private boolean firstThrowInFrame = true;
	private Scorer itsScorer = new Scorer();

	public void add(int pins) {
		itsScorer.addThrow(pins);
		adjustCurrentFrame(pins);
	}

	private void adjustCurrentFrame(int pins) {
		if (lastBallInFrame(pins) ) {
			advanceFrame();
		} else {
			firstThrowInFrame = false;
		}
	}

	private boolean lastBallInFrame(int pins) {
		return strike(pins) || (!firstThrowInFrame);
	}

	private boolean strike(int pins) {
		return firstThrowInFrame && pins == 10;
	}

	private boolean adjustFrameForStrike(int pins){
		if(pins == 10){
			advanceFrame();
			return true;
		}
		return false;
	}
	
	private void advanceFrame() {
		itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);
	}

	public int score() {
		return scoreForFrame(itsCurrentFrame);
	}

	public int scoreForFrame(int theFrame) {

		return itsScorer.scoreForFrame(theFrame);
	}


}
