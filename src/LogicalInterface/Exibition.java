package LogicalInterface;

public class Exibition implements ClockState{
	
	Clock relogio;
	
	public Exibition(Clock newClock){
		relogio = newClock;
	}

	@Override
	public void APressed() {
		System.out.println("Mudando para modo de ajuste das horas");
		relogio.setClockState(relogio.getHourSetState());
		relogio.a = true;
	}

	@Override
	public void AReleased() {
		relogio.a = false;
	}

	@Override
	public void BPressed() {
		System.out.println("Você não pode alterar o relógio em Modo de Exibição!");
		relogio.b = true;
	}

	@Override
	public void BReleased() {
		relogio.b = false;
	}

}

