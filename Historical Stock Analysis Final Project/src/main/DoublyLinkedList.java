package main;

public class DoublyLinkedList 
{
	private Link first;
	private Link last;
	
	public DoublyLinkedList()
	{
		first=null;
		last=null;
	}
	
	public boolean inserAfter(Stock key,Stock dData)
	{
		Link current=first;
		while(!current.stock.date.equals(key.date))
		{
			current=current.next;
			if(current.equals(null))
				return false;
		}
	Link newLink=new Link(dData);
	
		if(current.equals(last))
		{
			newLink.next=null;
		last=newLink;
		}
		else 
		{
			newLink.next=current.next;
			current.next.previous=newLink;
		}
	newLink.previous=current;
	current.next=newLink;
	return true;
		
	}

	public void insertLast(Stock dData)
	{
		Link newlink=new Link(dData);
		
		if(isEmpty())
		{
			first=newlink;
		}else {
		last.next=newlink;
		newlink.previous=last;
		}
		last=newlink;
		

	}
	
	public Link Deletelast()
	{
		Link temp=last;
		if(first.next==null)
		{
			first=null;
		}
		
		last.previous.next=null;
		last=last.previous;

		return temp;
	}
	
	public Link DeleteFirst()
	{
		Link temp=first;
		if(first.next==null)
		{
			last=null;
		}
		
		first.next.previous=null;
		
		first=first.next;
		
		return temp;
	}

	public void insertFirst(Stock dData)
	{
		Link newlink=new Link(dData);
		
		if(isEmpty())
		{
			last=newlink;
		}
		else
		{
		first.previous=newlink;
		}
		newlink.next=first;
		first=newlink;
		
		
	}
	
	public boolean insertBefore(Stock key,Stock dData)
	{
		Link current=first;
		while(current.stock.date!=key.date)
		{
			current=current.next;
			if(current==null)
				return false;
		}
		
		Link newLink=new Link(dData);
		if(current==first)
		{
			newLink.next=first;
			first.previous=newLink;
			first=newLink;
			
		}else
		{
			newLink.next=current;
			current.previous.next=newLink;
			newLink.previous=current.previous;
			current.previous=newLink;
		}
		
		return true;
		
		
		
		
	}
	
//	
//	public Link deleteKey(long key)
//	{
//		Link current=first;
//		while(current.dData!=key)
//		{
//			current=current.next;
//		}
//		
//		if(current==first)
//		{
//			first= current.next;
//		}
//		else
//		{
//			current.previous.next=current.next;
//		}
//		
//		if(current==last)
//		{
//			last=current.previous;
//		}
//		else 
//		{
//			current.next.previous=current.previous;
//		}
//		
//		return current;
//		
//	}
//	
	public Link Find(Stock key)
	{
	
		Link current=first;
		while(!current.stock.date.equals(key.date))
		{
			
			current=current.next;
			if (current.equals(null))
				return null;
			
		}
		return current;
		
	}
	
	
	
	public void displayForward()
	{
		System.out.println("list(first-->last)");
		Link current=first;
		while(current!=null)
		{
			current.displayLink();
			current=current.next;
		}
		System.out.println();
		
	}
	
	
	
	
	
	
	public void displaybackward()
	{
		System.out.println("list(last-->first)");
		Link current=last;
		while(current!=null)
		{
			current.displayLink();
			current=current.previous;
		}
		System.out.println();
	}

	public boolean isEmpty()
	{
		return first==null;
	}
	
	

}