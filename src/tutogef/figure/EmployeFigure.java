package tutogef.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class EmployeFigure extends Figure {
	private Label labelName = new Label();
	private Label labelFirstName = new Label();

	public EmployeFigure() {
		ToolbarLayout layout = new ToolbarLayout();
		setLayoutManager(layout);

		labelFirstName.setForegroundColor(ColorConstants.black);
		add(labelFirstName, ToolbarLayout.ALIGN_CENTER);

		labelName.setForegroundColor(ColorConstants.darkGray);
		add(labelName, ToolbarLayout.ALIGN_CENTER);

		setForegroundColor(ColorConstants.darkGray);
		setBackgroundColor(ColorConstants.lightGray);

		setBorder(new LineBorder());
		setOpaque(true);
	}

	public void setName(String name) {
		labelName.setText(name);
	}

	public void setFirstName(String firstName) {
		labelFirstName.setText(firstName);
	}

	public void setLayout(Rectangle rect) {
		getParent().setConstraint(this, rect);
	}
}
