package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 03/01/2017
 * Submitted:  03/02/2017
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 03/01/2017
 */
import java.io.*;

public class Driver1
{

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException
	{
		QueueBasedResizedArray <String> qb = new QueueBasedResizedArray<String>();
		int i;
	
		do
		{
			System.out.println("\n"+"Application's Options: ");
			System.out.println("                       ");
			System.out.println("1. Insert item at back of queue");
			System.out.println("2. Remove item from front of queue");
			System.out.println("3. Display front item");
			System.out.println("4. Clear queue");
			System.out.println("5. Display content of queue");
			System.out.println("6. Exit");
			System.out.println("                       ");
			System.out.println("Choose your option: " + "\n");
			String input = stdin.readLine().trim();
			System.out.println(input);
			i = Integer.parseInt(input);

			if (i > 0 && i < 7)
			{
				switch(i)
				{
					case 1:
						System.out.println("Enter an item: ");
						String item = stdin.readLine().trim();
						qb.enqueue(item);
						break;
					case 2:
						System.out.println(qb.peek() + " has been dequeued from queue");
						qb.dequeue();
						break;
					case 3:
						System.out.println(qb.peek() + " is your front item");
						break;
					case 4:
						qb.dequeueAll();
						System.out.println("Queue has been cleared");
						break;
					case 5:
						System.out.println(qb.toString());
						break;
					case 6:
						System.out.println("PEACE");
						break;				
				}
			}
		}while(i < 6 || i > 6);
	}
	

}

