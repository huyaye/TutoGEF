package tutogef.commands;

import org.eclipse.gef.commands.Command;

import tutogef.model.Node;

public class RenameCommand extends Command {
	private Node model;
	private String newName;
	private String oldName;

	@Override
	public void execute() {
		this.oldName = model.getName();
		this.model.setName(newName);
	}

	public void setModel(Object model) {
		this.model = (Node)model;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	@Override
	public void undo() {
		this.model.setName(oldName);
	}
}
