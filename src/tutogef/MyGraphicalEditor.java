package tutogef;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import tutogef.model.Employe;
import tutogef.model.Enterprise;
import tutogef.model.Service;
import tutogef.part.AppEditPartFactory;
import tutogef.part.tree.AppTreeEditPartFactory;

public class MyGraphicalEditor extends GraphicalEditor {
	public static final String ID = "tutogef.mygraphicaleditor";
	
	private Enterprise model;
	private KeyHandler keyHandler;
	
	public MyGraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override
	protected void initializeGraphicalViewer() {
		GraphicalViewer viewer = getGraphicalViewer();
		model = createEnterprise();
		viewer.setContents(model);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new AppEditPartFactory());
		
		/*
		 * Zoom
		 */
		ScalableRootEditPart rootEditPart = new ScalableRootEditPart();
		viewer.setRootEditPart(rootEditPart);
		
		ZoomManager manager = rootEditPart.getZoomManager();
		getActionRegistry().registerAction(new ZoomInAction(manager));
		getActionRegistry().registerAction(new ZoomOutAction(manager));
		
		// 1 = 100%
		double[] zoomLevels = new double[] {0.25, 0.5, 0.75, 1.0, 1.5, 2.0, 2.5, 3.0, 4.0, 5.0, 10.0, 20.0};
		manager.setZoomLevels(zoomLevels);
		
		List<String> zoomContributions = new ArrayList<String>();
		zoomContributions.add(ZoomManager.FIT_ALL);
		zoomContributions.add(ZoomManager.FIT_HEIGHT);
		zoomContributions.add(ZoomManager.FIT_WIDTH);
		manager.setZoomLevelContributions(zoomContributions);
		
		/*
		 * Shortcut
		 */
		keyHandler = new KeyHandler();
		keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0), getActionRegistry().getAction(ActionFactory.DELETE.getId()));
		
		viewer.setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.NONE), MouseWheelZoomHandler.SINGLETON);
		viewer.setKeyHandler(keyHandler);
	}

	@Override
	public Object getAdapter(Class type) {
		if (type == ZoomManager.class) {
			return ((ScalableRootEditPart)getGraphicalViewer().getRootEditPart()).getZoomManager();
		} else if (type == IContentOutlinePage.class) {
			return new OutlinePage();
		}
		return super.getAdapter(type);
	}
	
	private Enterprise createEnterprise() {
		Enterprise psyEnterprise = new Enterprise();
		
		psyEnterprise.setName("Psykokwak Enterprise");
		psyEnterprise.setAddress("Quelque part sur terre");
		psyEnterprise.setCapital(100000);
//		psyEnterprise.setLayout(new Rectangle(0, 0, 300, 300));
		
		/*
		 * Service Compta
		 */
		Service comptaService = new Service();
		comptaService.setName("Compta");
		comptaService.setEtage(2);
		comptaService.setLayout(new Rectangle(30, 50, 250, 150));
		
		Employe employeCat = new Employe();
		employeCat.setName("Debroua");
		employeCat.setPrenom("Cat");
		employeCat.setLayout(new Rectangle(25, 40, 60, 40));
		comptaService.addChild(employeCat);
		
		Employe employeJyce = new Employe();
		employeJyce.setName("Psykokwak");
		employeJyce.setPrenom("Jyce");
		employeJyce.setLayout(new Rectangle(100, 60, 60, 40));
		comptaService.addChild(employeJyce);
		
		Employe employeEva = new Employe();
		employeEva.setName("Longoria");
		employeEva.setPrenom("Eva");
		employeEva.setLayout(new Rectangle(180, 90, 60, 40));
		comptaService.addChild(employeEva);

		psyEnterprise.addChild(comptaService);
		
		/*
		 * Service HR
		 */
		Service rhService = new Service();
		rhService.setName("Ressources Humaine");
		rhService.setEtage(1);
		rhService.setLayout(new Rectangle(220, 230, 250, 150));
		
		Employe employePaul = new Employe();
		employePaul.setName("Dupond");
		employePaul.setPrenom("Paul");
		employePaul.setLayout(new Rectangle(40, 70, 60, 40));
		rhService.addChild(employePaul);
		
		Employe employeEric = new Employe();
		employeEric.setName("Durand");
		employeEric.setPrenom("Eric");
		employeEric.setLayout(new Rectangle(170, 100, 60, 40));
		rhService.addChild(employeEric);
		
		psyEnterprise.addChild(rhService);
		
		return psyEnterprise;
	}
	
	protected class OutlinePage extends ContentOutlinePage {
		private SashForm sash;
		
		public OutlinePage() {
			super(new TreeViewer());
		}
		
		@Override
		public void createControl(Composite parent) {
			sash = new SashForm(parent, SWT.VERTICAL);
			
			getViewer().createControl(sash);
			getViewer().setEditDomain(getEditDomain());
			getViewer().setEditPartFactory(new AppTreeEditPartFactory());
			getViewer().setContents(model);
			
			getSelectionSynchronizer().addViewer(getViewer());
		}
		
		@Override
		public void init(IPageSite pageSite) {
			super.init(pageSite);
			
			IActionBars bars = getSite().getActionBars();
			bars.setGlobalActionHandler(ActionFactory.UNDO.getId(), getActionRegistry().getAction(ActionFactory.UNDO.getId()));
			bars.setGlobalActionHandler(ActionFactory.REDO.getId(), getActionRegistry().getAction(ActionFactory.REDO.getId()));
			bars.setGlobalActionHandler(ActionFactory.DELETE.getId(), getActionRegistry().getAction(ActionFactory.DELETE.getId()));
			bars.updateActionBars();
			
			getViewer().setKeyHandler(keyHandler);
		}
		
		@Override
		public Control getControl() {
			return sash;
		}
		
		@Override
		public void dispose() {
			
		}
	}
}
