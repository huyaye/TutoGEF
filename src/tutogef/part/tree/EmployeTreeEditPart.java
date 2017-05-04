package tutogef.part.tree;

import java.util.List;

import org.eclipse.gef.EditPolicy;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import tutogef.editpolicies.AppDeletePolicy;
import tutogef.model.Employe;
import tutogef.model.Node;

public class EmployeTreeEditPart extends AppAbstractTreeEditPart {
	@Override
	protected List<Node> getModelChildren() {
		return ((Employe)getModel()).getChildrenArray();
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AppDeletePolicy());
	}
	
	@Override
	public void refreshVisuals() {
		Employe model = (Employe)getModel();
		this.setWidgetText(model.getName() + " " + model.getPrenom());
		this.setWidgetImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEF_VIEW));
	}
}
