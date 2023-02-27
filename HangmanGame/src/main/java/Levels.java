
public enum Levels {

	EASY, HARD,INTERMEDIATE;
	
	public String toString() {
		switch(this) {
		case EASY: 
			return "easy";
		case INTERMEDIATE:
			return "intermediate";
		case HARD:
			return "hard";
		
		default:
			return "";
		}
	}
	
	 

	  public Levels getLevel() {
		return this;
		  
	  }

	
	
}
