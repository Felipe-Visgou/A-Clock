package LogicalInterface;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Timer;

import ObserverPackage.*;

public class Clock  implements ActionListener, Subject {
	
	private static Clock clock = null;
	/* Possíveis estados do Relógio */
	private ClockState exibitionState;
	private ClockState hourSetState;
	private ClockState minuteSetState;
	
	private ArrayList<Observer> observers;
	
	private int hour;
	private int minute;
	private int second;
	
	private Timer timer;
	private final int DELAY = 1000;
	
	private int hourSkipped, minutesSkipped;
	
	/* Estado atual do Relógio */
	private ClockState currentState;
	
	/* estado dos botões */
	boolean a;
	boolean b;
	
	/* Constructor */
	public Clock(){
		
		/* Inicializa os States */
		exibitionState = new Exibition(this);
		hourSetState = new HourSet(this);
		minuteSetState = new MinuteSet(this);
		currentState = exibitionState;
		
		observers = new ArrayList<Observer>();
		
		/* Inicializa o estado dos botões */
		a  = false;
		b = false;
		hourSkipped = 0;
		minutesSkipped = 0;
		/* Inicializa o Timer com DELAY definido acima */
        timer = new Timer(DELAY, this);
        timer.start();
        /* Inicializa a data com os milisegundos (EPOCH Time) */
        hour = (int)((System.currentTimeMillis()/3600000)%24) - 3;
        minute = (int)((System.currentTimeMillis()/60000)%60);
        second = (int)((System.currentTimeMillis()/1000)%60);
	}
	
	public static Clock getClock(){
		if(clock == null)
			clock = new Clock();
		return clock;
	}
	
	/* * * * * *  Clock Class Methods * * * * * */
	public int getHour(){
		
		return hour;
	}
	public int getMinute(){
		return minute;
	}
	public void skipHour(){
		
		if((hourSkipped + 3600000) == 86400000)
			hourSkipped = 0;
		else
			hourSkipped+=3600000;
	}
	
	public void skipMinute(){
		if((minutesSkipped + 60000) == 3600000)
			minutesSkipped = 0;
		else
			minutesSkipped+=60000;
	}
	/* * * * * *  State Pattern Methods * * * * * */
	void setClockState(ClockState newState){
		currentState = newState;
	}
	public void pressA(){
		currentState.APressed();
	}
	public void pressB(){
		currentState.BPressed();
	}
	public void releaseA(){
		currentState.AReleased();
	}
	public void releaseB(){
		currentState.BReleased();
	}
	public ClockState getExibitionState( ){ return exibitionState ;}
	public ClockState getHourSetState() { return hourSetState ;}
	public ClockState getMinuteSetState() { return minuteSetState ;}
	public ClockState getCurrentState() { return currentState; }

	/* Action Listener */
	@Override
	public void actionPerformed(ActionEvent e) {

		// observer aqui
		 hour = (int)(((System.currentTimeMillis()+ hourSkipped - 10800000)/3600000)%24);
	     minute = (int)(((System.currentTimeMillis()+ minutesSkipped)/60000)%60);
	     second = (int)((System.currentTimeMillis()/1000)%60);
		// notify all observers
	     notifiyObservers();
	}

	@Override
	public void register(Observer o) {
		
		observers.add(o);
		
	}

	@Override
	public void unregister(Observer o) {
		
		int obsIndex = observers.indexOf(o);
		observers.remove(obsIndex);
		
	}

	@Override
	public void notifiyObservers() {
		
		for(Observer obs : observers){
			obs.update(this.hour, this.minute,this.second);
		}
		
	}
	
}
