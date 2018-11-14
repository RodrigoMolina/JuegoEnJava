package Codigo;

public class Firefly extends Bicho {

	/*
	 * Firefly es análoga a Butterfly, con la particularidad de que se mueve en sentido horario
	 * y en su explosion genera Vacios en ves de diamantes. 
	 * Debe hacer los mismos chequeos en su explosion.
	 */

	public Firefly(Posicion arg) {
		super(arg);
	
	}
	public Boolean sosFirefly(){
		return true;
	}
	@Override
	public void moverse(ItemDeMapa[][] terreno) { 
		if(puedoMover(terreno)){
//			Una vez que chequeo que en esa posicion yo me puedo mover, seteo las posiciones.
			Integer posX=getMiPosicion().getX();
			Integer posY=getMiPosicion().getY();
			switch(DireccionActual){
			case Arriba:
				Vacio temp=(Vacio)terreno[posX][posY-1];
				terreno[posX][posY-1]=terreno[posX][posY];
				terreno[posX][posY]=temp;
				getMiPosicion().setY(getMiPosicion().getY()-1);
				break;
			case Derecha:
				Vacio temp1=(Vacio)terreno[posX+1][posY];
				terreno[posX+1][posY]=terreno[posX][posY];
				terreno[posX][posY]=temp1;
				getMiPosicion().setX(getMiPosicion().getX()+1);
				break;
			case Abajo:
				Vacio temp2=(Vacio)terreno[posX][posY+1];
				terreno[posX][posY+1]=terreno[posX][posY];
				terreno[posX][posY]=temp2;
				getMiPosicion().setY(getMiPosicion().getY()+1);
				break;
			case Izquierda:
				Vacio temp3=(Vacio)terreno[posX-1][posY];
				terreno[posX-1][posY]=terreno[posX][posY];
				terreno[posX][posY]=temp3;
				getMiPosicion().setX(getMiPosicion().getX()-1);
				break;
			}
		}
		else{
//			Cambio la direccion en sentido antihorario y paso el turno
			switch(DireccionActual){
			case Arriba:
				DireccionActual=Direccion.Derecha;
				break;
			case Derecha:
				DireccionActual=Direccion.Abajo;
				break;
			case Abajo:
				DireccionActual=Direccion.Izquierda;
				break;
			case Izquierda:
				DireccionActual=Direccion.Arriba;
				break;
			}
		}
	
	}

	@Override
	public Boolean explotar(ItemDeMapa[][] terreno) {
		   Boolean muere=false;
			System.out.println("Explota la Luciernaga de la posicion ["+(getMiPosicion().getX())+"]["+(getMiPosicion().getY())+"] y convierte en Vacio lo que hay en las posiciones:");
			for(int a=(getMiPosicion()).getX()-1;a<(getMiPosicion()).getX()+2;a++){
				for(int b=(getMiPosicion()).getY()-1;b<(getMiPosicion()).getY()+2;b++){
					if((b<22)&&(b>=0)&&(a>=0)&&(a<40)&&(!(terreno[a][b].sosTitanium()))){
						System.out.println("["+a+"]["+b+"]");
						if(terreno[a][b] .sosRockFord()){
							((Rockford)terreno[a][b]).setVidas(((Rockford)terreno[a][b]).getVidas()-1);
							System.out.println("Rockford muere por la explocion por lo que se le resta una vida");
							muere=true;
					  }
					terreno[a][b]=new Vacio(new Posicion(a,b));
					}
				}
			}
		return muere;
		}
	
	public Boolean actualizar(Mapa terreno){
		if(chequearAdyacentes(terreno.getEntidades())){
			explotar(terreno.getEntidades());
			return true;			
		}
		moverse(terreno.getEntidades());
		return false;
	}

}