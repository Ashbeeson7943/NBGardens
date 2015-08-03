import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main extends JFrame {

	
	
	private static void initUI(){
		JFrame wind = new JFrame("SimpleWindow");
		JLabel header = new JLabel("ORDER LIST");
		JButton b1 = new JButton("Button One");
		JButton b2 = new JButton("Button Two");
		
		header.setBounds(10,0, 100, 50);
		b1.setBounds(10, 100, 100, 50);
	    b2.setBounds(120, 100, 100,50);
		
		wind.setSize(500, 500);
		wind.setLayout(null);
		wind.add(header);
		wind.add(b1);
		wind.add(b2);
		
		wind.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		initUI();
				
	}

	
	
}
