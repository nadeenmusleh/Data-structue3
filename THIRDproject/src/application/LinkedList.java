package application;

 class LinkedListNode {
	
	private TawjihiRecord TawjihiRecord;
	private LinkedListNode next;
	private LinkedListNode prev;
    
	
	public LinkedListNode(TawjihiRecord TawjihiRecord) {
		super();
		this.TawjihiRecord = TawjihiRecord;
		this.next = null;
		this.prev = null;
	}

	public TawjihiRecord getTawjihiRecord() {
		return TawjihiRecord;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	public LinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(LinkedListNode prev) {
		this.prev = prev;
	}

	
}



 public class LinkedList {

 	LinkedListNode head;
 	LinkedListNode tail;

 	public void addNode(TawjihiRecord TawjihiRecord) {
 		LinkedListNode newNode = new LinkedListNode(TawjihiRecord);
 		if (head == null) {
 			head = newNode;
 			tail = newNode;
 			newNode.setNext(head);
 			newNode.setPrev(tail);
 		} else {
 			tail.setNext(newNode);
 			newNode.setPrev(tail);
 			tail = newNode;
 			head.setPrev(tail);
 		}
 	}

 	public void deleteNode(TawjihiRecord TawjihiRecord) {
 		LinkedListNode current = head;
 		while (current != null) {
 			if (current.getTawjihiRecord().getSeatNumber() == TawjihiRecord.getSeatNumber()) {
 				if (current == head) {
 					head = current.getNext();
 					head.setPrev(tail);
 					tail.setNext(head);
 				} else if (current == tail) {
 					tail = current.getPrev();
 					tail.setNext(head);
 					head.setPrev(tail);
 				} else {
 					current.getPrev().setNext(current.getNext());
 					current.getNext().setPrev(current.getPrev());
 				}
 				break;
 			}
 			current = current.getNext();
 			if (current == head) {
 				break;
 			}
 		}
 	}

 	public LinkedListNode searchNode(int seatNumber) {
 		LinkedListNode current = head;
 		while (current != null) {
 			if (current.getTawjihiRecord().getSeatNumber() == seatNumber) {
 				return current;
 			}
 			current = current.getNext();
 			if (current == head) {
 				break;
 			}
 		}
 		return null;
 	}
 	
 	
     public boolean contains(TawjihiRecord TawjihiRecord) {
     	LinkedListNode current = head;
         while (current != null) {
             if (current.getTawjihiRecord().equals(TawjihiRecord))
                 return true;
             current = current.getNext();
         }
         return false;
     }
 	@Override
 	public String toString() {
 		LinkedListNode current = head;
 		String st="";
 		while (current != null) {
 			st+=current.getTawjihiRecord().getSeatNumber()+"," +current.getTawjihiRecord().getBranch()+","+current.getTawjihiRecord().getAvg() +"\n";
 			current = current.getNext();
 			if (current == head) {
 				break;
 			}
 		}
 		return st;
 	}
 	
 	  boolean isEmpty() {
 	        return head == null;
 	    }
 	

 	public void getList(TawjihiRecord TawjihiRecord) {

 	}
 }
