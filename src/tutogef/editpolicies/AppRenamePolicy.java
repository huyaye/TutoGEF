package tutogef.editpolicies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

import tutogef.commands.RenameCommand;

public class AppRenamePolicy extends AbstractEditPolicy {

	@Override
	public Command getCommand(Request request) {
		if (request.getType().equals("rename")) {
			return createRenameCommand(request);
		}
		return null;
	}

	private Command createRenameCommand(Request request) {
		RenameCommand command = new RenameCommand();
		command.setModel(getHost().getModel());
		command.setNewName((String)request.getExtendedData().get("newName"));
		return command;
	}
}
