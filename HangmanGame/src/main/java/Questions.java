

import java.util.ArrayList;
import java.util.List;

public class Questions {
	private  boolean IsanswerCorrect;	
	private  String question,answer;
	
	
	 List<String> list= new ArrayList<String>();
		
		
		public Questions() {
			this.question="";
			this.answer="";
		}
		
		public void setQuestions() {
			list.add("where is capital of Turkey?");
			list.add("How many of Henry VIII's wives were called Catherine?");
			list.add("What was the most popular girls name in the UK in 2019?");
			list.add("Which popular video game franchise has released games with the subtitles World At War and Black Ops?");
			list.add("In what US State is the city Nashville?");
			list.add("What is the currency of Denmark?");
			list.add("In which European country would you find the Rijksmuseum?");
			list.add("How many films have Al Pacino and Robert De Niro appeared in together?");
			list.add("What is the smallest planet in our solar system?");
			list.add("Which legendary surrealist artist is famous for painting melting clocks?");
			list.add("What was the Turkish city of Istanbul called before 1930?");
			list.add("How many times has England won the men's football World Cup?");
			list.add("What is the capital of New Zealand?");
			list.add("From what grain is the Japanese spirit Sake made?");
			list.add("How many permanent teeth does a dog have?");
			list.add("Which country in the world is believed to have the most miles of motorway?");
			list.add("Which colour pill does Neo swallow in The Matrix?");
			list.add("According to McDonalds' official website, how many calories does a regular Big Mac contain?");
			list.add("Which southern Italian city is usually credited as the birthplace of the pizza?");
			list.add("What is the capital city of Australia?");
			list.add("How many countries are there in the region of Europe? ");
			list.add("What is the capital of Finland?");
			list.add("What language is spoken in Brazil?");
			list.add("What company is also the name of one of the longest rivers in the world?");
			list.add("What is the tallest mountain in the world?");
			list.add("What is taller, an elephant or a giraffe?");
					
			}
			
		
		

	  public List<String> getQuestion() {
		 setQuestions();
		 return list;
	   }
		
	  public String selectQuestion() {
		  getQuestion();
		  int index=(int)(Math.random()*(list.size()));
		  if(index<list.size())
		  question=list.get(index);
		  return question;
		  
	  }
	  
	  public  void setAnswer() {
		  if(question.equalsIgnoreCase("Where is capital of turkey?"))
			  answer="Ankara";
		  else if(question.equalsIgnoreCase("How many of Henry VIII's wives were called Catherine?"))
			  answer="3";
		  else if(question.equalsIgnoreCase("What was the most popular girls name in the UK in 2019?"))
			  answer="Olivia";
		  else if(question.equalsIgnoreCase("Which popular video game franchise has released games with the subtitles World At War and Black Ops?"))
			  answer="Call of Duty";
		  else if(question.equalsIgnoreCase("In what US State is the city Nashville?"))
			  answer="Tennessee";
		  else if(question.equalsIgnoreCase("What is the currency of Denmark?"))
			  answer="Krone";
		  else if(question.equalsIgnoreCase("In which European country would you find the Rijksmuseum?"))
			  answer="Netherlands";
		  else if(question.equalsIgnoreCase("How many films have Al Pacino and Robert De Niro appeared in together?"))
			  answer="4";
		  else if(question.equalsIgnoreCase("What is the smallest planet in our solar system?"))
			  answer="Mercury";
		  else if(question.equalsIgnoreCase("Which legendary surrealist artist is famous for painting melting clocks?"))
			  answer="Salvador Dali";
		  else if(question.equalsIgnoreCase("What was the Turkish city of Istanbul called before 1930?"))
			  answer="Constantinople";
		  else if(question.equalsIgnoreCase("How many times has England won the men's football World Cup?"))
			  answer="1";
		  else if(question.equalsIgnoreCase("What is the capital of New Zealand?"))
			  answer="Wellington";
		  else if(question.equalsIgnoreCase("From what grain is the Japanese spirit Sake made?"))
			  answer="Rice";
		  else if(question.equalsIgnoreCase("How many permanent teeth does a dog have?"))
			  answer="42";
		  else if(question.equalsIgnoreCase("Which country in the world is believed to have the most miles of motorway?"))
			  answer="China";
		  else if(question.equalsIgnoreCase("Which colour pill does Neo swallow in The Matrix?"))
			  answer="red";
		  else if(question.equalsIgnoreCase("According to McDonalds' official website, how many calories does a regular Big Mac contain?"))
			  answer="508";
		  else if(question.equalsIgnoreCase("Which southern Italian city is usually credited as the birthplace of the pizza?"))
			  answer="Naples";
		  else if(question.equalsIgnoreCase("What is the capital city of Australia?"))
			  answer="Canberra";
		  else if(question.equalsIgnoreCase("How many countries are there in the region of Europe? "))
			  answer="44";
		  else if(question.equalsIgnoreCase("What is the capital of Finland?"))
			  answer="Helsinki";
		  else if(question.equalsIgnoreCase("What language is spoken in Brazil?"))
			  answer="Portuguese";
		  else if(question.equalsIgnoreCase("What company is also the name of one of the longest rivers in the world?"))
			  answer="Amazon";
		  else if(question.equalsIgnoreCase("What is the tallest mountain in the world?"))
			  answer="Mount Everest";
		  else if(question.equalsIgnoreCase("What is taller, an elephant or a giraffe?"))
			  answer="giraffe";
		  
		  
		  
	  }
	  
	  public  String getAnswer() {
		  setAnswer();
		  return answer;
	  }
	  
		public boolean answerCorrect(String playerAnswer) {
			getAnswer();
			IsanswerCorrect=answer.equalsIgnoreCase(playerAnswer);
			return IsanswerCorrect;
		}
		
	
		
		
}
