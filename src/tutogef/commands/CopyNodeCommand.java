package tutogef.commands;

import java.util.ArrayList;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.Clipboard;

import tutogef.model.Employe;
import tutogef.model.Node;
import tutogef.model.Service;

public class CopyNodeCommand extends Command {
	private ArrayList<Node> list = new ArrayList<Node>();

	public boolean addElement(Node node) {
		if (!list.contains(node)) {
			return list.add(node);
		}
		return false;
	}

	@Override
	public boolean canExecute() {
		if (list.isEmpty()) {
			return false;
		}
		for (Node node : list) {
			if (!isCopyableNode(node)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void execute() {
		if (canExecute()) {
			Clipboard.getDefault().setContents(list);
		}
	}

	@Override
	public boolean canUndo() {
		return false;
	}

	public boolean isCopyableNode(Node node) {
		return (node instanceof Service || node instanceof Employe);
	}
}
