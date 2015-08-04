import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderlistWindow {

	MainWindow m;
	ArrayList<String> orders = new ArrayList<>();
	ArrayList<String> oL = new ArrayList<>();
	boolean hasStarted = true;
	ArrayList<CustomerOrder> customerOrder;
	ArrayList<CustomerOrder> pickedOrder;

	OrderlistWindow(ArrayList<CustomerOrder> co, ArrayList<CustomerOrder> po){
		customerOrder = co;
		pickedOrder = po;
	}

	public void showOrdersWaiting(){

		initOrderUI();

	}

	void addOrders(){
		System.out.println("ORDERS ADDED");
		customerOrder.add(new CustomerOrder(1, "Gnome"));	
		customerOrder.add(new CustomerOrder(2));
		customerOrder.add(new CustomerOrder(3));
		customerOrder.add(new CustomerOrder(4));

	}


	void pickOrder(){

		pickedOrder.add(customerOrder.get(0));
		customerOrder.remove(0);

	}

	void initOrderUI(){

		JFrame orderWind = new JFrame("OrderWindow");
		JLabel header = new JLabel("ORDER LIST");
		JTextArea orderList = new JTextArea();
		JButton pick = new JButton("PICK");	
		JButton ref = new JButton("REFRESH");
		JButton back = new JButton("BACK");		

		if(hasStarted){
			addOrders();
			hasStarted = false;
		}


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
				//m  = new MainWindow(customerOrder,pickedOrder);
				//m.mainUI();

				MainWindow.getWindow().showWindow();
				orderWind.setVisible(false);
			}
		});

		ref.setBounds(260, 0, 100, 50);
		ref.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Action
				System.out.println("REFRESHED");
				orderList.setText("");
				for(int i = 0; i < customerOrder.size(); i++){
					orderList.append("Order ID: " + customerOrder.get(i).orderID + "\n");
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
