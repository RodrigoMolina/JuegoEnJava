package Visual;


public  class MiListenerJuego extends MiListenerAbstracto {
	private MiDialogoDeDatos variable;
	public MiListenerJuego(MiDialogoDeDatos arg) {
		variable=arg;
	}
	@Override
	public void voyHaciaAllí() {
		new MiDialogoDeJuego(variable,"Boulder Dush", true);
	}
}