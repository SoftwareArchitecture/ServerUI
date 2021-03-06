package at.ac.tuwien.softwareArchitecture.SWAzam.view;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class InsertView extends CustomComponent implements View, Button.ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private Button button_1;
	@AutoGenerated
	private TextField textField_4;
	@AutoGenerated
	private TextField textField_3;
	@AutoGenerated
	private PasswordField passwordField_1;
	@AutoGenerated
	private TextField textField_1;
	@AutoGenerated
	private Label label_1;
	public static final String NAME = "insert";
	JerseyClient jc = new JerseyClient();
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public InsertView() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		jc.insertAccount(textField_1.getValue(), passwordField_1.getValue(), textField_3.getValue(), textField_4.getValue(), getSession().getAttribute("sessionKey").toString());
		Notification.show("User " + textField_1.getValue() + " created!", Notification.Type.HUMANIZED_MESSAGE);
		getUI().getNavigator().navigateTo(MainView.NAME);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout_1, "top:0.0px;left:0.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("-1px");
		verticalLayout_1.setHeight("-1px");
		verticalLayout_1.setMargin(false);
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		label_1.setValue("Insert new User");
		verticalLayout_1.addComponent(label_1);
		
		// textField_1
		textField_1 = new TextField("Username: ");
		textField_1.setImmediate(false);
		textField_1.setWidth("-1px");
		textField_1.setHeight("-1px");
		verticalLayout_1.addComponent(textField_1);
		
		// passwordField_1
		passwordField_1 = new PasswordField("Password: ");
		passwordField_1.setImmediate(false);
		passwordField_1.setWidth("-1px");
		passwordField_1.setHeight("-1px");
		verticalLayout_1.addComponent(passwordField_1);
		
		// textField_3
		textField_3 = new TextField("Firstname: ");
		textField_3.setImmediate(false);
		textField_3.setWidth("-1px");
		textField_3.setHeight("-1px");
		verticalLayout_1.addComponent(textField_3);
		
		// textField_4
		textField_4 = new TextField("Lastname: ");
		textField_4.setImmediate(false);
		textField_4.setWidth("-1px");
		textField_4.setHeight("-1px");
		verticalLayout_1.addComponent(textField_4);
		
		// button_1
		button_1 = new Button("Create User", this);
		button_1.setCaption("Create User");
		button_1.setImmediate(true);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		verticalLayout_1.addComponent(button_1);
		
		return verticalLayout_1;
	}

}
