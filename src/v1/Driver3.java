package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 3
 * Status: Incomplete
 * Last update: 03/01/17
 * Submitted:  03/02/17
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 2017.03.01
 */
import java.io.*;

public class Driver3
{
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException{


		Deq<String> q= new Deq<String>();
		String currentChar ="";
		String input ="";
		int i;
		String answer ="";
		String output ="";
		boolean twoWords = false;
		boolean paliPossible = false;

		do
		{
			System.out.println("1. To enter character");
			System.out.println("2. To check if palindrome, content length, or no minus");
			input = stdin.readLine().trim();
			i = Integer.parseInt(input);
			switch(i)
			{
				case 1:
					System.out.println("Enter Character: " );
					currentChar = stdin.readLine().trim();
					q.enqueue(currentChar);
					if(currentChar.equals("-"))
					{
						twoWords = true;
					}
					break;
				case 2:
					if(twoWords)
					{
						Deq<String> wordOne = new Deq<String>();
						Deq<String> wordTwo = new Deq<String>();
						for(String s = q.dequeue(); currentChar != null; s = q.dequeue())
						{						
							if(currentChar.equals("-"))
							{
								for(currentChar = q.dequeue(); currentChar!=null; currentChar = q.dequeue())
								{
									wordTwo.enqueue(currentChar);
								}
							}
							else{
								wordOne.enqueue(currentChar);
							}
						}

						if(wordOne.numItems > 0 && wordTwo.numItems > 0)
						{
							if(wordOne.peek().equals(wordOne.peekLast()) || wordTwo.peek().equals(wordTwo.peekLast()))
							{
								paliPossible = true;
							}
						}

						if(wordOne.numItems != wordTwo.numItems)
						{
							if(wordOne.numItems < wordTwo.numItems)
							{
								output = "Right Longer";
							}
							else
							{
								output ="Left Longer";
							}
						}

						else if(wordOne.numItems == wordTwo.numItems)
						{
							String w1 ="";
							String w1Pali ="";
							String w2 ="";
							String w2Pali ="";
							StackBasedWithResizableArray<String> wordOneCopy = new StackBasedWithResizableArray<String>();
							StackBasedWithResizableArray<String> wordTwoCopy = new StackBasedWithResizableArray<String>();
							for(currentChar = wordOne.dequeue(); currentChar != null; currentChar = wordOne.dequeue())
							{
								w1 += currentChar;
								wordOneCopy.push(currentChar);
							}
							for(currentChar = wordTwo.dequeue(); currentChar != null; currentChar = wordTwo.dequeue())
							{
								w2+=currentChar;
								wordTwoCopy.push(currentChar);
							}

							if((wordOneCopy.top>=0 || wordTwoCopy.top>=0) && paliPossible)
							{
								for(currentChar = wordOneCopy.pop(); currentChar != null; currentChar = wordOneCopy.pop())
								{
									w1Pali += currentChar;

								}
								for(currentChar = wordTwoCopy.pop(); currentChar != null; currentChar = wordTwoCopy.pop())
								{
									w2Pali += currentChar;
								}
							}
							if(w1.length()==w2.length())
							{					
								output += "Same Length";
							}
							if(w1.equals(w2))
							{
								output += " and Same Content,";

							}
							else
							{
								output += ", Different Content";
							}
							if((w1.equals(w1Pali)||w2.equals(w2Pali)) && (w1.length() > 0 && w2.length() > 0))
							{
								output +=" Palindrone";
							}
							else
							{
								output += " No Palindrone";
							}
						}
					}
					else
					{
						output = "No Minus";
					}


					break;
			}

		}while(i != 2);


		System.out.println("This is your result: " + output);
	}

	public static void addtoArray()
	{

	}
}

