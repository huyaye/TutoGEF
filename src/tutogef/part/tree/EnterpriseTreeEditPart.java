package tutogef.part.tree;

import java.util.List;

import tutogef.model.Enterprise;
import tutogef.model.Node;

public class EnterpriseTreeEditPart extends AppAbstractTreeEditPart {
	@Override
	protected List<Node> getModelChildren() {
		return ((Enterprise)getModel()).getChildrenArray();
	}
}
