package tutogef.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;

import tutogef.figure.EmployeFigure;
import tutogef.model.Employe;
import tutogef.model.Node;

public class EmployePart extends AppAbstractEditPart {

	@Override
	protected IFigure createFigure() {
		IFigure figure = new EmployeFigure();
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void refreshVisuals() {
		EmployeFigure figure = (EmployeFigure)getFigure();
		Employe model = (Employe)getModel();
		
		figure.setName(model.getName());
		figure.setFirstName(model.getPrenom());
		figure.setLayout(model.getLayout());
	}
	
	@Override
	protected List<Node> getModelChildren() {
		return new ArrayList<Node>();
	}
}
