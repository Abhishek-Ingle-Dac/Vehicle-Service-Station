package com.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.entity.Customer;
import com.entity.Vehicle;

import java.awt.*;
public class VehUi extends JDialog{
	private JLabel companyLabel;
	private JLabel modelLabel;
	private JLabel numberplateLabel;
	private JTextField company;
	private JTextField model;
	private JTextField noplate;
	private JButton submitButton;
	
	public VehUi(Window parent) {
		super(parent);
		this.setTitle("New Vehicle");
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		add(getJcompanyLabel());
		setSize(800,600);
		add(getJmodelLabel());
		add(getJnumberplateLabel());
		
		add(getJcompany());
		add(getJmodel());
		add(getJnoplate());
		add(getJsubmitButton());		
	}
	  private Vehicle v =null;
	  
	private JLabel getJcompanyLabel() {
		if(companyLabel == null) {
			companyLabel = new JLabel();
			companyLabel.setText("Company");
			companyLabel.setBounds(20,20,100,20);
		}
		return companyLabel;
	}

	private JLabel getJmodelLabel() {
		if(modelLabel == null) {
			modelLabel = new JLabel();
			modelLabel.setText("Model");
			modelLabel.setBounds(20,50,100,20);
		}
		return modelLabel;
	}
	private JLabel getJnumberplateLabel() {
		if(numberplateLabel == null) {
			numberplateLabel = new JLabel();
			numberplateLabel.setText("NumberPlate");
			numberplateLabel.setBounds(20,80,100,20);
		}
		return numberplateLabel;
	}
	private JTextField getJcompany() {
		if(company == null) {
			company = new JTextField();
			company.setBounds(150,20,100,20);
		}
		return company;
	}
	private JTextField getJmodel() {
		if(model == null) {
			model = new JTextField();
			model.setBounds(150,50,100,20);
		}
		return model;
	}

	private JTextField getJnoplate() {
		if(noplate == null) {
			noplate = new JTextField();
			noplate.setBounds(150,80,100,20);
		}
		return noplate;
	}
	private JButton getJsubmitButton() {
		submitButton = new JButton("Submit");
		submitButton.setBounds(250,400,90,30);
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vbtnSubmitActionPerformed(e);				
			}		
		});
		return submitButton;
	}
	private void vbtnSubmitActionPerformed(ActionEvent e) {
		v=new Vehicle();
		v.setCompanyName(company.getText());
		v.setModelName(model.getText());
		v.setNumberPlate(noplate.getText());
		this.dispose();
	}
	
	public Vehicle getVehicle() {
		return v;
	}
}
