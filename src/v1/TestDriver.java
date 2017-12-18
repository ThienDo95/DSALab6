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
import java.util.concurrent.SynchronousQueue;

public class TestDriver
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
					Deq<String> one = new Deq<String>();

					String s ="";
					if(twoWords)
					{
						while(!(q.peek().equals("-")))
						{
							one.enqueue(q.dequeue());
						}
						q.dequeue();
						
						if(one.numItems > 0 && q.numItems > 0)
						{
							if(one.peek().equals(one.peekLast()) || q.peek().equals(q.peekLast()))
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

}

