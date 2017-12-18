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
public class QueueBasedResizedArray <T> implements QueueInterface <T>
{
	protected T[] items;
	protected int front;
	protected int end;
	protected int numItems;
	
	public QueueBasedResizedArray()
	{
		items = (T[]) new Object[3];
		front = 0;
		end = 0;
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}

	
	public void enqueue(T newItem) throws QueueException
	{
		if(numItems == items.length)
		{
			resize();
		}
	
		items[end] = newItem;	
		end = (end + 1)% items.length;
		numItems++;
		
	}

	protected void resize()
	{
		T [] resize = (T[]) new Object[items.length * 2];
		for(int c = 0; c < numItems; c++)
		{
			resize[c] = items[front];
			front = (front + 1) % items.length;
		}
		
		items = resize;
		front = 0;
		end = numItems;
	}
	
	public T dequeue() throws QueueException
	{
		T currFront = items[front];

		if (isEmpty())
		{
			throw new QueueException("Cannot Dequeue");	
		}
		
		items[front] = null;
		front = (front + 1) % items.length;
		numItems--;			
		return currFront;
		
	}

	
	public void dequeueAll()
	{
		items = (T[]) new Object[3];
		front = 0;
		end = 0;
		numItems = 0;
	}

	
	public T peek() throws QueueException
	{
		T topItem = null;
		
		if (numItems > 0)
		{
			topItem = items[front];
		}
		else
		{
			throw new QueueException("Exception on PEEK");
		}
		
		return topItem;
	}
	
	public String toString()
	{
		String s ="";
		int frontN = front;
		for(int c = 0; c < numItems; c++)
		{
				s += items[frontN] + " ";
				frontN = (frontN + 1)%items.length;
		}
		
		return s;
	}
	
}
