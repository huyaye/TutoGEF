package tutogef.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import tutogef.model.Enterprise;
import tutogef.model.Service;

public class ServiceCreateCommand extends Command {
	private Enterprise enterprise;
	private Service service;

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	
	public void setLayout(Rectangle r) {
		if (service != null) {
			service.setLayout(r);
		}
	}

	@Override
	public boolean canExecute() {
		if (service == null || enterprise == null) {
			return false;
		}
		return true;
	}

	@Override
	public void execute() {
		enterprise.addChild(service);
	}

	@Override
	public boolean canUndo() {
		if (service == null || enterprise == null) {
			return false;
		}
		return enterprise.contains(service);
	}

	@Override
	public void undo() {
		enterprise.removeChild(service);
	}
}
