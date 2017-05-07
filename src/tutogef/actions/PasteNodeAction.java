package tutogef.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

import tutogef.commands.PasteNodeCommand;

public class PasteNodeAction extends SelectionAction {

	public PasteNodeAction(IWorkbenchPart part) {
		super(part);
		setLazyEnablementCalculation(true);
	}

	@Override
	protected void init() {
		super.init();
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setText("Paste");
		setId(ActionFactory.PASTE.getId());

		setHoverImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));

		setEnabled(false);
	}

	private Command createPasteCommand() {
		return new PasteNodeCommand();
	}

	@Override
	protected boolean calculateEnabled() {
		Command cmd = createPasteCommand();
		return cmd.canExecute();
	}

	@Override
	public void run() {
		Command cmd = createPasteCommand();
		if (cmd != null && cmd.canExecute()) {
			execute(cmd);
		}
	}
}
