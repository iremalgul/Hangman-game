
public enum Movie {
 HARRY_POTTER,FRIENDS,DANGAL,BATMAN,MILK,INCEPTION,ROMA,THE_PRESTIGE,EX_MACHINE, VIOLET_EVERGARDEN, SUICIDE_ROOM,MONEYBALL ;
	
	public String toString() {
		switch(this) {
		case HARRY_POTTER:
			return "harry potter";
		case FRIENDS:
			return "friends";
		case DANGAL:
			return "dangal";
		case BATMAN:
			return "batman";
		case MILK:
			return "milk";
		case INCEPTION:
			return "inception";
		case ROMA:
			return "roma";
		case THE_PRESTIGE :
			return "the prestige";
		case EX_MACHINE :
			return "ex machine";
		case VIOLET_EVERGARDEN :
			return "violet evergarden";
		case SUICIDE_ROOM :
			return "suicide room";
		case MONEYBALL :
			return "moneyball";
			
		default:
			return "";
		}
	}
	
}
