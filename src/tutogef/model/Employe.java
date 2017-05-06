package tutogef.model;

public class Employe extends Node {
	public static final String PROPERTY_FIRSTNAME = "EmployePrenom";

	private String prenom;

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getPrenom() {
		return prenom;
	}
}