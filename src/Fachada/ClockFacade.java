package Fachada;
import LogicalInterface.*;
import ObserverPackage.Observer;

public class ClockFacade {
	
	private Clock clock = null;
	
	public ClockFacade(){
		clock = Clock.getClock();
	}
	public void registerObserver(Observer o){
		clock.register(o);
	}
	public void unregisterObserver(Observer o){
		clock.unregister(o);
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
	public int getState(){
		if(clock.getCurrentState() == clock.getExibitionState()){
			return 0;
		}
		else if(clock.getCurrentState() == clock.getHourSetState()){
			return 1;
		}
		else if(clock.getCurrentState() == clock.getMinuteSetState()){
			return 2;
		}
		return -1;
	}

}
