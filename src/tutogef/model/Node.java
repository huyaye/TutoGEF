package tutogef.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;

public class Node {
	public static final String PROPERTY_LAYOUT = "NodeLayout";

	private String name;
	private Rectangle layout;
	private List<Node> children;
	private Node parent;
	private PropertyChangeSupport listeners;
	
	public Node() {
		this.name = "Unknown";
		this.layout = new Rectangle(10, 10, 100, 100);
		this.children = new ArrayList<Node>();
		this.parent = null;
		this.listeners = new PropertyChangeSupport(this);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName()  {
		return name;
	}
	
	public void setLayout(Rectangle newLayout) {
		Rectangle oldLayout = this.layout;
		this.layout = newLayout;
		getListeners().firePropertyChange(PROPERTY_LAYOUT, oldLayout, newLayout);
	}
	
	public Rectangle getLayout() {
		return layout;
	}
	
	public void addChild(Node child) {
		child.setParent(this);
		children.add(child);
	}
	
	public void removeChild(Node child) {
		children.remove(child);
	}
	
	public List<Node> getChildrenArray() {
		return children;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);
	}
	
	public PropertyChangeSupport getListeners() {
		return listeners;
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}
}
