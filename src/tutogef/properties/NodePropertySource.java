package tutogef.properties;

import java.util.ArrayList;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.views.properties.ColorPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import tutogef.model.Employe;
import tutogef.model.Enterprise;
import tutogef.model.Node;
import tutogef.model.Service;

public class NodePropertySource implements IPropertySource {
	private Node node;
	
	public NodePropertySource(Node node) {
		this.node = node;
	}

	/**
	 * Returns the property value when this property source is used as a value.
	 * We can return null here.
	 */
	@Override
	public Object getEditableValue() {
		return null;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		ArrayList<IPropertyDescriptor> properties = new ArrayList<IPropertyDescriptor>();
		if (node instanceof Employe) {
			properties.add(new PropertyDescriptor(Node.PROPERTY_RENAME, "Name"));
		} else {
			properties.add(new TextPropertyDescriptor(Node.PROPERTY_RENAME, "Name"));
		}
		if (node instanceof Service) {
			properties.add(new ColorPropertyDescriptor(Service.PROPERTY_COLOR, "Color"));
			properties.add(new TextPropertyDescriptor(Service.PROPERTY_FLOOR, "Etage"));
		} else if (node instanceof Enterprise) {
			properties.add(new TextPropertyDescriptor(Enterprise.PROPERTY_CAPITAL, "Capital"));
		} else if (node instanceof Employe) {
			properties.add(new PropertyDescriptor(Employe.PROPERTY_FIRSTNAME, "Prenom"));
		}
		return properties.toArray(new IPropertyDescriptor[0]);
	}

	@Override
	public Object getPropertyValue(Object id) {
		if (id.equals(Node.PROPERTY_RENAME)) {
			return node.getName();
		}
		if (id.equals(Service.PROPERTY_COLOR)) {
			return ((Service)node).getColor().getRGB();
		}
		if (id.equals(Service.PROPERTY_FLOOR)) {
			return Integer.toString(((Service)node).getEtage());
		}
		if (id.equals(Enterprise.PROPERTY_CAPITAL)) {
			return Integer.toString(((Enterprise)node).getCapital());
		}
		if (id.equals(Employe.PROPERTY_FIRSTNAME)) {
			return ((Employe)node).getPrenom();
		}
		return null;
	}

	/**
	 * Returns if the property with the given id has been changed since its initial default value.
	 * We do not handle default properties, so we return false.
	 */
	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	/**
	 * Reset a property to its default value. Since we do not handle default properties, we do nothing.
	 */
	@Override
	public void resetPropertyValue(Object id) {
	}

	/**
	 * Recording of a property value after the user edited it.
	 */
	@Override
	public void setPropertyValue(Object id, Object value) {
		if (id.equals(Node.PROPERTY_RENAME)) {
			node.setName((String)value);
		} else if (id.equals(Service.PROPERTY_COLOR)) {
			((Service)node).setColor(new Color(null, (RGB)value));
		} else if (id.equals(Service.PROPERTY_FLOOR)) {
			try {
				((Service)node).setEtage(Integer.parseInt((String)value));
			} catch (NumberFormatException e) {}
		} else if (id.equals(Enterprise.PROPERTY_CAPITAL)) {
			try {
				((Enterprise)node).setCapital(Integer.parseInt((String)value));
			} catch (NumberFormatException e) {}
		}
	}

}
