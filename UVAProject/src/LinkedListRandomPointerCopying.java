

class LLNode
{
	private int data;
	private LLNode next;
	private LLNode random;
	
	public LLNode()
	{
		
	}
	
	public LLNode(int n)
	{
		this.data = n;
	}
	
	public LLNode getRandom() {
		return random;
	}
	public void setRandom(LLNode random) {
		this.random = random;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LLNode getNext() {
		return next;
	}
	public void setNext(LLNode next) {
		this.next = next;
	}
	
	
}


class LinkedList
{
	LLNode head;
	
	public LinkedList()
	{
		head = new LLNode();
		head.setData(-1);
	}
	
	public LinkedList(int n)
	{
		head = new LLNode();
		head.setData(n);
	}
	
	public LinkedList(LLNode head)
	{
		this.head = head;
	}
	
	
	public void add(int n)
	{
		LLNode newHead = new LLNode();
		newHead.setData(n);
		newHead.setNext(head);
		this.head = newHead;
		
	}
	
	public void printList()
	{
		LLNode current = head;
		while(true)
			{
			System.out.print(current.getData()+" ");
			if(current.getNext()!=null)
			current = current.getNext();
			else
				break;
			}
		
	}
	
}


public class LinkedListRandomPointerCopying {

	
	public static void main(String[] args)
	{
		
		LLNode l1 = new LLNode(1);
		LLNode l2 = new LLNode(2);
		LLNode l3 = new LLNode(3);
		LLNode l4 = new LLNode(4);
		LLNode l5 = new LLNode(5);
		
		l1.setNext(l2);
		l2.setNext(l3);
		l3.setNext(l4);
		l4.setNext(l5);
		
		l1.setRandom(l3);
		l5.setRandom(l1);
		l4.setRandom(l2);
		l2.setRandom(l5);
		l3.setRandom(l5);
		
		
		LinkedList mylist = new LinkedList(l1);
		solution(mylist.head);
		
		
	}
	
	
	public static void solution(LLNode head)
	{
		LLNode temp1 =head;
		LLNode temp =null;
		while(head.getNext()!=null)
		{
			temp = new LLNode();
			
			temp.setData(head.getData());
			temp.setNext(head.getNext());
			temp.setRandom(head.getRandom());
			
			head.setNext(temp);
			
			//head = temp.getNext();
			
		}
		
		while(temp1!=null)
		{
			System.out.print(temp.getData()+"-->");
		}
		
		
	}
	
}
