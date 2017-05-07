package tutogef.model;

import org.eclipse.draw2d.geometry.Rectangle;

public class Employe extends Node {
	public static final String PROPERTY_FIRSTNAME = "EmployePrenom";

	private String prenom;

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Employe employe = new Employe();
		employe.setName(this.getName());
		employe.setParent(this.getParent());
		employe.setPrenom(this.prenom);
		employe.setLayout(new Rectangle(getLayout().x + 10, getLayout().y + 10,
				getLayout().width, getLayout().height));

		return employe;
	}
}