
public class Scorecard {
	private Frame[] Scorecard;
	private int totalScore;
	private int currentFrame;
	private int currentThrow;
	
	private final int STRIKE_SCORE = 10;
	
	public Scorecard()
	{
		Scorecard= new Frame[10];
		totalScore=0;
		currentFrame = 0;
		currentThrow = 1;
	}
	
	public void setTotalScore(int newScore)
	{
		this.totalScore = newScore
	}
	
	public int getTotalScore()
	{
		return totalScore;
	}
	
	public void setCurrentFrame(int newFrame)
	{
		currentFrame = newFrame;
	}
	
	public int getCurrentFrame()
	{
		return currentFrame;
	}
	
	public void setCurrentThrow(int newThrow)
	{
		currentThrow = newThrow;
	}
	
	public int getCurrentThrow()
	{
		return currentThrow;
	}
	
	public void advanceFrame()
	{
		setCurrentFrame(getCurrentFrame() + 1);
	}
	
	public void advanceThrow()
	{
		if(currentThrow == 1) setCurrentThrow(2);
		else setCurrentThrow(1);
	}
	
	public void handleThrow(int pinsDown)
	{
		if(pinsDown<0  || pinsDown+Scorecard[currentFrame].getFirstThrow()>10)
		{
			throw new IllegalStateException("Pins knocked down is invalid");
		}
		if(currentThrow==1)	throwOneCase(pinsDown);
		
		else throwTwoCase(pinsDown);
	}
	
	public void throwOneCase(int pinsDown)
	{
		
		Scorecard[currentFrame].setFirstThrow(pinsDown);
		
		if(Scorecard[currentFrame].getFirstThrow() == 10)
		{
			Scorecard[currentFrame].setStrike();
			advanceFrame();
		}
		
		else advanceThrow();
		
	}
	
	public void throwTwoCase(int pinsDown)
	{
		Scorecard[currentFrame].setSecondThrow(pinsDown);
		
		if(Scorecard[currentFrame].getFrameTotal() == 10) 
		{
			Scorecard[currentFrame].setSpare();
		}
		
		advanceFrame();
		advanceThrow();
	}
	
	public int totalScoreCalculator()
	{
		for (Frame T : Scorecard)
		{
			setTotalScore(getTotalScore() += T.getFrameTotal())
		}
	}
	
	public int getFrameScore(int indexofFrame)
	{
		int score = Scorecard[indexofFrame].getFrameTotal();
		if(Scorecard[indexofFrame].isSpare()){
			score += Scorecard[indexofFrame+1].getFrameTotal();
		}
		
		else if(Scorecard[indexofFrame].isStrike())
		{
			score += Scorecard[indexofFrame+1].getFrameTotal() + Scorecard[indexofFrame+2].getFrameTotal();
		}
		return score;
	}
	
	
	
}
