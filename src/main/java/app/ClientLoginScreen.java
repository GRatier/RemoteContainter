package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import domains.Client;
import domains.LogisticCom;
import mainClasses.OperationNotAllowedException;



public class ClientLoginScreen implements PropertyChangeListener {
	
	PropertyChangeSupport support = new PropertyChangeSupport(this);
	LogisticCom logisticCompanyApp;
	Client client;
	private JPanel panelClientLogin;
	private MainScreen parentWindow;
	private JTextField clientEmailField;
	private JPasswordField passwordField;
	private JButton btnBack;
	private JButton btnLogin;
	private JLabel lblPassword;
	private JLabel lblClientEmail;
	private JLabel lblLoginStatus;
	private JFrame frame;
	private String errorMessage;
	MainScreen mainScreen;
	ClientFunctionalitiesScreen clientFunctionalitiesScreen;
	
	public ClientLoginScreen(LogisticCom logisticCompanyApp, MainScreen parentWindow, JFrame frame) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.parentWindow = parentWindow;
		this.frame = frame;
		this.addObserver(this);
		initialize();
	}
	
	void addObserver(PropertyChangeListener l) {
		support.addPropertyChangeListener(l);
	}

	public void initialize() {

		panelClientLogin = new JPanel();
		parentWindow.addPanel(panelClientLogin);
		panelClientLogin.setLayout(null);
		panelClientLogin.setBorder(BorderFactory.createTitledBorder(
                "Client login"));
		
		clientEmailField = new JTextField();
		clientEmailField.setBounds(138, 100, 130, 26);
		panelClientLogin.add(clientEmailField);
		clientEmailField.setColumns(10);
		
		lblClientEmail = new JLabel("Client email:");
		lblClientEmail.setBounds(50, 105, 90, 16);
		panelClientLogin.add(lblClientEmail);

		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 145, 74, 16);
		panelClientLogin.add(lblPassword);
		
		lblLoginStatus = new JLabel("");
		lblLoginStatus.setBounds(0, 65, 300, 16);
		lblLoginStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panelClientLogin.add(lblLoginStatus);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 140, 130, 26);
		panelClientLogin.add(passwordField);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean loginOk = false;
				
				try {
					loginOk = logisticCompanyApp.clientLogin(clientEmailField.getText(), passwordField.getText());
					client = logisticCompanyApp.getClient();
				} catch (OperationNotAllowedException exception) {
					lblLoginStatus.setText(exception.getMessage());
				}
				
				passwordField.setText("");
				clientEmailField.setText("");
				
				if(loginOk) {
					setVisible(false);
					clientFunctionalitiesScreen.setVisible(true);
					lblLoginStatus.setText("");
				}

			}
		});
		btnLogin.setBounds(148, 200, 117, 29);
		panelClientLogin.add(btnLogin);
		btnLogin.getRootPane().setDefaultButton(btnLogin);
		
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				parentWindow.setVisible(true);
			}
		});
		btnBack.setBounds(21, 28, 65, 29);
		panelClientLogin.add(btnBack);
		clientFunctionalitiesScreen = new ClientFunctionalitiesScreen(logisticCompanyApp, this, frame, parentWindow, client);
			
	}

	public void setVisible(boolean aFlag) {
		panelClientLogin.setVisible(aFlag);
	}
	
	public void addPanel(JPanel panel) {
		frame.getContentPane().add(panel);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}
	
}
