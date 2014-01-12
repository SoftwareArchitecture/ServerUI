package at.ac.tuwien.softwareArchitecture.SWAzam.view;

import at.ac.tuwien.softwarearchitecture.swazam.common.infos.Account;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickListener;

public class MainView extends CustomComponent implements View {

    public static final String NAME = "";
    
    Account ac;
    Label text = new Label();
    
    Button insertBtn = new Button("Create User", new ClickListener(){

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			getUI().getNavigator().navigateTo(InsertView.NAME);
		}
    	
    });
    Button editBtn= new Button("Edit User", new ClickListener(){

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			getUI().getNavigator().navigateTo(EditView.NAME);
		}
    	
    });
    Button deleteBtn= new Button("Delete User", new ClickListener(){

		@Override
		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			getUI().getNavigator().navigateTo(DeleteView.NAME);
		}
    	
    });
    
    Button historyBtn = new Button("History", new Button.ClickListener() {

        @Override
        public void buttonClick(ClickEvent event) {
            getUI().getNavigator().navigateTo(HistoryView.NAME);
            
            
        }
    });
    
    Button logout = new Button("Logout", new Button.ClickListener() {

        @Override
        public void buttonClick(ClickEvent event) {

            // "Logout" the user
            getSession().setAttribute("user", null);
            
            // Refresh this view, should redirect to login view
            getUI().getNavigator().navigateTo(NAME);
            
            
        }
    });

    public MainView() {
        setCompositionRoot(new VerticalLayout(text, insertBtn, deleteBtn, editBtn, historyBtn, logout));
    }

    public void enter(ViewChangeEvent event) {
        // Get the user name from the session
        String username = String.valueOf(getSession().getAttribute("user"));
        
        ac = (Account) getSession().getAttribute("account");
        
        // And show the username
        text.setValue("Hello " + username);
        
        
        
    }
}