package application;

public class TawjihiRecord {
	private int seatNumber;
	private String branch;
	private double avg;

	public TawjihiRecord(int seatNumber, String branch, double avg) {/////////////constructor/////////////////////
		super();
		this.seatNumber = seatNumber;
		this.branch = branch;
		this.avg = avg;
	}

	public TawjihiRecord() {
		// TODO Auto-generated constructor stub
	}

	public TawjihiRecord(int seatNumber) {
		// TODO Auto-generated constructor stub
	}
////////////////////////////setters and getters//////////////////////////////////
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Student [seatNumber=" + seatNumber + ", branch=" + branch + ", avg=" + avg + "]"+"\n";
	}
	
	

}
