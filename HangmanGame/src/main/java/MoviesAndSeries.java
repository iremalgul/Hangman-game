
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

public class MoviesAndSeries extends Category {
	
	Random generator = new Random();
	
	//private Levels level;
	private Movie selected_word = null;
	private String hint=null;
	private Category category;
    HashMap<String,Movie> easy_map;
    HashMap<String,Movie> int_map;
    HashMap<String,Movie> hard_map;
	
	 public MoviesAndSeries() {
		easy_map=new HashMap<String,Movie>();
        int_map=new HashMap<String,Movie>();
        hard_map=new HashMap<String,Movie>();
        
        
       
}

	 
	
	 public void setMovie() {
		
			 
		 easy_map.put("the film, which deals with the magicians of the fantastic world",Movie.HARRY_POTTER);
		 easy_map.put("One of the most cult series that foreign people watch to learn English",Movie.FRIENDS);
		 easy_map.put("Best director and best cinematography awards. Also, the film was shot in black and white",Movie.ROMA);
	
				 
		 int_map.put( "Former wrestler Mahavir Singh Phogat and his two wrestler daughters struggle towards glory at the Commonwealth Games in the face of societal oppression",Movie.DANGAL);
		 int_map.put("\"The night is darkest just before the dawn.\" is one of the most famous line. ",Movie.BATMAN);
		 int_map.put("The plot of the film is actually a reflection of the rivalry and ambition between two of the most important scientists in history, Nikola Tesla and Thomas Edison",Movie.THE_PRESTIGE);
		 int_map.put("It tells the story of a programmer who was invited to manage a humanoid robot with artificial intelligence",Movie.EX_MACHINE);
		 
		 hard_map.put( "a film about the life of its president, the first lgbt+ people in America",Movie.MILK);
	     hard_map.put("The main actor in the film is Leonardo DiCaprio and the film director is Christopher Nolan",Movie.INCEPTION);
	     hard_map.put( "the story of a young female ex-soldier, animation",Movie.VIOLET_EVERGARDEN);
	     hard_map.put( "the story of a gay boy trying to find himself who committed suicide",Movie.SUICIDE_ROOM);
	}
	 
	 
	 
	 public Movie selectMovie() {
		 setMovie();
			
		 
		 switch(FrameOfHangman.categories_level.getLevel())
			{
			 case EASY:
			 {
				//easy_map içerisinden rondom celeb seçip return edecek
				Object[] values = easy_map.values().toArray();
				Object randomValue = values[generator.nextInt(values.length)];
				 
				 selected_word= (Movie)randomValue;
				
				 getKey(easy_map,selected_word);
				 return selected_word;
				 
				 }
					
			 
			 
			 case INTERMEDIATE:
			 {
				//int_map içerisinden rondom celeb seçip return edecek
				 
				 Object[] values = int_map.values().toArray();
				 Object randomValue = values[generator.nextInt(values.length)];
				
				 selected_word= (Movie)randomValue;
			
				 getKey(int_map,selected_word);
				 return selected_word;
				 }
				 
			 
			 
			 case HARD:
			 {
				 //hard_map içerisinden rondom celeb seçip return edecek
				 Object[] values = hard_map.values().toArray();
				 Object randomValue = values[generator.nextInt(values.length)];
			   
				 selected_word= (Movie)randomValue;
				
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
