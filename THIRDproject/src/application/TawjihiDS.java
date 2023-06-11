package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TawjihiDS {

	private CircularDoublyLinkedList listLit;
	private CircularDoublyLinkedList listSC;

	private AvlSeatNumber seatNumberTreeLit;
	private AvlSeatNumber seatNumberTreeSC;

	private AvlAverage averageTreeLit;
	private AvlAverage averageTreeSC;


	public TawjihiDS() {
		listLit = new CircularDoublyLinkedList();
		listSC = new CircularDoublyLinkedList();

		seatNumberTreeLit = new AvlSeatNumber();
		seatNumberTreeSC = new AvlSeatNumber();

		averageTreeLit = new AvlAverage();
		averageTreeSC = new AvlAverage();

	}

	public  void readFromFileLit(String fileName) {
	    try {
	      File file = new File(fileName);
	      Scanner scanner = new Scanner(file);
	      
	      while (scanner.hasNextLine()) {
	        String line = scanner.nextLine();
			line = line.replace("	", ",");

			String[] data = line.split(",");
			int seatNumber = Integer.parseInt(data[0].trim());
			String branch = data[1].trim();
			double average = Double.parseDouble(data[2].trim());
			//System.out.println(data[1]);
			if (data[1].trim().compareToIgnoreCase("Literary")==0) {
			TawjihiRecord TawjihiRecord = new TawjihiRecord(seatNumber, branch, average);
			addRecordLit(TawjihiRecord);
			//System.out.println(TawjihiRecord.toString());
			}
	        // System.out.println(seatNumber+branch+average);
	      }
	      scanner.close();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } 
	}
	
   //////////////////////////////////////////////////////////////////////////////////////
	public CircularDoublyLinkedListNode searchBySeatNumberLit(int seatNumber) {
		return listLit.search(seatNumber);
	}
	
	public boolean isExistLit(int seatNumber)
	{
		if (listLit.search(seatNumber)==null)
		{
			 return false;
		}
		 return true;
		
	}
	
	public CircularDoublyLinkedListNode getPrevLit(int seatNumber) {
		return listLit.search(seatNumber).prev;
	}
	
	public CircularDoublyLinkedListNode getNextLit(int seatNumber) {
		return listLit.search(seatNumber).next;
	}
	
	public LinkedList getAllLit(double d)
	{		
		AvlAvgNode node =averageTreeLit.search(d) ; 
		if (node != null) {
			return node.getListTawjihiRecord();
		}
		return null ;
	}

	public void addRecordLit(TawjihiRecord record) {
		
		listLit.addNode(record);
		seatNumberTreeLit.insert(record);
		averageTreeLit.insert(record);//
		
	  }

	public void updateLit(int seatNumber,String newBranch , float avg) {
		CircularDoublyLinkedListNode node=  listLit.search(seatNumber);
		    if (node != null) {
		    	node.TawjihiRecord.setAvg(avg);
		    	node.TawjihiRecord.setBranch(newBranch);	    			    	
		} else {
			System.out.println("No TawjihiRecord record found with seat number: " +seatNumber);
		}
	}
	
	public String printListLit()
	{
		return listLit.ListValues();
	}
	
	public void removeRecordLit(int seatNumber)
	{
		listLit.delete(seatNumber);
		seatNumberTreeLit.deleteNode(seatNumber);
		
	}
	
	public void removeRecordSC(int seatNumber)
	{
		listSC.delete(seatNumber);
		seatNumberTreeSC.deleteNode(seatNumber);
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	public  void readFromFileSC(String fileName) {
	    try {
	      File file = new File(fileName);
	      Scanner scanner = new Scanner(file);
	      
	      while (scanner.hasNextLine()) {
	        String line = scanner.nextLine();
			line = line.replace("	", ",");

			String[] data = line.split(",");
			int seatNumber = Integer.parseInt(data[0].trim());
			String branch = data[1].trim();
			double average = Double.parseDouble(data[2].trim());
			//System.out.println(data[1]);
			if (data[1].trim().compareToIgnoreCase("Scientific")==0) {
			TawjihiRecord TawjihiRecord = new TawjihiRecord(seatNumber, branch, average);
			addRecordSC(TawjihiRecord);
			}
	      }
	      scanner.close();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } 
	}
	//////////////////////////////////////////////////////////////////
	public CircularDoublyLinkedListNode searchBySeatNumberSC(int seatNumber) {
		return listSC.search(seatNumber);
	}
	
	public boolean isExistSC(int seatNumber)
	{
		if (listSC.search(seatNumber)==null)
		{
			 return false;
		}
		else
		 return true;
		
	}
	
	public LinkedList getAllSC(double d)
	{
		
		AvlAvgNode node =averageTreeSC.search(d) ; 
		if (node != null) {
			return node.getListTawjihiRecord();

		}
		return null ;
	
	}

	public void addRecordSC(TawjihiRecord record) {
		
		listSC.addNode(record);
	    seatNumberTreeSC.insert(record);
	    averageTreeSC.insert(record);//
		
	  }

	public void updateSC(int seatNumber,String newBranch , float avg) {
		CircularDoublyLinkedListNode node=  listLit.search(seatNumber);
		    if (node != null) {
		    	node.TawjihiRecord.setAvg(avg);
		    	node.TawjihiRecord.setBranch(newBranch);	    			    	
		} else {
			System.out.println("No TawjihiRecord record found with seat number: " +seatNumber);
		}
	}
	
	public String printListSC()
	{
		return listSC.ListValues();
	}
	
    	public CircularDoublyLinkedListNode getPrevSC(int seatNumber) {
		return listSC.search(seatNumber).prev;
	}
	
	public CircularDoublyLinkedListNode getNextSC(int seatNumber) {
		return listSC.search(seatNumber).next;
	}
	////////////////////////////////////////////////////////////////////////////////////
	public void printAVL_OneLit () {
		System.out.println("avl1");
		seatNumberTreeLit.inorderTraversal();
	}
	
	public String printAVL_OneLitSTLit() {
		System.out.println("avl1");
		return seatNumberTreeLit.inorderTraversalSt().toString();
	}
	
	public String printAVL_OneLitSTSC() {
		System.out.println("avl1");
		return seatNumberTreeSC.inorderTraversalSt().toString();
	}
	public void printAVL_OneSC() {
		System.out.println("avl1");
		seatNumberTreeSC.inorderTraversal();
	}
	
	
	public String printAVL_TwoLit() {
		return averageTreeLit.inorderTraversalSt().toString();
	}
	public String printAVL_TwoSC() {
		 return averageTreeSC.inorderTraversalSt().toString();
	}
   ///////////////////////////////////////////////////////////////////////////////////////
	public int getHeightSeatLit()
	{
		return seatNumberTreeLit.height();
	}
	public int getHeightAvgLit()
	{
		return averageTreeLit.height();
	}
	
	public int getHeightSeatSC()
	{
		return seatNumberTreeSC.height();
	}
	
	public int getHeightAvgSC()
	{
		return averageTreeLit.height();
	}
	 public List<TawjihiRecord> getAlllit(int grade) {
		return listLit.getRecordsForGrade(grade);
}
	 public List<TawjihiRecord> getAllsc(int grade) {
			return listSC.getRecordsForGrade(grade);
	}
	 
}
