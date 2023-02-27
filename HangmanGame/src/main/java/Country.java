
public enum Country {
	TOKYO,MADRID,CHINA,INDIA,DAEGU,DUBLIN,MUNIH,THAILAND,CUBA,HELSINKI,SRI_LANKA,KUALA_LUMPUR;
	
	public String toString() {
		switch(this) {
		case TOKYO:
			return "tokyo";
		case MADRID:
			return "madrid";
		case CHINA:
			return "china";
		case INDIA:
			return "india";
		case DAEGU:
			return "daegu";
		case DUBLIN:
			return "dublin";
		case MUNIH:
			return "münih";
		case THAILAND:
			return "thailand";
		case CUBA:
			return "cuba";
		case HELSINKI:
			return "helsinki";
		case SRI_LANKA:
			return "sri lanka";
		case KUALA_LUMPUR:
			return "kuala lumpur";
			
			
		default:
			return "";
		}
	}


}
