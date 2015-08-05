import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderlistWindow {

	ArrayList<String> orders = new ArrayList<>();
	ArrayList<CustomerOrder> customerOrder;
	ArrayList<CustomerOrder> pickedOrder;

	OrderlistWindow(ArrayList<CustomerOrder> co, ArrayList<CustomerOrder> po){
		customerOrder = co;
		pickedOrder = po;
	}

	public void showOrdersWaiting(){

		initOrderUI();

	}

	void pickOrder(){

		pickedOrder.add(customerOrder.get(0));
		customerOrder.remove(0);

	}
	//Creates the GUI for the Orders Waiting page
	void initOrderUI(){

		JFrame orderWind = new JFrame("Warehouse System");
		JLabel header = new JLabel("ORDER LIST");
		JTextArea orderList = new JTextArea();
		JButton pick = new JButton("PICK");	
		JButton ref = new JButton("REFRESH");
		JButton back = new JButton("BACK");		



		header.setBounds(10,0, 100, 50);		

		orderList.setBounds(10, 50, 200, 300);
		orderList.setEditable(false);

		pick.setBounds(100, 0, 75, 50);
		pick.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Action
				System.out.println("PICKED");
				pickOrder();
				MainWindow.getWindow().showWindow();
				orderWind.setVisible(false);
			}
		});

		back.setBounds(180, 0, 75, 50);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Action

				MainWindow.getWindow().showWindow();
				orderWind.setVisible(false);
			}
		});

		ref.setBounds(260, 0, 100, 50);
		ref.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Action
				if(customerOrder.size() > 0){
					System.out.println("REFRESHED");
					orderList.setText("");
					for(int i = 0; i < customerOrder.size(); i++){
						orderList.append("Order ID: " + customerOrder.get(i).orderID + "\n");
					}
				}
				else{
					System.out.println("NO MORE ORDERS");	
				}
			}

		});

		orderWind.setSize(400, 400);
		orderWind.setLayout(null);
		orderWind.add(pick);
		orderWind.add(back);
		orderWind.add(ref);
		orderWind.add(header);
		orderWind.add(orderList);
		orderWind.setVisible(true);


	}


}
