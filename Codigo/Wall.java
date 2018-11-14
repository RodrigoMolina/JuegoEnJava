package Codigo;

public class Wall extends ItemDeMapa {

    public Wall(Posicion arg) {
		super(arg);
		// TODO Auto-generated constructor stub
	}

	
	public Boolean actualizar(Mapa terreno){
		return false;
	}
	public Boolean sosPared(){
		return true;
	}

}