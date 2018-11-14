package Visual;
public class JugadorEnRanking {
	private String nombreJugador;
	private Integer cantDiamantes=0;
	private Integer nivel=0;
	private Integer puntos=0;
	public String getNombreJugador() {
		return nombreJugador;
	}
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public Integer getCantDiamantes() {
		return cantDiamantes;
	}
	public void setCantDiamantes(Integer cantDiamantes) {
		this.cantDiamantes = cantDiamantes;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
}
