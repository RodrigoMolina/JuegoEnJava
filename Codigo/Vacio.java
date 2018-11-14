package Codigo;
public class Vacio extends ItemDeMapa {
	public Vacio(Posicion arg) {
		super(arg);
		// TODO Auto-generated constructor stub
	}

	private String color= "negro";

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public Boolean actualizar(Mapa terreno){
		return false;
		
	}
	public Boolean sosVacio(){
		return true;
	}
}
	