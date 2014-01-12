package at.ac.tuwien.softwareArchitecture.SWAzam.view;

import java.util.List;

import at.ac.tuwien.softwarearchitecture.swazam.common.infos.Account;
import at.ac.tuwien.softwarearchitecture.swazam.common.infos.History;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;


public class HistoryView extends CustomComponent implements View{
	
	public static final String NAME = "history";
	JerseyClient jc = new JerseyClient();
	Account ac = new Account();
	
	private VerticalLayout mainLayout;
	private TextArea textAreaHistory;
	
	public HistoryView() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}
	
	
	private void buildMainLayout() {
		// TODO Auto-generated method stub
		mainLayout = new VerticalLayout();
		mainLayout.setSizeFull();
		
		textAreaHistory = new TextArea("History");
		textAreaHistory.setHeight("500px");
		textAreaHistory.setWidth("800px");
		mainLayout.addComponent(textAreaHistory);
		
		Button btn_back = new Button("Back to main", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				getUI().getNavigator().navigateTo(MainView.NAME);
			}
		});
		mainLayout.addComponent(btn_back);
	}
	
	public String generateHistory(List<History> list)
	{
		String output = "";
		
		
		for (History history : list) {
			if (ac.getId() == history.getAccountid()) 
			{
				output += "-10 Coins : ";
			}
			else if (ac.getId() == history.getPeerid())
			{
				output += "+10 Coins : ";
			}
			output += "HistoryID: "+ history.getId()+ " " 
					+ "AccountID: "+ history.getAccountid() + " "
					+ "MusicDescription: "+ history.getMusicdesc() + " "
					+ "PeerID: "+ history.getPeerid() + " "
					+ "ProcessStatus: "+ history.getProcessstatus() + " "
					+ "RequestMessage: "+ history.getRequestMessage() + " "
					+ "RequestType: "+ history.getRequesttype() + " "
					+ "SessionKey: "+ history.getSessionkey() + " "
					+ "SessionDate: "+ history.getSessiondate() + System.getProperty("line.separator")
					+ System.getProperty("line.separator");
		}
		return output;
	}
	

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		ac = (Account) getSession().getAttribute("account");
		
		List<History> histlist = jc.getHistory(ac.getId());
		
		textAreaHistory.setValue(generateHistory(histlist));
	}
}
