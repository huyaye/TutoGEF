package tutogef.part;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import tutogef.figure.ServiceFigure;
import tutogef.model.Node;
import tutogef.model.Service;

public class ServicePart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		IFigure figure = new ServiceFigure();
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void refreshVisuals() {
		ServiceFigure figure = (ServiceFigure)getFigure();
		Service model = (Service)getModel();
		
		figure.setName(model.getName());
		figure.setEtage(model.getEtage());
		figure.setLayout(model.getLayout());
	}

	@Override
	protected List<Node> getModelChildren() {
		return ((Service)getModel()).getChildrenArray();
	}
}
