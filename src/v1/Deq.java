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
public class Deq<T> extends QueueBasedResizedArray<T> implements ExtendedQueueInterface<T>
{

	public void enqueueFirst(T newItem) throws ExtendedQueueException
	{
		if (numItems == items.length)
		{
			super.resize();
		}
		
		front = (front - 1 + items.length) % items.length;
		items[front] = newItem;
		numItems++;
	}

	public T dequeueLast() throws ExtendedQueueException
	{
		T lastItem = null;
		
		if(isEmpty())
		{
			throw new ExtendedQueueException("Exception on dequeueLast");
		}
		
		lastItem = items[end];
		items[end] = null;
		end = (end - 1 + items.length) % items.length;
		numItems--;
		
		return lastItem;
	}

	public T peekLast() throws ExtendedQueueException
	{
		T lastItem = null;
		int last;
		if(super.isEmpty())
		{
			throw new ExtendedQueueException("Exception on PEEKLAST");
			
		}
		
		last= ((end - 1) + items.length) % items.length;
		lastItem = items[last];
		
		
		return lastItem;
	}
	
}
