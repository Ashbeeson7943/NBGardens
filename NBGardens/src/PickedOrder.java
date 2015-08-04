import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickedOrder {

	Main m = new Main();
	Orderlist ol = new Orderlist();
	public String order;
	
	void initPickUI(){
		
		JFrame pickWind = new JFrame("SimpleWindow");
		JLabel header = new JLabel("ORDER TO BE PICKED");
		JTextArea orderList = new JTextArea();
		JButton back = new JButton("BACK");			
				
		header.setBounds(10,0, 200, 50);		
		
		orderList.setBounds(10, 50, 200, 300);
		orderList.append(order);
		
		
		back.setBounds(250, 0, 75, 50);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Action
				m.mainUI();
				pickWind.setVisible(false);
			}
		});
			
		
		pickWind.setSize(400, 400);
		pickWind.setLayout(null);
		pickWind.add(back);
		pickWind.add(header);
		pickWind.add(orderList);
		pickWind.setVisible(true);
	    
		
	}
	
	public void initUI(){
		
		initPickUI();
		
	}
	
	
}
