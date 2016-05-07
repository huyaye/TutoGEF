package tutogef.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import tutogef.model.Enterprise;

public class AppEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		AbstractGraphicalEditPart part = null;
		
		if (model instanceof Enterprise) {
			part = new EnterprisePart();
			part.setModel(model);
		}
		
		return part;
	}

}
