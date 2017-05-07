package tutogef;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.requests.CreationFactory;

import tutogef.model.NodeCreationFactory;

public class MyTemplateTransferDropTargetListener extends TemplateTransferDropTargetListener {
	public MyTemplateTransferDropTargetListener(EditPartViewer viewer) {
		super(viewer);
	}

	@Override
	protected CreationFactory getFactory(Object template) {
		if (template instanceof NodeCreationFactory) {
			return (NodeCreationFactory)template;
		}
		return new NodeCreationFactory((Class<?>)template);
	}
}
