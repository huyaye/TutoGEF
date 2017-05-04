package tutogef.commands;

import org.eclipse.gef.commands.Command;

import tutogef.model.Node;

public class DeleteCommand extends Command {
	private Node model;
	private Node parentModel;
	
	@Override
	public void execute() {
		parentModel.removeChild(model);
	}
	
	public void setModel(Object model) {
		this.model = (Node)model;
	}
	
	public void setParentModel(Object model) {
		this.parentModel = (Node)model;
	}
	
	@Override
	public void undo() {
		parentModel.addChild(model);
	}
}
