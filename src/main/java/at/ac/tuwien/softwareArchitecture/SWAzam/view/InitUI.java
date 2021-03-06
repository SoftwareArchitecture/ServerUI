package at.ac.tuwien.softwareArchitecture.SWAzam.view;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("chameleon")
@SuppressWarnings("serial")
public class InitUI extends UI
{

    protected static final String MAINVIEW = "main";
    
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = InitUI.class, widgetset = "at.ac.tuwien.softwareArchitecture.SWAzam.view.AppWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
    	
    	getPage().setTitle("SWAZAM Server application");
        
    	  //
        // Create a new instance of the navigator. The navigator will attach
        // itself automatically to this view.
        //
        new Navigator(this, this);

        //
        // The Views for navigator
        //
        getNavigator().addView(SimpleLoginView.NAME, SimpleLoginView.class);
        getNavigator().addView(InsertView.NAME, InsertView.class);
        getNavigator().addView(DeleteView.NAME, DeleteView.class);
        getNavigator().addView(EditView.NAME, EditView.class);
        getNavigator().addView(HistoryView.NAME, HistoryView.class);
        //
        // Add the main view of the application
        //
        getNavigator().addView(MainView.NAME,
                MainView.class);
                       
        //
        // We use a view change handler to ensure the user is always redirected
        // to the login view if the user is not logged in.
        //
        getNavigator().addViewChangeListener(new ViewChangeListener() {
            
            public boolean beforeViewChange(ViewChangeEvent event) {
                
                // Check if a user has logged in
                boolean isLoggedIn = getSession().getAttribute("user") != null;
                boolean isLoginView = event.getNewView() instanceof SimpleLoginView;

                if (!isLoggedIn && !isLoginView) {
                    // Redirect to login view always if a user has not yet
                    // logged in
                    getNavigator().navigateTo(SimpleLoginView.NAME);
                    return false;

                } else if (isLoggedIn && isLoginView) {
                    // If someone tries to access to login view while logged in,
                    // then cancel
                    return false;
                }

                return true;
            }
            
            @Override
            public void afterViewChange(ViewChangeEvent event) {
                
            }
        });
        
    }

}
