package tutogef.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import tutogef.figure.EnterpriseFigure;
import tutogef.model.Enterprise;
import tutogef.model.Node;

public class EnterprisePart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		IFigure figure = new EnterpriseFigure();
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void refreshVisuals() {
		EnterpriseFigure figure = (EnterpriseFigure)getFigure();
		Enterprise model = (Enterprise)getModel();
		
		figure.setName(model.getName());
		figure.setAddress(model.getAddress());
		figure.setCapital(model.getCapital());
	}

	@Override
	public List<Node> getModelChildren() {
		return new ArrayList<Node>();
	}
}
