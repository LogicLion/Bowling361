
public class Frame {
		private int firstThrow;
		private int secondThrow;
		private boolean isStrike;
		private boolean isSpare;
		
		public Frame(){
			firstThrow = 0;
			secondThrow = 0;
			isStrike=false;
			isSpare=false;
		}
		
		public void setFirstThrow(int thisThrow){
			firstThrow=thisThrow;
		}
		
		public int getFirstThrow(){
			return firstThrow;
		}
		
		public void setSecondThrow(int thisThrow){
			if(firstThrow==10)
			{
				throw new UnsupportedOperationException("Can't set second throw after a strike");
			}
			secondThrow=thisThrow;
		}
		
		public int getSecondThrow(){
			return secondThrow;
		}
		
		public int getFrameTotal(){
			return firstThrow + secondThrow;
		}
		
		
		public void setSpare(){
			if(firstThrow != 10 && firstThrow + secondThrow == 10){
				isSpare=true;
			}
		}
		
		public boolean isSpare(){
			return isSpare;
		}
		
		public void setStrike(){
			if(firstThrow == 10){
				isStrike = true;
			}
		}
		
		public boolean isStrike(){
			return isStrike;
		}
		
		
	}
