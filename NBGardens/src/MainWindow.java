import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainWindow extends JFrame {

	private ArrayList<CustomerOrder> co;
	private OrderlistWindow ol;
	private PickedOrderWindow po;
	
	MainWindow() {
		co = new ArrayList<>();
		ol = new OrderlistWindow(co);
		po = new PickedOrderWindow(co);
	}
	
	//Creates the initial window
	 void initMainUI(){
		JFrame mainWind = new JFrame("WareHouse System");
		JLabel header = new JLabel("WAREHOUSE MENU");
		JButton sOW = new JButton("Show Orders Waiting");
		JButton sPO = new JButton("Show order to be picked");
		
		header.setBounds(10,0, 150, 50);
		sOW.setBounds(10, 100, 200, 50);
		sOW.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Opens a new window and closes the current one
				ol.showOrdersWaiting();
				mainWind.setVisible(false);
			}
		});
		sPO.setBounds(220, 100, 200,50);
		sPO.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Opens a new window and closes the current one
				po.initUI();
				mainWind.setVisible(false);
			}
		});
		
	    mainWind.setSize(500, 500);
	    mainWind.setLayout(null);
	    mainWind.add(header);
	    mainWind.add(sOW);
	    mainWind.add(sPO);
		
	    mainWind.setVisible(true);
		
	}
	
	//Used for re-opening the main window from other places
	public void mainUI(){
		
		initMainUI();
		
	}
	
	

	
	
}
