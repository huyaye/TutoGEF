package tutogef.model;

import org.eclipse.gef.requests.CreationFactory;

public class NodeCreationFactory implements CreationFactory {
	private Class<?> template;

	public NodeCreationFactory(Class<?> t) {
		this.template = t;
	}

	@Override
	public Object getNewObject() {
		if (template == null) {
			return null;
		} else if (template == Service.class) {
			Service srv = new Service();
			srv.setEtage(42);
			srv.setName("Hello~");
			return srv;
		} else if (template == Employe.class) {
			Employe emp = new Employe();
			emp.setPrenom("Jungwook");
			emp.setName("Ryu");
			return emp;
		}
		return null;
	}

	@Override
	public Object getObjectType() {
		return template;
	}

}
