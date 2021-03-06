package app;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domains.Client;
import domains.LogisticCom;

public class ClientFunctionalitiesScreen {
	
	LogisticCom logisticCompanyApp;
	Client client;
	RegisterJourneyScreen registerJourneyScreen;
	ClientFindJourneyScreen clientFindJourneyScreen;
	OtherClientScreen otherClientScreen;
	ChangePasswordScreen changePasswordScreen;	
	private ClientLoginScreen parentWindow;
	
	private JButton btnRegisterJourney;
	private JButton btnFindJourney; 
	private JButton btnOtherClients;
	private JButton btnGiveAccess;
	private JButton btnChangePassword;	
	private JButton btnLogout;
	private JPanel panelClientFunc;
	private JFrame frame;
	MainScreen mainScreen;


	public ClientFunctionalitiesScreen(LogisticCom logisticCompanyApp, ClientLoginScreen parentWindow, JFrame frame, MainScreen mainScreen, Client client) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.mainScreen = mainScreen;
		this.frame = frame;
		initialize();
	}
	
	private void initialize() {
		
		panelClientFunc = new JPanel();
		parentWindow.addPanel(panelClientFunc);
		panelClientFunc.setLayout(null);
		panelClientFunc.setBorder(BorderFactory.createTitledBorder(
                "Client functionalities"));
		
		
		btnRegisterJourney = new JButton("Register Journey");
		btnRegisterJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				registerJourneyScreen.setVisible(true);
			}
		});
		btnRegisterJourney.setBounds(95, 93, 210, 29);
		panelClientFunc.add(btnRegisterJourney);	
		
		

		btnFindJourney = new JButton("Find Existing Journey");
		btnFindJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				clientFindJourneyScreen.setVisible(true);
			}
		});
		btnFindJourney.setBounds(95, 133, 210, 29);
		panelClientFunc.add(btnFindJourney);
		
		btnOtherClients = new JButton("View Other Clients");
		btnOtherClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				otherClientScreen.setVisible(true);
			}
		});
		btnOtherClients.setBounds(95, 173, 210, 29);
		panelClientFunc.add(btnOtherClients);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				changePasswordScreen.setVisible(true);
			}
		});
		btnChangePassword.setBounds(95, 253, 210, 29);
		panelClientFunc.add(btnChangePassword);
		
		btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainScreen.setVisible(true);
			}
		});
		btnLogout.setBounds(21, 28, 80, 29);
		panelClientFunc.add(btnLogout);
		
		
		registerJourneyScreen = new RegisterJourneyScreen(logisticCompanyApp, this);
		clientFindJourneyScreen = new ClientFindJourneyScreen(logisticCompanyApp, this, client);
		otherClientScreen = new OtherClientScreen(logisticCompanyApp, this);
		changePasswordScreen = new ChangePasswordScreen(logisticCompanyApp, this, client);
		
	}
	
	public void setVisible(boolean aFlag) {
		panelClientFunc.setVisible(aFlag);
		
	}
	public void addPanel(JPanel panel) {
		frame.getContentPane().add(panel);
	}
	

}
