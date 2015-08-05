import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainWindow extends JFrame {

	public static MainWindow mainWindow = null;

	private ArrayList<CustomerOrder> co;
	private ArrayList<CustomerOrder> po;
	private OrderlistWindow ol;
	private PickedOrderWindow pow;

	JFrame mainWind;

	MainWindow() {
		
		JDBC jdbc = new JDBC();
		jdbc.accessBD();
		co = jdbc.co;
		po = new ArrayList<>();
		//co = new ArrayList<>();
		ol = new OrderlistWindow(co,po);
		pow = new PickedOrderWindow(co,po);
	}

	public static MainWindow getWindow() {

		if (mainWindow == null) {
			mainWindow = new MainWindow();
		}

		return mainWindow;
	}
	MainWindow(ArrayList<CustomerOrder> co) {
		this.co = co;
	}
	//Used for transferring the orders between pages so they are not destroyed
	MainWindow(ArrayList<CustomerOrder> co, ArrayList<CustomerOrder> po) {

		this.po = po;
		this.co = co;
	}

	public void showWindow() {

		mainWind.setVisible(true);
	}

	//Creates the initial window
	void initMainUI(){
		mainWind = new JFrame("Warehouse System");
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
				System.out.println("Size: " + po.size());
				pow.initUI();
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
