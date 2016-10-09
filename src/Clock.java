import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

public class Clock  implements ActionListener {
	
	/* Possíveis estados do Relógio */
	private ClockState exibitionState;
	private ClockState hourSetState;
	private ClockState minuteSetState;
	
	
	private Timer timer;
	private Date date;
	private final int DELAY = 1000;
	
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
		
		/* Inicializa o estado dos botões */
		a  = false;
		b = false;
		
		/* Inicializa o Timer com DELAY definido acima */
        timer = new Timer(DELAY, this);
        
        /* Inicializa a data com os milisegundos (EPOCH Time) */
        date = new Date(System.currentTimeMillis());
	}
	
	/* * * * * *  Clock Class Methods * * * * * */
	
	public void starClock(){
		
		/* Inicia o timer */
        timer.start();
        
	}
	public Date getDate(){
		
		return date;
		
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
		date.setTime(System.currentTimeMillis());
		// notify all observers
	}
	
}
