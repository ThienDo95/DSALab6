package v1;
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 03/01/2017
 * Submitted:  03/02/2017
 * Comment: test suite and sample run attached
 * @author: Thien Do
 * @version: 03/01/2017
 */
import java.io.*;

public class Driver2
{

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException
	{
		Deq <String> d = new Deq<String>();
		int i;
		do
		{
			System.out.println("\n"+"Application's Options: ");
			System.out.println("                       ");
			System.out.println("1.   Insert item at back of Deq.");
			System.out.println("2.   Insert item at front of Deq.");
			System.out.println("3.   Remove item from front of Deq.");
			System.out.println("4.   Remove item from back of Deq.");
			System.out.println("5.   Display front item of Deq.");
			System.out.println("6.   Display last item of Deq.");
			System.out.println("7.   Clear Deq.");
			System.out.println("8.   Display content of Deq.");
			System.out.println("9.   Exit.");
			System.out.println("                       ");
			System.out.println("Choose your option: " + "\n");
			String input = stdin.readLine().trim();
			System.out.println(input);
			i = Integer.parseInt(input);

			if (i > 0 && i < 10)
			{
				switch(i)
				{
					case 1:
						System.out.println("Enter an item to insert at the back: ");
						String item = stdin.readLine().trim();
						d.enqueue(item);
						break;
					case 2:
						System.out.println("Enter an item to insert at the front: ");
						String item2 = stdin.readLine().trim();
						d.enqueueFirst(item2);
						break;
					case 3:
						System.out.println(d.peek() + " has been removed from the front queue");
						d.dequeue();
						break;
					case 4:
						System.out.println(d.peekLast() + " has been removed from the end queue");
						d.dequeueLast();
						break;
					case 5:
						System.out.println(d.peek() + " is your front item");
						break;
					case 6:
						System.out.println(d.peekLast() + " is your last item");
						break;	
					case 7:
						d.dequeueAll();
						System.out.println("Queue has been cleared");
						break;
					case 8:
						System.out.println(d.toString());
						break;
					case 9:
						System.out.println("PEACE");
						break;
				}
			}
		}while(i < 9 || i > 9);
	}
}

