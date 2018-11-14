package Codigo;

public class TitaniumWall extends ItemDeMapa {

    public TitaniumWall(Posicion arg) {
		super(arg);
		// TODO Auto-generated constructor stub
	}

	
	public Boolean actualizar(Mapa terreno){
		return false;
	}
	public Boolean sosTitanium(){
		return true;
	}

}