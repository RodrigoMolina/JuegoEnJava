package Codigo;

public class Dirt extends ItemDeMapa {
	
//	Dirt es una clase que no tiene una funcionalidad particular, solo a lo que el contexto de la programacion nos llevo
//	fue necesario definiorla como una clase con el fin de ser identificada en el programa como una entidad de tipo Basura
//	Caso similar al de TitaniumWall (muro de titanio)

    public Dirt(Posicion arg) {
		super(arg);
		// TODO Auto-generated constructor stub
	}

	public Boolean sosBasura(){
		return true;
	}
	public Boolean actualizar(Mapa terreno){
		return false;
	}

}