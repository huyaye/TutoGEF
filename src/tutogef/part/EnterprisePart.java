package tutogef.part;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import tutogef.editpolicies.AppEditLayoutPolicy;
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
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new AppEditLayoutPolicy());
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
	protected List<Node> getModelChildren() {
		return ((Enterprise)getModel()).getChildrenArray();
	}
}
