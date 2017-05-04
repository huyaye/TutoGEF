package tutogef.part.tree;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.gef.editparts.AbstractTreeEditPart;

import tutogef.model.Node;

public abstract class AppAbstractTreeEditPart extends AbstractTreeEditPart implements PropertyChangeListener {
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
		if (evt.getPropertyName().equals(Node.PROPERTY_ADD) ||
				evt.getPropertyName().equals(Node.PROPERTY_REMOVE)) {
			refreshChildren();
		}
	}
}
