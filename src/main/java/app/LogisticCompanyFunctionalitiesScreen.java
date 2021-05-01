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

import domains.LogisticCom;

public class LogisticCompanyFunctionalitiesScreen {
	LogisticCom logisticCompanyApp;
	private LogisticCompanyLoginScreen parentWindow;
	
	private JButton btnRegisterClient;
	private JButton btnContainerForJourney;
	private JButton btnFindJourney; 
	private JButton btnFindClient;
	private JButton btnLogout;
	private JPanel panelLogisticCompanyFunc;
	private JFrame frame;
	MainScreen mainScreen;


	public LogisticCompanyFunctionalitiesScreen(LogisticCom logisticCompanyApp, LogisticCompanyLoginScreen parentWindow, JFrame frame, MainScreen mainScreen) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.mainScreen = mainScreen;
		this.frame = frame;
		initialize();
	}
	private void initialize() {
		
		panelLogisticCompanyFunc = new JPanel();
		parentWindow.addPanel(panelLogisticCompanyFunc);
		panelLogisticCompanyFunc.setLayout(null);
		panelLogisticCompanyFunc.setBorder(BorderFactory.createTitledBorder(
                "Logistic Company functionalities"));
		
		btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainScreen.setVisible(true);
				// logout from LogisticCompanyApp !!!!!!!!
			}
		});
		btnLogout.setBounds(21, 28, 80, 40);
		panelLogisticCompanyFunc.add(btnLogout);
		
	}
	
	public void setVisible(boolean aFlag) {
		panelLogisticCompanyFunc.setVisible(aFlag);
		
	}
	public void addPanel(JPanel panel) {
		frame.getContentPane().add(panel);
	}
	


}
