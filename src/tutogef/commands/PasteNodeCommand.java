package tutogef.commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.Clipboard;

import tutogef.model.Employe;
import tutogef.model.Node;
import tutogef.model.Service;

public class PasteNodeCommand extends Command {
	private HashMap<Node, Node> list = new HashMap<Node, Node>();
	
	@Override
	public boolean canExecute() {
		ArrayList<Node> bList = (ArrayList<Node>)Clipboard.getDefault().getContents();
		if (bList == null || bList.isEmpty()) {
			return false;
		}
		for (Node node : bList) {
			if (isPastableNode(node)) {
				list.put(node, null);
			}
		}
		return true;
	}

	@Override
	public void execute() {
		if (!canExecute()) {
			return;
		}
		for (Node node : list.keySet()) {
			try {
				if (node instanceof Service) {
					Service srv = (Service)node;
					Service clone = (Service)srv.clone();
					list.put(node, clone);
				} else if (node instanceof Employe) {
					Employe emp = (Employe)node;
					Employe clone = (Employe)emp.clone();
					list.put(node, clone);
				}
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		redo();
	}

	@Override
	public void redo() {
		for (Node node : list.values()) {
			if (isPastableNode(node)) {
				node.getParent().addChild(node);
			}
		}
	}

	@Override
	public boolean canUndo() {
		return !(list.isEmpty());
	}

	@Override
	public void undo() {
		for (Node node : list.values()) {
			if (isPastableNode(node)) {
				node.getParent().removeChild(node);
			}
		}
	}

	public boolean isPastableNode(Node node) {
		return (node instanceof Service || node instanceof Employe);
	}
}
