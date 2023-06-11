package application;

import java.util.List;

class CircularDoublyLinkedListNode {
	
	TawjihiRecord TawjihiRecord;

	CircularDoublyLinkedListNode next;
	CircularDoublyLinkedListNode prev;

	public CircularDoublyLinkedListNode(TawjihiRecord TawjihiRecord) {
		super();
		this.TawjihiRecord = TawjihiRecord;
		this.next = null;
		this.prev = null;

	}

	@Override
	public String toString() {
		return TawjihiRecord.toString();
	}
	
	

}


 public class CircularDoublyLinkedList {
 	
 	private CircularDoublyLinkedListNode cdll;
 	AVLTreeNode root;
     
 	/////////////////////method to add the node//////////////////////////////////////////////////////
 	public CircularDoublyLinkedListNode addNode(TawjihiRecord TawjihiRecord) {
 		CircularDoublyLinkedListNode newNode = new CircularDoublyLinkedListNode(TawjihiRecord);
 		if (cdll == null) {
 			cdll = newNode;
 			cdll.next = cdll;
 			cdll.prev = cdll;
 		} else {
 			newNode.next = cdll.next;
 			cdll.next = newNode;
 			newNode.prev = cdll;
 			newNode.next.prev = newNode;
 		}
 		return newNode;
 	}

 	
/////////////////////////////////////////method that deletestawsjihi record by the seat number///////////////////////////////////////////////////
 	public void delete(int seatNumber) {
 		CircularDoublyLinkedListNode current = cdll;
 		if (cdll == null)
 			return;

 		if (cdll.TawjihiRecord.getSeatNumber() == seatNumber) {
 			if (cdll == cdll.next) {
 				cdll = null;
 			} else {
 				cdll.prev.next = cdll.next;
 				cdll.next.prev = cdll.prev;
 				cdll = cdll.next;
 			}
 			return;
 		}

 		while (current.next != cdll && current.next.TawjihiRecord.getSeatNumber() != seatNumber) {
 			current = current.next;
 		}

 		if (current.next != cdll) {
 			current.next = current.next.next;
 			current.next.prev = current;
 		}
 	}
/////////////////////////////////////////////////method to delete a tawjihik record by seat number////////////////////////////////////////////////////
 	 public CircularDoublyLinkedListNode search(int seatNumber) {
 	        if (cdll == null) {
 	            return null;
 	        }

 	        CircularDoublyLinkedListNode current = cdll;
 	        do {
 	            if (current.TawjihiRecord.getSeatNumber() == seatNumber) {
 	                return current;
 	            }
 	            current = current.next;
 	        } while (current != cdll);

 	        return null;
 	    }
 	 
 	 public CircularDoublyLinkedListNode searchAvg(double d) {
 	        if (cdll == null) {
 	            return null;
 	        }

 	        CircularDoublyLinkedListNode current = cdll;
 	        do {
 	            if (current.TawjihiRecord.getAvg() == d) {
 	                return current;
 	            }
 	            current = current.next;
 	        } while (current != cdll);

 	        return null;
 	    }
 	 /////////////////////////////////////////print the tawjihi records///////////////////////////////////////////////////
 	public void display() {
 		System.out.println("hi from");
 		CircularDoublyLinkedListNode current = cdll;
 		System.out.print("Circular Doubly Linked List: ");
 		while (current != cdll);
 			System.out.print(current.TawjihiRecord + "\n");
 			current = current.next;
 		
 	}
 	
 	public void printList() {
 		CircularDoublyLinkedListNode temp = cdll;
 	    if (cdll != null) {//if it's not empty 
 	      do {
 	        System.out.print(temp.TawjihiRecord.toString() + "\n");//print the cdll
 	        temp = temp.next;
 	      } while (temp != cdll);
 	    }
 	    else {
 	    	System.out.println("empty!");
 	    }
 	  }
 	
 	public String ListValues() {
 		String result = "";
 		CircularDoublyLinkedListNode temp = cdll;
 		if (cdll != null) {
 		  do {
 		    result += temp.TawjihiRecord.toString() + "\n";
 		    temp = temp.next;
 		  } while (temp != cdll);
 		} else {
 		  result = "empty!";
 		}
 		return result;	
 		}
 	
 	 List<TawjihiRecord> getRecordsForGrade(double grade) {
         List<TawjihiRecord> records = AvlAverage.getRecordsForGrade(grade);
         return records;
     }
 	  
 	
 }
