package com.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entity.ServiceRequest;

import javax.swing.*;

public class ServiceStationUi extends JFrame{
	private ArrayList<ServiceRequest> activeServiceList = new ArrayList<>();	
	private JButton btnNewServiceReq;
		
		private  DefaultListModel<String> actionSerReqListModel = new DefaultListModel<String>();
		private JList<String> listActiveServiceReq;
		public ServiceStationUi() {
			initComponents();
			setSize(600,800);
		}

		private void initComponents() {
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("Vehicle Service Station");
			setLayout(null);
			
			add(getBtnNewServiceReq());
			
		}

		private JButton getBtnNewServiceReq() {
			if(btnNewServiceReq == null) {
				btnNewServiceReq = new JButton();
				btnNewServiceReq.setText("New Req");
				btnNewServiceReq.setBounds(254,265,140,26);
				btnNewServiceReq.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnNewServiceReqAnction(e);
					}
				});
			}
			return btnNewServiceReq;
		}

		protected void btnNewServiceReqAnction(ActionEvent e) {
			ServiceRequestUi serReqDlg = new ServiceRequestUi(this);
			serReqDlg.setModal(true);
			serReqDlg.setVisible(true);
			ServiceRequest req = serReqDlg.getServiceReq();
			if(req!=null) {
				activeServiceList.add(req);
				actionSerReqListModel.addElement(req.toString());
				int index = actionSerReqListModel.getSize()-1;
				listActiveServiceReq.setSelectedIndex(index);
				
			}
		}



				
				
				
                				
				

		 }

