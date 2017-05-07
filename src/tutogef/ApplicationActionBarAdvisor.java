package tutogef;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected IWorkbenchAction makeAction(IWorkbenchWindow window, ActionFactory af) {
    	IWorkbenchAction action = af.create(window);
    	register(action);
    	return action;
    }

    /**
     * Enable Keyboard shortcut
     */
    @Override
    protected void makeActions(IWorkbenchWindow window) {
    	makeAction(window, ActionFactory.UNDO);
    	makeAction(window, ActionFactory.REDO);
    	makeAction(window, ActionFactory.COPY);
    	makeAction(window, ActionFactory.PASTE);
    }

    @Override
    protected void fillMenuBar(IMenuManager menuBar) {
    }
    
}
