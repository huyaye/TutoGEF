package tutogef.commands;

import org.eclipse.draw2d.geometry.Rectangle;

import tutogef.model.Service;

public class ServiceChangeLayoutCommand extends AbstractLayoutCommand {
	private Service model;
	private Rectangle layout;
	private Rectangle oldLayout;
	
	@Override
	public void execute() {
		model.setLayout(layout);
	}
	
	@Override
	public void setConstraint(Rectangle rect) {
		this.layout = rect;
	}

	@Override
	public void setModel(Object model) {
		this.model = (Service)model;
		this.oldLayout = this.model.getLayout();
	}
	
	@Override
	public void undo() {
		model.setLayout(oldLayout);
	}
}
