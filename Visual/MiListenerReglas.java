package Visual;

public  class MiListenerReglas extends MiListenerAbstracto {
	private Inicio variable;
	public MiListenerReglas(Inicio arg) {
		variable=arg;
	}

	@Override
	public void voyHaciaAll�() {
		new VentanaDeReglas(variable,"Reglas del Juego", true);
	}

}
