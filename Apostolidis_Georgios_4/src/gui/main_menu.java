package gui;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import main_package.*;

public class main_menu extends JFrame 
{
	private JFrame mainMenu = new JFrame();
	private JPanel newUserPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel endPanel = new JPanel();
	private JButton newUser = new JButton("New User");
	private JButton enterUserPage = new JButton("Enter User Page");
	private JButton showInf = new JButton("Show Potential Infections");
	private JButton savePamak = new JButton("Save Pamakbook");
	private JTextField userName = new JTextField("user name");
	private JTextField userEmail = new JTextField("user email");
	

	public main_menu() {
		
		connectedClass connector = new connectedClass();
		
		newUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = userName.getText();
				String email = userEmail.getText();
				
				
				if(email.startsWith("iis")
						||email.startsWith("dai")
						||email.startsWith("ics")
						&&email.endsWith("@uom.edu.gr")){
					new users(name, email, connector);
					JOptionPane.showMessageDialog(mainMenu, "User " + name + " has been created!");
				}else {
					JOptionPane.showMessageDialog(mainMenu, "User " + name + " has not been created. Email format is not acceptable.");
				}
			}
		});

		
		showInf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						
				infections_page infPage = new infections_page(mainMenu,userEmail.getText(), connector);
				mainMenu.dispose();
				
			}
			
		});
		
		enterUserPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						user_page userPage = new user_page(mainMenu, userName.getText(), userEmail.getText(), connector);
						mainMenu.dispose();
			}
			
		});
		
		savePamak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainMenu, "PamakBook version iis20001 does not support this feature.");
			}
			
		});
		
		newUserPanel.add(newUser);
		newUserPanel.add(userName);
		newUserPanel.add(userEmail);
		mainMenu.add(newUserPanel, BorderLayout.PAGE_START);
		
		centerPanel.add(enterUserPage);
		centerPanel.add(showInf);
		mainMenu.add(centerPanel, BorderLayout.CENTER);
	
		endPanel.add(savePamak);
		mainMenu.add(endPanel, BorderLayout.PAGE_END);
		 
		mainMenu.pack();
		mainMenu.setVisible(true);
		mainMenu.setLocationRelativeTo(null);
		mainMenu.setTitle("Κεντρική Σελίδα");
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
