package tutogef.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class ServiceFigure extends Figure {
	private Label labelName = new Label();
	private Label labelEtage = new Label();
	
	public ServiceFigure() {
		XYLayout layout = new XYLayout();
		setLayoutManager(layout);
		
		labelName.setForegroundColor(ColorConstants.darkGray);
		add(labelName, ToolbarLayout.ALIGN_CENTER);
		setConstraint(labelName, new Rectangle(5, 17, -1, -1));
		
		labelEtage.setForegroundColor(ColorConstants.black);
		add(labelEtage, ToolbarLayout.ALIGN_CENTER);
		setConstraint(labelEtage, new Rectangle(5, 5, -1, -1));
		
		/** Just for Fun :) **/
		setForegroundColor(new Color(null,
				(new Double(Math.random() * 128)).intValue(),
				(new Double(Math.random() * 128)).intValue(),
				(new Double(Math.random() * 128)).intValue()));
		setBackgroundColor(new Color(null,
				(new Double(Math.random() * 128)).intValue() + 128,
				(new Double(Math.random() * 128)).intValue() + 128,
				(new Double(Math.random() * 128)).intValue() + 128));
		
		setBorder(new LineBorder());
		setOpaque(true);
	}
	
	public void setName(String name) {
		labelName.setText(name);
	}
	
	public void setEtage(int etage) {
		labelEtage.setText("Etage: " + etage);
	}
	
	public void setLayout(Rectangle rect) {
		getParent().setConstraint(this, rect);
	}
}
