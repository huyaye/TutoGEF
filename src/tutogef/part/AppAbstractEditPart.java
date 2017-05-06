package tutogef.part;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import tutogef.model.Enterprise;
import tutogef.model.Node;
import tutogef.model.Service;

public abstract class AppAbstractEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener {
	@Override
	public void activate() {
		super.activate();
		((Node) getModel()).addPropertyChangeListener(this);
	}

	@Override
	public void deactivate() {
		super.deactivate();
		((Node) getModel()).removePropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Node.PROPERTY_LAYOUT) ||
				evt.getPropertyName().equals(Node.PROPERTY_RENAME) ||
				evt.getPropertyName().equals(Service.PROPERTY_COLOR) ||
				evt.getPropertyName().equals(Enterprise.PROPERTY_CAPITAL)) {
			refreshVisuals();
		} else if (evt.getPropertyName().equals(Node.PROPERTY_ADD) ||
				evt.getPropertyName().equals(Node.PROPERTY_REMOVE)) {
			refreshChildren();
		}
	}
	
	/**
	 * To handle the double-click on graphical elements
	 */
	@Override
	public void performRequest(Request req) {
		if (req.getType().equals(RequestConstants.REQ_OPEN)) {
			try {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				page.showView(IPageLayout.ID_PROP_SHEET);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}
}
