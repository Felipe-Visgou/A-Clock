import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
	
		AnalogInterface AI = new AnalogInterface();
		DigitalInterface DI = new DigitalInterface();
		ButtonInterface BI = new ButtonInterface();
		AI.setVisible(true);
		DI.setVisible(true);
		BI.setVisible(true);
	}

}
