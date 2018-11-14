package Codigo;

public class Posicion {

  public Integer x;

  public Integer y;

                      
  public Integer getX() {
	  return x;
  }

  public void setX(Integer arg) {
	  this.x=arg;
  }

  public Integer getY() {
  return y;
  }

  public void setY(Integer arg) {
	  this.y=arg;
  }

  public Posicion(Integer X, Integer Y) {
	  x=X;
	  y=Y;
  }

  
  public Boolean equals(Posicion arg){
	  if(x==arg.getX()&&y==arg.getY()){
		  return true;
	  }
	  else return false;
  }
  }

