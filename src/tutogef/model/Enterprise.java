package tutogef.model;

public class Enterprise extends Node {
	private String address;
	private int capital;
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCapital(int capital) {
		this.capital = capital;
	}

	public String getAddress() {
		return address;
	}

	public int getCapital() {
		return capital;
	}
}
