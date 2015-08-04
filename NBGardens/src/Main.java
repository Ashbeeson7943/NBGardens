
public class Main {

	//Main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JDBC jdbc = new JDBC();
		jdbc.accessBD();
		//MainWindow mw = new MainWindow();
		MainWindow mw = MainWindow.getWindow();
		mw.mainUI();
	}

}
