package application;

import java.util.ArrayList;

class AVLTreeNode {

	TawjihiRecord record; ////

	private AVLTreeNode leftChild;
	private AVLTreeNode rightChild;
	int height;

	public AVLTreeNode(TawjihiRecord student ) {
		this.record=student;
		this.leftChild = null;
		this.rightChild = null;
		this.height = 0;
	}

	
	public AVLTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(AVLTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public AVLTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(AVLTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}



	@Override
	public String toString() {
		return  record.toString() ;
	}

	
}


 

 public class AvlSeatNumber {
 	AVLTreeNode root;
 	
 	public AVLTreeNode insert(TawjihiRecord student) {
         AVLTreeNode newNode = new AVLTreeNode(student);
         if (root == null) {
             root = newNode;
         } else {
             root = insertRecursive(root, newNode);
         }
         return newNode;
     }
 	
 	private AVLTreeNode insertRecursive(AVLTreeNode current, AVLTreeNode newNode) {
         if (current == null) {
             return newNode;
         }

         int comparison = newNode.record.getSeatNumber() - current.record.getSeatNumber();
         if (comparison < 0) {
             current.setLeftChild(insertRecursive(current.getLeftChild(), newNode));
         } else if (comparison > 0) {
             current.setRightChild(  insertRecursive(current.getRightChild(), newNode));
         }

         return balance(current);
 	}
 	 
 	private AVLTreeNode balance(AVLTreeNode current) {
         int heightDifference = getHeightDifference(current);
         if (heightDifference > 1) {
             if (getHeightDifference(current.getLeftChild()) > 0) {
                 current = rotateRight(current);
             } else {
                 current.setLeftChild( rotateLeft(current.getLeftChild()));
                 current = rotateRight(current);
             }
         } else if (heightDifference < -1) {
             if (getHeightDifference(current.getRightChild()) < 0) {
                 current = rotateLeft(current);
             } else {
                 current.setRightChild(  rotateRight(current.getRightChild()));
                 current = rotateLeft(current);
             }
         }

         return current;
     }

     private AVLTreeNode rotateRight(AVLTreeNode current) {
         AVLTreeNode newRoot = current.getLeftChild();
         current.setLeftChild( newRoot.getRightChild());
         newRoot.setRightChild(current);
         return newRoot;
     }

     private AVLTreeNode rotateLeft(AVLTreeNode current) {
         AVLTreeNode newRoot = current.getRightChild();
         current.setRightChild( newRoot.getLeftChild());
         newRoot.setLeftChild(current);
         return newRoot;
     }

     private int getHeightDifference(AVLTreeNode current) {
         int leftHeight = (current.getLeftChild() == null) ? -1 : current.getLeftChild().height;
         int rightHeight = (current.getRightChild() == null) ? -1 : current.getRightChild().height;
         return leftHeight - rightHeight;
     }

 	private void inorderTraversal(AVLTreeNode head) {
 		if (head != null) {
 			inorderTraversal(head.getLeftChild());
 			System.out.print(head.record.toString() + " ");
 			inorderTraversal(head.getRightChild());
 		}
 	}
 	
 	public void inorderTraversal() {
 		inorderTraversal(root);
 	}
 	
 	private ArrayList<AVLTreeNode> inorderTraversalSt(AVLTreeNode head) {
 		ArrayList<AVLTreeNode> result = new ArrayList<AVLTreeNode>();
 		if (head != null) {
 			result.addAll(inorderTraversalSt(head.getLeftChild()));
 			result.add(head);
 			result.addAll(inorderTraversalSt(head.getRightChild()));
 		}
 		return result;
 	}
 	
 	public ArrayList<AVLTreeNode> inorderTraversalSt() {
 		return inorderTraversalSt(root);
 	}
 	/////

 	
 	
 ///////////////////////////////////////////////////////////////////////////////////////////////////////
 	private int height(AVLTreeNode N) {
         if (N == null)
             return 0;
         return N.height;
     }
 	public int height()
 	{
 		return height(root);
 	}
 	
 	int getBalance(AVLTreeNode N) {
         if (N == null)
             return 0;
         return height(N.getLeftChild()) - height(N.getRightChild());
     }
 	
 	AVLTreeNode minValueNode(AVLTreeNode node) {
 		AVLTreeNode current = node;

 	    while (current.getLeftChild() != null)
 	        current = current.getLeftChild();

 	    return current;
 	}
     ////////////////////////////////////////////////////////////////////
 	private AVLTreeNode deleteNode(AVLTreeNode root, int key) {
 	    if (root == null)
 	        return root;

 	    if (key < root.record.getSeatNumber())
 	        root.setLeftChild( deleteNode(root.getLeftChild(), key));

 	    else if (key > root.record.getSeatNumber())
 	        root.setRightChild( deleteNode(root.getRightChild(), key));

 	    else {
 	        if ((root.getLeftChild() == null) || (root.getRightChild() == null)) {
 	        	AVLTreeNode temp = null;
 	            if (temp == root.getLeftChild())
 	                temp = root.getRightChild();
 	            else
 	                temp = root.getLeftChild();

 	            if (temp == null) {
 	                temp = root;
 	                root = null;
 	            } else
 	                root = temp;

 	        } else {
 	        	AVLTreeNode temp = minValueNode(root.getRightChild());

 	            root.record.setSeatNumber( temp.record.getSeatNumber());
 	            root.setRightChild( deleteNode(root.getRightChild(), temp.record.getSeatNumber()));
 	        }
 	    }

 	    if (root == null)
 	        return root;

 	    root.height = Math.max(height(root.getLeftChild()), height(root.getRightChild())) + 1;

 	    int balance = getBalance(root);

 	    if (balance > 1 && getBalance(root.getLeftChild()) >= 0)
 	        return rotateRight(root);

 	    if (balance > 1 && getBalance(root.getLeftChild()) < 0) {
 	        root.setLeftChild( rotateLeft(root.getLeftChild()));
 	        return rotateRight(root);
 	    }

 	    if (balance < -1 && getBalance(root.getRightChild()) <= 0)
 	        return rotateLeft(root);

 	    if (balance < -1 && getBalance(root.getRightChild()) > 0) {
 	        root.setRightChild( rotateRight(root.getRightChild()));
 	        return rotateLeft(root);
 	    }

 	    return root;
 	}
 	//////////////////////////////////////////////////////////////////	
 	public AVLTreeNode deleteNode(int key)
 	{
 		return deleteNode(root,key);
 	}
 	
 	 private int getHeight(AVLTreeNode current) {
 	        int leftHeight = (current.getLeftChild() == null) ? -1 : current.getLeftChild().height;
 	        int rightHeight = (current.getRightChild() == null) ? -1 : current.getRightChild().height;
 	        System.out.println(leftHeight + " " + rightHeight+ " "+Math.max(leftHeight, rightHeight));
 	        return  Math.max(leftHeight, rightHeight);
 	  }
 	 
 	 private  int depth(AVLTreeNode root) {
 			if (root == null)
 				return -1;

 			return 1 + Math.max(depth(root.getLeftChild()), depth(root.getRightChild()));
 		}
 	 
 	 public  int depth()
 	 {
 		 return depth(root);
 	 }
 	 
 }







