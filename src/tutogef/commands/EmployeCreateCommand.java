package tutogef.commands;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import tutogef.model.Employe;
import tutogef.model.Service;

public class EmployeCreateCommand extends Command {
	private Service service;
	private Employe employe;
	
	public void setService(Service service) {
		this.service = service;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public void setLayout(Rectangle r) {
		if (employe != null) {
			employe.setLayout(r);
		}
	}

	@Override
	public boolean canExecute() {
		if (service == null || employe == null) {
			return false;
		}
		return true;
	}

	@Override
	public void execute() {
		service.addChild(employe);
	}

	@Override
	public boolean canUndo() {
		if (service == null || employe == null) {
			return false;
		}
		return service.contains(employe);
	}

	@Override
	public void undo() {
		service.removeChild(employe);
	}
}
