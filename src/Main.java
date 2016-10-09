import java.io.IOException;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws IOException {
	
		AnalogInterface AI = new AnalogInterface();
		DigitalInterface DI = new DigitalInterface();
		ButtonInterface BI = new ButtonInterface();
		AI.setVisible(true);
		DI.setVisible(true);
		BI.setVisible(true);
		ClockFacade cd = new ClockFacade();
		
		while(true){
			for(double i = 0; i < 2e+4; i++)for(double j = 0; j < 2e+4; j++);
			System.out.println("Hora : " + cd.gethour());
			System.out.println("Minuto : " + cd.getMintute());

		}
	}

}
