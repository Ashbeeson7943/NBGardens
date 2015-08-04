import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Orderlist {

	Main m = new Main();
	ArrayList<String> orders = new ArrayList<>();
	ArrayList<String> oL = new ArrayList<>();
		
	public void showOrdersWaiting(){
		
		initOrderUI();
 	
	}
	
	public void showPickedOrder(){
		
	}

	public void addStock(){
		
	}
	
	void updateInventory(){
		
	}
	
	void addOrders(){
		
		orders.add("order 1");	
		orders.add("order 2");
		orders.add("order 3");
		orders.add("order 4");
	}
	
	void getOrders(){
				
		for (int i = 0; i < orders.size(); i++) {
		    oL.add(orders.get(i));
		}

	}
	
	void pickOrder(){
		
		oL.remove(0);
		
	}
	
	void storeInfo(){
		
	}
	

	void initOrderUI(){
		
		JFrame orderWind = new JFrame("SimpleWindow");
		JLabel header = new JLabel("ORDER LIST");
		JTextArea orderList = new JTextArea();
		JButton pick = new JButton("PICK");	
		JButton ref = new JButton("REFRESH");
		
		
				
		header.setBounds(10,0, 100, 50);		
		
		orderList.setBounds(10, 50, 200, 300);
		
		
		pick.setBounds(100, 0, 75, 50);
		pick.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Action
				pickOrder();
				m.initMainUI();
				orderWind.setVisible(false);
			}
		});
		addOrders();
		getOrders();
			
		ref.setBounds(260, 0, 75, 50);
		ref.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Action
				for(int i = 0; i < oL.size(); i++){
					orderList.append(oL.get(i) + "\n");
				}
			}
		});
		
		orderWind.setSize(400, 400);
		orderWind.setLayout(null);
		orderWind.add(pick);
		orderWind.add(ref);
		orderWind.add(header);
		orderWind.add(orderList);
	    orderWind.setVisible(true);
	    
		
	}
	
	void initPickOrderUI(){
		
	
	}
	
}
