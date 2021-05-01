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
	private ClientLoginScreen parentWindow;
	
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
	
		btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainScreen.setVisible(true);
			}
		});
		btnLogout.setBounds(21, 28, 80, 29);
		panelClientFunc.add(btnLogout);
		
	}
	
	public void setVisible(boolean aFlag) {
		panelClientFunc.setVisible(aFlag);
		
	}
	public void addPanel(JPanel panel) {
		frame.getContentPane().add(panel);
	}
	

}
