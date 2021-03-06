package at.ac.tuwien.softwareArchitecture.SWAzam.view;

import at.ac.tuwien.softwarearchitecture.swazam.common.infos.Account;

import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.*;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.Reindeer;

public class SimpleLoginView extends CustomComponent implements View, Button.ClickListener {
	
	public static final String NAME = "login";
	
	private final TextField user;
	
	private final PasswordField password;
	
	private Account ac;
	
    private JerseyClient jc = new JerseyClient();
	
	private final Button loginButton;
	
	public SimpleLoginView() {
	setSizeFull();
	
	// Create the user input field
	user = new TextField("User:");
	user.setWidth("300px");
	user.setRequired(true);
	user.setInputPrompt("Your username ");
	//user.addValidator(new EmailValidator("Username must be an email address"));
	user.setInvalidAllowed(false);
	
	// Create the password input field
	password = new PasswordField("Password:");
	password.setWidth("300px");
	//password.addValidator(new PasswordValidator());
	password.setRequired(true);
	password.setValue("");
	password.setNullRepresentation("");
	
	// Create login button
	loginButton = new Button("Login", this);
	loginButton.setClickShortcut(KeyCode.ENTER);
	
	// Add both to a panel
	VerticalLayout fields = new VerticalLayout(user, password, loginButton);
	fields.setCaption("Please login to access the application. (test/test)");
	fields.setSpacing(true);
	fields.setMargin(new MarginInfo(true, true, true, false));
	fields.setSizeUndefined();
	
	// The view root layout
	VerticalLayout viewLayout = new VerticalLayout(fields);
	viewLayout.setSizeFull();
	viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
	//viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
	setCompositionRoot(viewLayout);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	// focus the username field when user arrives to the login view
	user.focus();
	}
	
	//
	// Validator for validating the passwords
	//
	private static final class PasswordValidator extends AbstractValidator<String> {
		
			public PasswordValidator() {
			    super("The password provided is not valid");
			}
			
			@Override
			protected boolean isValidValue(String value) {
			    //
			    // Password must be at least 8 characters long and contain at least
			    // one number
			    //
			    if (value != null
			            && (value.length() < 8 || !value.matches(".*\\d.*"))) {
			        return false;
			    }
			    return true;
			}
			
			@Override
			public Class<String> getType() {
			    return String.class;
			}
		}
		
		@Override
		public void buttonClick(ClickEvent event) {
		
		 //
		 // Validate the fields using the navigator. By using validors for the
		 // fields we reduce the amount of queries we have to use to the database
		 // for wrongly entered passwords
		 //
		if (!user.isValid() || !password.isValid()) {
		    return;
		}
		
		String username = user.getValue();
		String password = this.password.getValue();
		
		 //
		 // Validate username and password with database here. For examples sake
		 // I use a dummy username and password.
		 //
		//boolean isValid = username.equals("test")
		//        && password.equals("test");
		
		//if(isValid){
			ac = jc.login(username, password);
			
			if (ac != null)
			{
			
			    // Store the current user in the service session
			    getSession().setAttribute("user", username);
			    
			    getSession().setAttribute("account", ac);
			    
			    getSession().setAttribute("sessionKey", ac.getSessionkey());
			
			    // Navigate to main view
			    getUI().getNavigator().navigateTo(MainView.NAME);
			}
		
			
			//} else {
		
		    // Wrong password clear the password field and refocuses it
		  //  this.password.setValue(null);
		  //  this.password.focus();
		//}
		
	}
}