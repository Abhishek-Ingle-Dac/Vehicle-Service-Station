package com.ui;

import javax.swing.JOptionPane;

import com.serviceprovider.FileIO;
import com.tester.Tester;

public class TesterUi {

	public static void main(String[] args) {
	    

		FileIO file = new FileIO();
		file.readCustData();
		file.readBillData();
		StringBuilder t1=new StringBuilder();
		t1.append("");
		JOptionPane.showMessageDialog(null, Tester.welcome());
		ServiceStationUi u = new ServiceStationUi();
		u.setVisible(true);
		//System.out.println(Tester.welcome());
		

	}

	
	
	}
