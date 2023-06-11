package application;

import java.util.ArrayList;
import java.util.List;

class AvlAvgNode {
	
	private double avgData ;
	private LinkedList listTawjihiRecord = new LinkedList () ;
	int height;
	public AvlAvgNode(TawjihiRecord TawjihiRecord) {
		// TODO Auto-generated constructor stub
		this.avgData=TawjihiRecord.getAvg();
		listTawjihiRecord.addNode(TawjihiRecord);
		height=0;
	} 
	
	private AvlAvgNode left , right ;
//////////////GETTERS AND SETTERS//////////////
	public double getAvgData() {
		return avgData;
	}

	public void setAvgData(double d) {
		this.avgData = d;
	}

	public LinkedList getListTawjihiRecord() {
		return listTawjihiRecord;
	}

	public void setListTawjihiRecord(LinkedList listTawjihiRecord) {
		this.listTawjihiRecord = listTawjihiRecord;
	}

	public AvlAvgNode getLeft() {
		return left;
	}

	public void setLeft(AvlAvgNode left) {
		this.left = left;
	}

	public AvlAvgNode getRight() {
		return right;
	}

	public void setRight(AvlAvgNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return  listTawjihiRecord.toString()	;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	

}


 public class AvlAverage {

 	static AvlAvgNode root;
 	////////INSERT METHOD TO INSERT THE DATA SORTED BY AVERAGE//////////
 	public AvlAvgNode insert(TawjihiRecord TawjihiRecord) {
 		AvlAvgNode newNode = new AvlAvgNode(TawjihiRecord);
         if (root == null) {
             root = newNode;
         } else {
             root = insertRecursive(root, newNode,TawjihiRecord);
         }
         return newNode;
     }
 	
 	private AvlAvgNode insertRecursive(AvlAvgNode current, AvlAvgNode newNode,TawjihiRecord TawjihiRecord) {
         if (current == null) {
         	
             return newNode;
         }

         double comparison = (newNode.getAvgData() - current.getAvgData());
         if (comparison == 0.0) {
         	   
         	current.getListTawjihiRecord().addNode(TawjihiRecord);
         	
         }
         else {
         	
         
         if (comparison < 0.0) {
             current.setLeft(insertRecursive(current.getLeft(), newNode ,TawjihiRecord));
         } else if (comparison > 0.0) {
             current.setRight( insertRecursive(current.getRight(), newNode,TawjihiRecord));
         }
      
         	
         }

         return balance(current);
 	}
 	 //////////////////////////////////////METHOD TO TELL YOU IF TNE TREE IS BALANCED OR NOT//////////////////////////////////////
 	private AvlAvgNode balance(AvlAvgNode current) {
         int heightDifference = getHeightDifference(current);
         if (heightDifference > 1) {
             if (getHeightDifference(current.getLeft()) > 0) {
                 current = rotateRight(current);
             } else {
                 current.setLeft( rotateLeft(current.getLeft()));
                 current = rotateRight(current);
             }
         } else if (heightDifference < -1) {
             if (getHeightDifference(current.getRight()) < 0) {
                 current = rotateLeft(current);
             } else {
                 current.setRight(  rotateRight(current.getRight()));
                 current = rotateLeft(current);
             }
         }

         return current;
     }
////////////////////////////////IF IT IS NOT BALANCED WE NEED ROTATE METHODS////////////////////////////////////////////////////////////////////////
     private AvlAvgNode rotateRight(AvlAvgNode current) {
     	AvlAvgNode newRoot = current.getLeft();
         current.setLeft( newRoot.getRight());
         newRoot.setRight(current);
         return newRoot;
     }

     private AvlAvgNode rotateLeft(AvlAvgNode current) {
     	AvlAvgNode newRoot = current.getRight();
         current.setRight(newRoot.getLeft());
         newRoot.setLeft(current);
         return newRoot;
     }
/////////////////////////////////A METHOD TO GET THE HEIGHT DIFFERENCE/////////////////////////////////////////////////////////////
     private int getHeightDifference(AvlAvgNode current) {
         int leftHeight = (current.getLeft() == null) ? -1 : current.getLeft().height;
         int rightHeight = (current.getRight() == null) ? -1 : current.getRight().height;
         return leftHeight - rightHeight;
     }

 	private void inorderTraversal(AvlAvgNode head) {
 		if (head != null) {
 			inorderTraversal(head.getLeft());
 			System.out.println(head.toString() + " ");
 			inorderTraversal(head.getRight());
 		}
 	}
 	
 	public void inorderTraversal() {
 		inorderTraversal(root);
 	}
 	
 	private ArrayList<AvlAvgNode> inorderTraversalSt(AvlAvgNode head) {
 		ArrayList<AvlAvgNode> result = new ArrayList<AvlAvgNode>();
 		if (head != null) {
 			result.addAll(inorderTraversalSt(head.getLeft()));
 			result.add(head);
 			result.addAll(inorderTraversalSt(head.getRight()));
 		}
 		return result;
 	}
 	
 	public ArrayList<AvlAvgNode> inorderTraversalSt() {
 		return inorderTraversalSt(root);
 	}
 	//////////////////////////////////////////////////////////////

 	
 	private int height(AvlAvgNode N) {
         if (N == null)
             return 0;
         return N.height;
     }
 	public int height()
 	{
 		return height(root);
 	}
 	
 	
 	///////////////////////////
 	int getBalance(AvlAvgNode N) {
         if (N == null)
             return 0;
         return height(N.getLeft()) - height(N.getRight());
     }
 	
 	AvlAvgNode minValueNode(AvlAvgNode node) {
 		AvlAvgNode current = node;

 	    while (current.getLeft() != null)
 	        current = current.getLeft();

 	    return current;
 	}

 	public void delete(double avg) {
 		root = delete(root, avg);
 	}

 	AvlAvgNode delete(AvlAvgNode root, double avg) {
 	    if (root == null)
 	        return root;

 	    if (avg < root.getAvgData())
 	        root.setLeft( delete(root.getLeft(), avg));

 	    else if (avg > root.getAvgData())
 	        root.setRight( delete(root.getRight(), avg));

 	    else {
 	        if ((root.getLeft() == null) || (root.getRight() == null)) {
 	        	AvlAvgNode temp = null;
 	            if (temp == root.getLeft())
 	                temp = root.getRight();
 	            else
 	                temp = root.getLeft();

 	            if (temp == null) {
 	                temp = root;
 	                root = null;
 	            } else
 	                root = temp;

 	        } else {
 	        	AvlAvgNode temp = minValueNode(root.getRight());

 	            root.setAvgData( temp.getAvgData());
 	            root.setRight(delete(root.getRight(), temp.getAvgData()));
 	        }
 	    }

 	    if (root == null)
 	        return root;

 	    root.height = Math.max(height(root.getLeft()), height(root.getRight())) + 1;

 	    int balance = getBalance(root);

 	    if (balance > 1 && getBalance(root.getLeft()) >= 0)
 	        return rotateRight(root);

 	    if (balance > 1 && getBalance(root.getLeft()) < 0) {
 	        root.setLeft( rotateLeft(root.getLeft()));
 	        return rotateRight(root);
 	    }

 	    if (balance < -1 && getBalance(root.getRight()) <= 0)
 	        return rotateLeft(root);

 	    if (balance < -1 && getBalance(root.getRight()) > 0) {
 	        root.setRight( rotateRight(root.getRight()));
 	        return rotateLeft(root);
 	    }

 	    return root;
 	}
 	
 	public  AvlAvgNode search(double x) {
 		return search(x, root);
 	}

 	private  AvlAvgNode search(double x, AvlAvgNode node) {
 		while (node != null) {
 			if (x < node.getAvgData())
 				node = node.getLeft();
 			else if (x > node.getAvgData()) {
 				node = node.getRight();
 			} else
 				return node;
 		}
 		return null;
 	}
 	
 	
 		 private int getHeight(AvlAvgNode current) {
 		        int leftHeight = (current.getLeft() == null) ? -1 : current.getLeft().height;
 		        int rightHeight = (current.getRight() == null) ? -1 : current.getRight().height;
 		        return  Math.max(leftHeight, rightHeight);
 		  }
 		public int getHeight()
 		{
 			return getHeight(root);
 		}
 		
 		 private  int depth(AvlAvgNode root) {
 				if (root == null)
 					return -1;
 				return 1 + Math.max(depth(root.getLeft()), depth(root.getRight()));
 			}
 		 
 		 public  int depth()
 		 {
 			 return depth(root);
 		 }
 		static List<TawjihiRecord> getRecordsForGrade(double grade) {
 		    List<TawjihiRecord> records = AvlAverage.getRecordsForGrade(grade);
 		    return records;
 		}
 }