
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

public class CountryAndCity extends Category{
	
	Random generator = new Random();
	
	//private Levels level;
	private Country selected_word = null;
	private String hint=null;
	private Category category;
    HashMap<String,Country> easy_map;
    HashMap<String,Country> int_map;
    HashMap<String,Country> hard_map;
	
	 public  CountryAndCity() {
		easy_map=new HashMap<String,Country>();
        int_map=new HashMap<String,Country>();
        hard_map=new HashMap<String,Country>();
       
        
       
}
	 

	 
	 
	 
	 
	 
	
	 
	 
	
	 public void setCountry() {
		
			 
		 easy_map.put("The city that hosts the 2020 Olympic games",Country.TOKYO);
		 easy_map.put( "capital of Spain",Country.MADRID);
		 easy_map.put( "A bigger city in Germany",Country.MUNIH);
		 easy_map.put( "The country where the Temple of the Great Buddha is located",Country.THAILAND);
				 
		 int_map.put( "1st most populous country in the world.",Country.CHINA);
		 int_map.put( "country where the cow is considered a sacred animal",Country.INDIA);
		 int_map.put( "Che Guevara",Country.CUBA);
		 int_map.put( "capital city of Findland",Country.HELSINKI);
		 
		 hard_map.put( "where Kim Taehyung was born",Country.DAEGU);
	     hard_map.put("capital of Ireland",Country.DUBLIN);
	     hard_map.put("It is an island country located in the Indian Ocean",Country.SRI_LANKA);
	     hard_map.put("The capital of Malaysia",Country.KUALA_LUMPUR);
	}
	 
	 
	 
	 public Country selectCountry() {
		 setCountry();
			
		 
		 switch(FrameOfHangman.categories_level.getLevel())
			{
			 case EASY:
			 {
				//easy_map içerisinden rondom celeb seçip return edecek
				Object[] values = easy_map.values().toArray();
				Object randomValue = values[generator.nextInt(values.length)];
				 
				 selected_word= (Country)randomValue;
				 getKey(easy_map,selected_word);
				 return selected_word;
				 
				 }
					
			 
			 
			 case INTERMEDIATE:
			 {
				//int_map içerisinden rondom celeb seçip return edecek
				 
				 Object[] values = int_map.values().toArray();
				 Object randomValue = values[generator.nextInt(values.length)];
				
				 selected_word= (Country)randomValue;
			
				 getKey(int_map,selected_word);
				 return selected_word;
				 }
				 
			 
			 
			 case HARD:
			 {
				 //hard_map içerisinden rondom celeb seçip return edecek
				 Object[] values = hard_map.values().toArray();
				 Object randomValue = values[generator.nextInt(values.length)];
			   
				 selected_word= (Country)randomValue;
			
				 getKey(hard_map,selected_word);
				 return selected_word;
				 }
				default:
					return selected_word;
			 } 
		
				
		 
	 }
		
	 
	 private <K, V> void getKey(Map<K, V> map, V value)
	    {
	        for (Map.Entry<K, V> entry: map.entrySet())
	        {
	            if (value.equals(entry.getValue())) {
	            	hint=(String)entry.getKey();
	            	
	               
	            }
	        }
	      
	    }

	 public String getHint() {
	

		 return hint;
	 }

	
	
	
	
	

}
