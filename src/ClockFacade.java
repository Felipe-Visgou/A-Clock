import java.util.Date;

public class ClockFacade {
	
	private Clock clock = null;
	
	public ClockFacade(){
		clock = Clock.getClock();
	}
	
	public void hourInc(){
		clock.skipHour();
	}
	public void minuteInc(){
		clock.skipMinute();
	}
	public void pressA(){
		clock.pressA();
	}
	public void pressB(){
		clock.pressB();
	}
	public int gethour(){
		return clock.getHour();
	}
	public int getMintute(){
		return clock.getMinute();
	}

}
