package com.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.entity.Customer;
import com.entity.ServiceRequest;
import com.entity.Vehicle;
import com.serviceprovider.ServiceStation;
import java.awt.*;

public class ServiceRequestUi extends JDialog{
	private JLabel custNumberLabel;
	private JLabel vehNumberLabel;
	private JButton submitBtn;
	private JComboBox<String> custCmb;
	private JComboBox<String> vehCmb;
	private JButton btnsubmit;
	private JLabel newServiceLabel;
	private JRadioButton oilservice;
	private JRadioButton maintenance;
	private ButtonGroup servbtn=new ButtonGroup();
	private JLabel oildes;
	private JLabel oilCost;
	private JLabel maintenanceCost;
	private JLabel maintenanceDes;
	private JTextArea oilArea;
	private JTextField ocostField;
	private JTextArea maintenanceArea;
	private JTextField mcostField;
	private JScrollPane oilAreaScrollPane;
	
	public ServiceRequestUi(Window parent) {
		super(parent);
		this.setTitle("New Service");
		initServiceComponents();
	}

	private void initServiceComponents() {
		setLayout(null);
		add(getJcustNumberLabel());
		add(getJvehNumberLabel());
		add(getCmbcust());
		add(getCmbveh());
		add(getbtnsubmit());
		add(getnewService());
		add(getoilService());
		add(getmaintenance());
		add(getoildes());
		add(getoilCost());
		add(getmaintenanceCost());
		add(getmaintenanceDes());
		add(getmaintainanceDesTextArea());
		add(getmaintenancemcostField());
		add(getoilcostField());
		add(getoilDesTextArea());
		//add(getoilAreaScrollPane());
		setSize(800,600);	
		
	}
	

	private JTextArea getoilDesTextArea() {
		if(oilArea == null) {
			oilArea = new JTextArea();
			oilAreaScrollPane = new JScrollPane();
			oilAreaScrollPane.setBounds(30,10,5,10);
			oilArea.setBounds(20,290,90,30);
		}
		return oilArea;
	}

	private JTextField getoilcostField() {
		if(ocostField == null) {
			ocostField = new JTextField();
			ocostField.setBounds(20,225,75,30);
		
	}
		return ocostField;
	}
	private JTextField getmaintenancemcostField() {
		if(mcostField == null) {
			mcostField = new JTextField();
			mcostField.setBounds(170,225,75,30);
		}
		return mcostField;
	}

	private JTextArea getmaintainanceDesTextArea() {
		if(maintenanceArea==null) {
			maintenanceArea=new JTextArea();
			maintenanceArea.setBounds(170,290,150,30);
		}
		
		return maintenanceArea;
	}

	private JLabel getmaintenanceDes() {
		if(maintenanceDes == null) {
			maintenanceDes = new JLabel();
			maintenanceDes.setBounds(170,250,150,30);
		}
		return maintenanceDes;
	}

	private JLabel getoildes() {
		if(oildes == null) {
			oildes = new JLabel();
			oildes.setBounds(20,250,150,30);
		}
		return oildes;
	}

	private JLabel getmaintenanceCost() {
		if(maintenanceCost == null) {
			maintenanceCost = new JLabel();
			maintenanceCost.setBounds(170,185,150,30);
		}
		return maintenanceCost;
	}

	private JLabel getoilCost() {
		if(oilCost == null) {
			oilCost = new JLabel();
			oilCost.setBounds(20,185,150,30);
		}
		return oilCost;
	}



	private JRadioButton getoilService() {
		if(oilservice==null)
		{
			oilservice=new JRadioButton("Oil Service");
			oilservice.setBounds(20,152,120,30);
			oilservice.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					if(oilservice.isSelected())
					{	oilCost.setText("Oil Cost");	
						oildes.setText("Oil Description");
					}
					
				}
				
			});
			servbtn.add(oilservice);
		}
		return oilservice;
	}
	private JRadioButton getmaintenance() {
		if(maintenance==null)
		{
			maintenance=new JRadioButton("Maintenance");
			maintenance.setBounds(160,152,120,30);
			maintenance.addChangeListener(new ChangeListener() {

				@Override
				
				public void stateChanged(ChangeEvent e) {
					if(maintenance.isSelected())
						maintenanceCost.setText("Labour Charge");
					    
						maintenanceDes.setText("Maintenance Description");
				}
				
			});
			servbtn.add(maintenance);
		}
		return maintenance;
	}
	private JLabel getnewService() {
		if(newServiceLabel == null) {
			newServiceLabel = new JLabel();
			newServiceLabel.setText("Select New Service");
			newServiceLabel.setBounds(70,130,150,30);
		}
		return newServiceLabel ;
	}

	private JComboBox<String> getCmbcust() {
		
		if (custCmb == null) {
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(new String[] {"-Select Customer", "* New Customer" });
			custCmb = new JComboBox<>();
			custCmb.setModel(model);
			custCmb.setDoubleBuffered(false);
			custCmb.setBorder(null);
			custCmb.setBounds(96, 11, 150, 25);
			custCmb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				cmbCustomerItemStateChanged(event);
			}

			});
			for (Customer cust : ServiceStation.station.getCustList()) {
			model.addElement(cust.getName());
			}
			}
		return custCmb ;
	}
	private JComboBox<String> getCmbveh() {
		
		if (vehCmb == null) {
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(new String[] {"-Select Vehicle", "* New Vehicle" });
			vehCmb = new JComboBox<>();
			vehCmb.setModel(model);
			vehCmb.setDoubleBuffered(false);
			vehCmb.setBorder(null);
			vehCmb.setBounds(96, 45, 150, 25);
			vehCmb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				cmbVehicleItemStateChanged(event);
			}

			});
		}
		return vehCmb ;	
	}

	private void cmbCustomerItemStateChanged(ItemEvent event) {
		DefaultComboBoxModel<String> model;
		if(event.getStateChange()==ItemEvent.SELECTED)
		{
			String item=(String) event.getItem();
			if(item.startsWith("-"))
				return;
			if(item.startsWith("*"))
			{
				CustUi dialog = new CustUi(this);
				dialog.setModal(true);
				dialog.setVisible(true);
				Customer newCust = dialog.getCustomer();
				System.out.println(newCust);
			 if(newCust!=null)
			 {
				 System.out.println("Checking"+newCust);
				ServiceStation.station.newCustomer(newCust); 
				model=(DefaultComboBoxModel<String>)custCmb.getModel();
				model.addElement(newCust.getPhoneno());
				custCmb.setSelectedItem(newCust.getPhoneno());;
				model=(DefaultComboBoxModel<String>)vehCmb.getModel();
				model.removeAllElements();
				model.addElement("-Select Vehicle");
				model.addElement("*New Vehicle");
			 }
			
			}else {
				String cusNo= (String) custCmb.getSelectedItem();
				Customer custom=ServiceStation.station.FindCustomer(cusNo);
				if(custom!=null)
				{
				   model=(DefaultComboBoxModel<String>)vehCmb.getModel()	;
				   model.removeAllElements();
				   model.addElement("-Select Vehicle");
				   model.addElement("*New Vehicle");
				   for(Vehicle veh:custom.getVehList())
				   {
					   model.addElement(veh.getNumberPlate());
				   }
				}
			}
			
		}
		
	}
	private void cmbVehicleItemStateChanged(ItemEvent event) {
		DefaultComboBoxModel<String> model;
		if(event.getStateChange()==ItemEvent.SELECTED)
		{
			String item=(String) event.getItem();
			if(item.startsWith("-"))
				return;
			if(item.startsWith("*"))
			{
				VehUi dialog = new VehUi(this);
//				dialog.setModal(true);
				dialog.setModal(true);
				dialog.setVisible(true);
				String custName=(String) custCmb.getSelectedItem();
				Customer cus=ServiceStation.station.FindCustomer(custName);
				if(cus==null)
				{
					JOptionPane.showMessageDialog(this,"Select Customer!");
					return;
				}
				Vehicle newVeh = dialog.getVehicle();
			 if(newVeh!=null)
			 {
				 cus.newVahicle(newVeh);
				 DefaultComboBoxModel<String> vmodel=(DefaultComboBoxModel<String>)vehCmb.getModel();
				 vmodel.addElement(newVeh.getNumberPlate());
				 vehCmb.setSelectedItem(newVeh.getNumberPlate());
				 
//				ServiceStation.station.
//				model=(DefaultComboBoxModel<String>)custCmb.getModel();
//				model.addElement(newVeh.getNumberPlate());
//				custCmb.setSelectedItem(newVeh.getNumberPlate());;
				
			 }
			}else {
				String cusNo= (String) custCmb.getSelectedItem();
				Customer custom=ServiceStation.station.FindCustomer(cusNo);
				if(custom!=null)
				{
				   model=(DefaultComboBoxModel<String>)vehCmb.getModel()	;
				   model.removeAllElements();
				   model.addElement("-Select Vehicle");
				   model.addElement("*New Vehicle");
				   for(Vehicle veh:custom.getVehList())
				   {
					   model.addElement(veh.getNumberPlate());
				   }
				}
			}
			
		}
		
	}
	private JLabel getJvehNumberLabel() {
		if(vehNumberLabel == null) {
			vehNumberLabel = new JLabel();
			vehNumberLabel.setText("Vehicle : ");
			vehNumberLabel.setBounds(20,52,66,15);
		}
		return vehNumberLabel;
	}

	private JLabel getJcustNumberLabel() {
		if(custNumberLabel == null) {
			custNumberLabel = new JLabel();
			custNumberLabel.setText("Customer : ");
			custNumberLabel.setBounds(20,14,70,15);
		}
		return custNumberLabel;
	}
	private ServiceRequest serviceReq = null;

	public ServiceRequest getServiceReq() {
		return serviceReq;
		
	}
	private JButton getbtnsubmit() {
		if(btnsubmit==null)
		{
			btnsubmit=new JButton();
			btnsubmit.setText("Submit");
			btnsubmit.setBounds(90,90,75,30);
			btnsubmit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					btnsubmitActionPerformed(e);
				}
				
			});
		}
		return btnsubmit;
	}

	private void btnsubmitActionPerformed(ActionEvent e) {
		String custName=(String) custCmb.getSelectedItem();
		String vehNumber=(String) vehCmb.getSelectedItem();
		if(custName.startsWith("*")||custName.startsWith("-")||vehNumber.startsWith("*")||vehNumber.startsWith("-"))
		{
			JOptionPane.showMessageDialog(this,"Select Customer and Vehicle Correctly!!!");
			return;
		}
		serviceReq=new ServiceRequest();
		serviceReq.setCustomerNo(custName);
		serviceReq.setVehicleNO(vehNumber);
		this.dispose();
	}
}
