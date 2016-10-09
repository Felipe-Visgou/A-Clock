public class MinuteSet implements ClockState{
	
	Clock relogio;
	
	public MinuteSet(Clock newClock){
		relogio = newClock;
	}

	@Override
	public void APressed() {
		System.out.println("Mudando para modo de Exibi��o");
		relogio.setClockState(relogio.getExibitionState());
	}

	@Override
	public void AReleased() {

	}

	@Override
	public void BPressed() {
		System.out.println("Alterando os minutos");
		// facade here???
		
	}

	@Override
	public void BReleased() {

	}

}

