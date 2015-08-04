import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PickedOrderWindow {

	MainWindow m;

	public static String order;

	ArrayList<CustomerOrder> customerOrder;
	ArrayList<CustomerOrder> pickedOrder;

	PickedOrderWindow(ArrayList<CustomerOrder> co, ArrayList<CustomerOrder> po){
		customerOrder = co;
		pickedOrder = po;
	}

	public void initUI(){

		initPickUI();

	}


	void initPickUI(){

		JFrame pickWind = new JFrame("PickWindow");
		JLabel header = new JLabel("ORDER TO BE PICKED");
		JTextArea orderScreen = new JTextArea();
		JButton back = new JButton("BACK");			
		JButton ref = new JButton("REFRESH");

		header.setBounds(10,0, 200, 50);		

		orderScreen.setBounds(10, 50, 200, 300);
		orderScreen.setEditable(false);

		back.setBounds(250, 0, 75, 50);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Action
				MainWindow.getWindow().showWindow();
				pickWind.setVisible(false);
			}
		});

		ref.setBounds(150, 0, 100, 50);
		ref.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Action
				System.out.println("REFRESHED PICK");

				orderScreen.append("Order ID: " + pickedOrder.get(0).orderID + "\n" + "Item: " + pickedOrder.get(0).orderItemName + "\n");
			}
		});


		pickWind.setSize(400, 400);
		pickWind.setLayout(null);
		pickWind.add(back);
		pickWind.add(ref);
		pickWind.add(header);
		pickWind.add(orderScreen);
		pickWind.setVisible(true);


	}



}
