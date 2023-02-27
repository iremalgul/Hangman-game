
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FrameOfHangman {
	
	static String choosenword;
	static String hint;
	static boolean answer;
	
	static Levels level = null;
	static List<Character> playerGuesses = new ArrayList<Character>();
	static String category = null;
	static JFrame frame = new JFrame();
	static JLabel img2 = new JLabel("");
	static int wrong_count = 0;
	static int count=0;
	static JLabel line = new JLabel();
	static char letter;
	static Celebrity celeb= new Celebrity();
	static CountryAndCity country = new CountryAndCity();
	static MoviesAndSeries movie= new MoviesAndSeries();
	static Category categories_level= new Category();

	public static void main(String[] args) {
		
				
		JPanel panel = new JPanel(null);
		
				// create swing frame
				frame.setTitle("HANGMAN");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.setSize(2000,800);

				// create menu label
				JLabel label = new JLabel();
				label.setText("HANGMAN");
				label.setHorizontalTextPosition(JLabel.CENTER);
				label.setVerticalTextPosition(JLabel.TOP);
				label.setForeground(new Color(68,5,104));
				label.setFont(new Font("Showcard Gothic",Font.BOLD,100));
				label.setBackground(Color.white);
				label.setBounds(503,109,600,250);
				panel.add(label);

				// create start button
				JButton button = new JButton();
				button.setBounds(650,400,350,350);
				button.setText("START");
				button.setFont(new Font("Georgia",Font.ITALIC,20));
				button.setSize(200,50);
				button.setFocusable(false);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						create_levels();
					}
				});
				panel.add(button);

				frame.setContentPane(panel);
				frame.getContentPane().setBackground(SystemColor.activeCaption);
				frame.getContentPane().setLayout(null);
				frame.getContentPane().add(button);
				frame.getContentPane().setBackground(new java.awt.Color(164, 123, 245));
				frame.setVisible(true);
			}

			public static void create_levels() {
				
				// create the panel
				JPanel panel = new JPanel(null);

				// create easy button
				JButton easy = new JButton("EASY");
				easy.setBounds(450,400,200,50);
				easy.setFont(new Font("Georgia",Font.ITALIC,20));
				easy.setSize(200,50);
				easy.setFocusable(false);
				easy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						level=level.EASY;
						categories_level.setLevel(level);
						create_categories();
					}
				});
				panel.add(easy);

				// create intermediate button
				JButton intermediate = new JButton("INTERMEDIATE");
				intermediate.setBounds(650,400,200,50);
				intermediate.setFont(new Font("Georgia",Font.ITALIC,20));
				intermediate.setSize(200,50);
				intermediate.setFocusable(false);
				intermediate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						level=level.INTERMEDIATE;
						categories_level.setLevel(level);
						create_categories();
					}
				});
				panel.add(intermediate);

				// create hard button
				JButton hard = new JButton("HARD");
				hard.setBounds(850,400,200,50);
				hard.setFont(new Font("Georgia",Font.ITALIC,20));
				hard.setSize(200,50);
				hard.setFocusable(false);
				hard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						level=level.HARD;
						categories_level.setLevel(level);
						create_categories();
					}
				});
				panel.add(hard);

				
				frame.setContentPane(panel);
				frame.getContentPane().setBackground(new java.awt.Color(164, 123, 245));
				
				// resets frame
				frame.revalidate();
				frame.repaint();
			}

			public static void create_categories() {

				// create panel
				JPanel panel = new JPanel(null);

				// create label
				JLabel label = new JLabel();
				label.setText("Select the category.");
				label.setHorizontalTextPosition(JLabel.CENTER);
				label.setVerticalTextPosition(JLabel.TOP);
				label.setForeground(new Color(68,5,104));
				label.setFont(new Font("Georgia",Font.ITALIC,30));
				label.setBackground(Color.white);
				label.setBounds(450,20,600,600);
				panel.add(label);

				// create movies button
				JButton movies = new JButton();
				movies.setBounds(450,400,200,50);
				movies.setText("MOVIE");
				movies.setFont(new Font("Georgia",Font.ITALIC,20));
				movies.setSize(200,50);
				movies.setFocusable(false);
				movies.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						category="movie";
						choosenword=movie.selectMovie().toString();
						Letters();
					}
				});
				panel.add(movies);

				// create celebrities button
				JButton celebrities = new JButton();
				celebrities.setBounds(650,400,200,50);
				celebrities.setText("CELEBRITY");
				celebrities.setFont(new Font("Georgia",Font.ITALIC,20));
				celebrities.setSize(200,50);
				celebrities.setFocusable(false);
				celebrities.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						category="celebrity";
						choosenword =celeb.selectCeleb().toString();
						Letters();
					}
				});
				panel.add(celebrities);

				// create countries button
				JButton countries = new JButton();
				countries.setBounds(850,400,200,50);
				countries.setText("COUNTRY");
				countries.setFont(new Font("Georgia",Font.ITALIC,20));
				countries.setSize(200,50);
				countries.setFocusable(false);
				countries.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						category="country";
						choosenword=country.selectCountry().toString();
						Letters();
					}
				});
				panel.add(countries);

			
				frame.setContentPane(panel);
				frame.getContentPane().setBackground(new java.awt.Color(164, 123, 245));
				
				// reset frame
				frame.revalidate();
				frame.repaint();
			}

			public static void Letters() {
				
				// create panel
				JPanel panel = new JPanel(null);

				// create the label
				JLabel label = new JLabel();
				label.setText("HANGMAN ");
				label.setHorizontalTextPosition(JLabel.CENTER);
				label.setVerticalTextPosition(JLabel.TOP);
				label.setForeground(new Color(0,0,0));
				label.setFont(new Font("Georgia",Font.ITALIC,40));
				label.setBackground(Color.white);
				label.setBounds(400,50,250,250);
				label.setVisible(true);

				// create hint button
				JButton Hint = new JButton();
				Hint.setBounds(410,650,990,350);
				Hint.setText("HINT");
				Hint.setFont(new Font("Georgia",Font.ITALIC,20));
				Hint.setSize(200,50);
				Hint.setFocusable(false);
				Hint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// chooses a hint in correct category and in correct difficulty
						switch (category) {
							case "movie":
								hint=movie.getHint();
								break;
							case "celebrity":
								hint=celeb.getHint();
								break;
								
							case "country":
								hint=country.getHint();
								break;
						}
						hints();
						Letters();
					}

					
				});
				panel.add(Hint);

				// create Character button
				JButton Character = new JButton();
				Character.setBounds(110,650,990,350);
				Character.setText("CHARACTER");
				Character.setFont(new Font("Georgia",Font.ITALIC,20));
				Character.setSize(200,50);
				Character.setFocusable(false);
				Character.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						giveLetter(choosenword, playerGuesses);
						make_a_guess(letter);
					}
				});
				panel.add(Character);

				// create guess button
				JButton Guess = new JButton();
				Guess.setBounds(710,650,990,350);
				Guess.setText("GUESS!");
				Guess.setFont(new Font("Georgia",Font.ITALIC,20));
				Guess.setSize(200,50);
				Guess.setFocusable(false);
				Guess.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(count<2) {
						    count++;
							guessword();
								}
								else {
									JOptionPane.showMessageDialog(null, "You can't guess no more");
								}
							}
					});
				panel.add(Guess);

				// create question button
				JButton Question = new JButton("QUESTION");
				Question.setBounds(710,550,350,350);
				Question.setFont(new Font("Georgia",Font.ITALIC,20));
				Question.setSize(200,50);
				Question.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						getAquestion();
					}
				});
				panel.add(Question);
				
				JLabel diamondImage = new JLabel("");
				diamondImage.setIcon(new ImageIcon("src/main/resources/img/diamond.jpeg"));
				diamondImage.setLabelFor(frame);
				diamondImage.setBounds(9, 10, 57, 61);
				//adds image to the panel
				panel.add(diamondImage); 
				
				// Create diamond text
				JTextArea diamond= new JTextArea();
				diamond.setText(String.valueOf("Diamond :"+Category.diamond));
				diamond.setForeground(new Color(0,0,0));
				diamond.setFont(new Font("Georgia",Font.ITALIC,30));
				diamond.setBackground(Color.white);
				diamond.setBounds(70,20,350,350);
				diamond.setPreferredSize(new Dimension(200, 200));
				diamond.setLineWrap(true);
				diamond.setWrapStyleWord(true);
				diamond.setOpaque(false);
				diamond.setEditable(false);
				panel.add(diamond);

				// create the keyboard
				final String[] keys = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
								 "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
				
				for(int i = 0; i < keys.length; i++) {
					JButton button = new JButton();

					int keyboard_length = 15;
					if (i < keyboard_length)
						button.setBounds(10 + i*60, 450, 990, 350);
					else
					button.setBounds(10 + (i-keyboard_length)*60, 550, 990, 350);
					button.setText(keys[i]);
					button.setFont(new Font("Georgia", Font.ITALIC, 20));
					button.setSize(55, 55);
					button.setFocusable(false);
					final int index = i;
					button.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							make_a_guess(keys[index].charAt(0));
						}
					});
					panel.add(button);
				}

				frame.setContentPane(panel);
				frame.getContentPane().setBackground(new java.awt.Color(164, 123, 245));
				
				// reset frame
				frame.revalidate();
				frame.repaint();

				// print the hangman and letters to the screen
				printWord();
				printHangedman();
		 	}

			//gets the choosen hint and arrange the diamond amount
			public static void hints() {
				
				   if(Category.diamond>1) {
						JOptionPane.showMessageDialog(null, "Hear your hint! "+"\n"+hint);
						--Category.diamond;
						--Category.diamond;
						Letters();
				   }
				   
				   else{
					   JOptionPane.showMessageDialog(null, "You don't have enough diamond");  
				   }
				}
			
			
			public static void giveLetter(String word, List<Character> playerGuesses) {
				//It checks if there are enough diamonds and accordingly puts a 
				//random letter on the screen in the positions it is in the word.
				
				if(Category.diamond!=0) {
				Random gen= new Random();
				do {
				int index= gen.nextInt(word.length());
			    letter= word.charAt(index);
				}while (playerGuesses.contains(letter));
				playerGuesses.add(letter);
		        --Category.diamond;
				Letters();
				printHangedman();
				}
				else
					JOptionPane.showMessageDialog(null,"You dont have enough diamond"); 
			}
		 
			public static void guessword () {
				// take the guess from the user through input dialog
				String sentence = JOptionPane.showInputDialog("Enter a full guess");

				String result;
				if(choosenword.equalsIgnoreCase(sentence)) {
					Category.diamond++;
					result="CORRECT GUESS!"+"\n"+"You have "+Category.diamond+" diamond." ;
					JOptionPane.showMessageDialog(null,result,"Massage", JOptionPane.PLAIN_MESSAGE);
					Letters();
					printHangedman();
					playerGuesses.clear();
		        	wrong_count = 0;
		        	
		        	//after the game is over asks the user to continiue or not.
		        	try { Thread.sleep(1000); } catch(Exception e) {} 
					int dialogButton=JOptionPane.showConfirmDialog (null, "Do you want to continue?");
					
					
		            if (dialogButton == JOptionPane.YES_OPTION) {
		            	  JOptionPane.showMessageDialog(null, "CONTINUE");
		            	  try { Thread.sleep(1000); } catch(Exception e) {} 
			               playerGuesses.clear();
				           wrong_count = 0;
				           create_levels();
		            
		            }
		            else {
		            	 JOptionPane.showMessageDialog(null, "GOODBYE");
		            	 try { Thread.sleep(1000); } catch(Exception e) {} 
			              System.exit(0);
		            }
				}
				
				//checks the guess
				else {
					result="WRONG GUESS!!";
					JOptionPane.showMessageDialog(null,result,"Massage",JOptionPane.ERROR_MESSAGE);
					--Category.diamond;
					Letters();
					printHangedman();
				}
			}

			public static void getAquestion() {
				        // create a question
						Questions questions= new Questions();
						String question=questions.selectQuestion();

						// create message dialogue for question
						JOptionPane.showMessageDialog(null,"Here is your question "+"\n"+question);

						// get the answer to the question
						String cumle=JOptionPane.showInputDialog("Enter the answer");

						answer=questions.answerCorrect(cumle);
						
						if(answer) {
							Category.diamond++;
							JOptionPane.showMessageDialog(null,"Your answer is correct. 1 diamond gained."+"\n"+"You have "+Category.diamond+" diamond.");
							Letters();
							printHangedman();
						}
						else {
							JOptionPane.showMessageDialog(null,"Your answer is incorrect. No diamonds gained"+"\n"+"You have "+Category.diamond+" diamond.");
							Letters();
							printHangedman();
						}
					}
			

			public static void make_a_guess(char guessingLetter) {
					
				// save the guess
				playerGuesses.add(Character.toLowerCase(guessingLetter));

				// if the guess was correct
				if(choosenword.toLowerCase().contains(Character.toString(Character.toLowerCase(guessingLetter)))){
					printWord();
					// if the game is won
					if(is_game_won()) {
						
						Category.diamond++;
						Letters();
						
						//create the winning label
						JLabel situation1 = new JLabel();
						situation1.setText("YOU WIN !");
						situation1.setHorizontalTextPosition(JLabel.CENTER);
						situation1.setVerticalTextPosition(JLabel.TOP);
						situation1.setForeground(new Color(68,5,104));
						situation1.setFont(new Font("Georgia",Font.BOLD,35));
						situation1.setBackground(Color.white);
						situation1.setBounds(20,20, 400, 763);
						frame.getContentPane().add(situation1);
						
						//calls this method to update the hangman situation
						printHangedman();
						
						//after the game is over asks the user to continiue or not.
						try { Thread.sleep(1000); } catch(Exception e) {} 
						int dialogButton=JOptionPane.showConfirmDialog (null, "Do you want to continue?");
			            if (dialogButton == JOptionPane.YES_OPTION) {
			            	  JOptionPane.showMessageDialog(null, "CONTINUE");
			            	  try { Thread.sleep(1000); } catch(Exception e) {} 
				               playerGuesses.clear();
					           wrong_count = 0;
					           create_levels(); 
			            }
			            else {
			            	 JOptionPane.showMessageDialog(null, "GOODBYE");
			            	 try { Thread.sleep(1000); } catch(Exception e) {} 
				              System.exit(0);
			            }
			            //restarts the frame
			            frame.revalidate();
						frame.repaint();
					}
					
				}
				
				else {
					// if the guess was incorrect
					wrong_count++;
					Letters();
				}

				if(wrong_count==6) {
					// if the game is losed
					
					//create the winning label
					JLabel situation2 = new JLabel();
					situation2.setText("YOU LOSE !");
					situation2.setHorizontalTextPosition(JLabel.CENTER);
					situation2.setVerticalTextPosition(JLabel.TOP);
					situation2.setForeground(new Color(68,5,104));
					situation2.setFont(new Font("Georgia",Font.BOLD,35));
					situation2.setBackground(Color.white);
					situation2.setBounds(20,20, 400, 763);
					frame.getContentPane().add(situation2);
					
					//writes the played words original to the screen
					JLabel correctAnswer = new JLabel();
					correctAnswer.setText(choosenword);
					correctAnswer.setHorizontalTextPosition(JLabel.CENTER);
					correctAnswer.setVerticalTextPosition(JLabel.TOP);
					correctAnswer.setForeground(new Color(68,5,104));
					correctAnswer.setFont(new Font("Georgia",Font.BOLD,32));
					correctAnswer.setBackground(Color.white);
					correctAnswer.setBounds(300,20,800,763);
					frame.getContentPane().add(correctAnswer);
					
					//after the game is over asks the user to continiue or not.
					try { Thread.sleep(1000); } catch(Exception e) {} 
					int dialogButton=JOptionPane.showConfirmDialog (null, "Do you want to continue?");
		            if (dialogButton == JOptionPane.YES_OPTION) {
		            	  JOptionPane.showMessageDialog(null, "CONTINUE");
		            	  try { Thread.sleep(1000); } catch(Exception e) {} 
			               playerGuesses.clear();
				           wrong_count = 0;
				           create_levels();
		            }
		            else {
		            	 JOptionPane.showMessageDialog(null, "GOODBYE");
		            	 try { Thread.sleep(1000); } catch(Exception e) {} 
			              System.exit(0);
		            }
		            //restarts the frame
					frame.revalidate();
					frame.repaint();
				}
			}
			
			private static void printHangedman() {
				//it shows the images dependingly to the wrong counter
				if(wrong_count == 0) {
					JLabel img3 = new JLabel("");
					img3.setIcon(new ImageIcon("src/main/resources/img/0.jpeg"));
					img3.setBounds(850,0, 986, 763);
					frame.getContentPane().add(img3);
				}
				
				if (wrong_count == 1) {
					 JLabel img4 = new JLabel("");
				     img4.setIcon(new ImageIcon("src/main/resources/img/1.jpeg"));
					 img4.setBounds(850,0, 986, 763);
					 frame.getContentPane().add(img4);
				    }
				
				if (wrong_count == 2) {
				     JLabel img5 = new JLabel("");
					 img5.setIcon(new ImageIcon("src/main/resources/img/2.jpeg"));
					 img5.setBounds(850,0, 986, 763);
					 frame.getContentPane().add(img5);
				    }
				    
				if (wrong_count == 3) {
				     JLabel img6 = new JLabel("");
					 img6.setIcon(new ImageIcon("src/main/resources/img/3.jpeg"));
					 img6.setBounds(850,0, 986, 763);
					 frame.getContentPane().add(img6);
				      }
				    
			    if (wrong_count == 4) {
				     JLabel img7 = new JLabel("");
					 img7.setIcon(new ImageIcon("src/main/resources/img/4.jpeg"));
					 img7.setBounds(850,0, 986, 763);
					 frame.getContentPane().add(img7);
				    }
				    
				if (wrong_count == 5) {
				    JLabel img8 = new JLabel("");
					img8.setIcon(new ImageIcon("src/main/resources/img/5.jpeg"));
					img8.setBounds(850,0, 986, 763);
					frame.getContentPane().add(img8);
				    }
						 
				if (wrong_count == 6) {
					JLabel img9 = new JLabel("");
					img9.setIcon(new ImageIcon("src/main/resources/img/6.jpg"));
					img9.setBounds(850,0, 986, 763);
					frame.getContentPane().add(img9);
				      }
				    frame.setVisible(true);
			}

			public static void printWord() {
				//firstly it shows the lines in the screen
				//then it fills up the letters in the right locations
				
				JPanel panel = (JPanel) frame.getContentPane();
				for (int a=0; a<=choosenword.length(); a++) {
					JLabel line = new JLabel();
					for(int b=0;b<a;b++) {
						if(playerGuesses.contains(choosenword.charAt(b))) {
							line.setText(choosenword.charAt(b)+"");
						}
						else {
							if(choosenword.charAt(b) ==  ' ' ) {
								line.setText("  ");
							}
							else if(!(choosenword.charAt(b) ==' ')) {
								line.setText("_ ");
							}
						}
						line.setHorizontalTextPosition(JLabel.CENTER);
						line.setVerticalTextPosition(JLabel.CENTER);
						line.setForeground(new Color(0,0,0));
						line.setFont(new Font("Georgia",Font.ITALIC,40));
						line.setBackground(Color.white);
						line.setBounds(100+30*a,200,250,250);
					}
				panel.add(line);
				}
				frame.getContentPane().setBackground(new java.awt.Color(164, 123, 245));
				
				//restarts the frame
				frame.revalidate();
				frame.repaint();
			}

			public static boolean is_game_won(){
				//it checks if all the letters in the word guessed correctly
				
				boolean won = true;
				String new_choosenword = choosenword.replaceAll("\\s", "");
				for(int i = 0; i < new_choosenword.length(); i++){
					char letter = new_choosenword.charAt(i);
		             if (!playerGuesses.contains(letter)) {
						won = false;
						break;
					}
				}
				return won;
			}
		}
