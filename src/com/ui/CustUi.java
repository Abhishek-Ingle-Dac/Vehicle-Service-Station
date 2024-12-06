package com.ui;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.entity.Customer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
public class CustUi extends JDialog{
	
	// Fields -> name, phoneno, address  ==> JLable and JTextField
	private JLabel nameLabel;
	private JLabel phonenoLabel;
	private JLabel addressLabel;
	private JTextField name;
	private JTextField phoneNumber;
	private JTextField address;
	private JButton submitBtn;
	
	public CustUi(Window p) {
		super(p);
		this.setTitle("New Customer");
		initComponents();
	}
	private void initComponents() {
	setLayout(null);
	add(getJnameLabel());
	setSize(800,600);
	add(getJphonenoLabel());
	add(getJaddressLabel());
	
	add(getJname());
	add(getJphoneno());
	add(getJaddress());
	add(getJsubmit());
	}
	private JButton getJsubmit() {
		submitBtn = new JButton("Submit");
		submitBtn.setBounds(250,400,90,30);
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSubmitActionPerformed(e);
			}
		});
		return submitBtn;
		
	}
    private Customer c =null;
	private void btnSubmitActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	       c=new Customer();
	       c.setName(name.getText());
	       c.setPhoneno(phoneNumber.getText());
	       c.setAddress(address.getText());
	       this.dispose();
	}

	private JTextField getJname() {
		if(name == null) {
			name = new JTextField();
			name.setBounds(200,20,100,20);
		}
		return name;
	}
	private JTextField getJphoneno() {
		if(phoneNumber == null) {
			phoneNumber = new JTextField();
			phoneNumber.setBounds(200,50,100,20);
		}
		return phoneNumber;
	}
	
	private JTextField getJaddress() {
		if(address == null) {
			address = new JTextField();
			address.setBounds(200,80,100,20);
		}
		return address;
	}
	private JLabel getJnameLabel() {
		if(nameLabel == null) {
			nameLabel = new JLabel();
			nameLabel.setText("Customer Name");
			nameLabel.setBounds(20,20,200,20);
		}
		return nameLabel;
	}
	private JLabel getJphonenoLabel() {
		if(phonenoLabel == null) {
			phonenoLabel = new JLabel();
			phonenoLabel.setText("Customer PhoneNo");
			phonenoLabel.setBounds(20,50,200,20);
		}
		return phonenoLabel;
	}
	private JLabel getJaddressLabel() {
		if(addressLabel == null) {
			addressLabel = new JLabel();
			addressLabel.setText("Customer Address");
			addressLabel.setBounds(20,80,200,20);
		}
		return addressLabel;
	}
	public Customer getCustomer() {
		return c;
	}
	
}
