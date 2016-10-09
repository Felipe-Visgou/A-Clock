
public class HourSet implements ClockState{
	
	Clock relogio;
	
	public HourSet(Clock newClock){
		relogio = newClock;
	}

	@Override
	public void APressed() {
		System.out.println("Mudando para modo de ajuste dos minutos");
		relogio.setClockState(relogio.getMinuteSetState());
	}

	@Override
	public void AReleased() {
	}

	@Override
	public void BPressed() {
		System.out.println("Alterando as Horas");
		// ????? aqui entra o facade???!!
		
	}

	@Override
	public void BReleased() {

	}

}

