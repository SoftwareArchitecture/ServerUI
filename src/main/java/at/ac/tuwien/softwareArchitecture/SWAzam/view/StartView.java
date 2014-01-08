package at.ac.tuwien.softwareArchitecture.SWAzam.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

//import at.ac.tuwien.softwareArchitecture.SWAzam.view.MyVaadinUI;

/** A start view for navigating to the main view */
public class StartView extends VerticalLayout implements View {
	
    public StartView() {
        setSizeFull();

        Button button = new Button("Go to Main View",
                new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
            	UI.getCurrent().getNavigator().navigateTo("main");
            }
        });
        addComponent(button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
    }        
        
    @Override
    public void enter(ViewChangeEvent event) {
        Notification.show("Welcome to the Animal Farm");
    }
}