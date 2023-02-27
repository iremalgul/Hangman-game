
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

public class Celebrity extends Category {
	
	
	Random generator = new Random();
	
	
	private Celeb selected_word = null;
	private String hint=null;
	private Category category;
    HashMap<String,Celeb> easy_map;
    HashMap<String,Celeb> int_map;
    HashMap<String,Celeb> hard_map;
	
	 public Celebrity() {
		easy_map=new HashMap<String,Celeb>();
        int_map=new HashMap<String,Celeb>();
        hard_map=new HashMap<String,Celeb>();
       
        
       
}
	 

	 public void setCeleb() {
		
			 
		 easy_map.put("Former One Direction band member",Celeb.HARRY_STYLES);
		 easy_map.put( "Twilight Edward",Celeb.ROBERT_PATTINSON);
		 easy_map.put("Turkish pop singer",Celeb.TARKAN);
		 easy_map.put("French singer-songwriter in jazzy styles",Celeb.ZAZ);
				 
		 int_map.put( "the female singer who performed the song chandelier",Celeb.SIA);
		 int_map.put( "she was the memmber of Destinys Child",Celeb.BEYONCE);
		 int_map.put( "founder of tesla",Celeb.ELON_MUSK);

		 
		 
		 hard_map.put( "one of the actors of the elite series",Celeb.MANU_RIOS);
	     hard_map.put("golden maknae",Celeb.JUNGKOOK);
	     hard_map.put("The Matrix",Celeb.KEANU_REEVES);
	     hard_map.put("turkey national volleyball team captain",Celeb.EDA_ERDEM);
	}
	 
	 
	 
	 public Celeb selectCeleb() {
		 setCeleb();
			
		 
		 switch(FrameOfHangman.categories_level.getLevel())
			{
			 case EASY:
			 {
				//easy_map içerisinden rondom celeb seçip return edecek
				Object[] values = easy_map.values().toArray();
				Object randomValue = values[generator.nextInt(values.length)];
				 
				 selected_word= (Celeb)randomValue;
				 getKey(easy_map,selected_word);
				 return selected_word;
				 
				 }
					
			 
			 
			 case INTERMEDIATE:
			 {
				//int_map içerisinden rondom celeb seçip return edecek
				 
				 Object[] values = int_map.values().toArray();
				 Object randomValue = values[generator.nextInt(values.length)];
				
				 selected_word= (Celeb)randomValue;
				 getKey(int_map,selected_word);
				 return selected_word;
				 }
				 
			 
			 
			 case HARD:
			 {
				
				 Object[] values = hard_map.values().toArray();
				 Object randomValue = values[generator.nextInt(values.length)];
			   
				 selected_word= (Celeb)randomValue;
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
