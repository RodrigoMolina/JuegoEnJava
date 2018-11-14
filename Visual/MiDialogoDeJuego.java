package Visual;

import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import Codigo.*;


public class MiDialogoDeJuego extends JDialog {
	private Integer puntosAcumulados=0;
	private Timer planificador1=new Timer();
	private JPanel pSuperior;
	private JLabel l1,l2,l3,l4,l5;
	private MiPanel imagenes;
	private MiTimerCodigo tarea1;
	private MiTimerTime tarea2;
	private MiDialogoDeDatos referenciaAlPadre;
	public MiDialogoDeJuego(MiDialogoDeDatos arg0,String arg1, Boolean arg2){
		super(arg0,arg1,arg2);
		referenciaAlPadre=arg0;
		setDefaultCloseOperation( JDialog.DO_NOTHING_ON_CLOSE );
		this.addWindowListener(new miAdapterWindow());
       
		this.setLayout(new BorderLayout());
		tarea1=new MiTimerCodigo(arg0.dameNivel());
		
		pSuperior= new JPanel();
		pSuperior.setLayout(new GridLayout(1,5));
		
		l1=new JLabel(new ImageIcon(this.getClass().getResource("diamond.gif")));
		l1.setText(" "+ tarea1.dameDiamantes());
		l1.setForeground(Color.white);
		l2=new JLabel(new ImageIcon(this.getClass().getResource("corazon.gif")));
		l2.setText(""+tarea1.DameVidas());
		l2.setForeground(Color.white);
		l3=new JLabel(""+tarea1.dameAcumulados());
		l3.setForeground(Color.white);
		l4= new JLabel("150");
		l4.setForeground(Color.white);
		l5=new JLabel(new ImageIcon(this.getClass().getResource("moneda.gif")));
		l5.setText("Puntos: ");
		l5.setForeground(Color.white);
		pSuperior.add(l1);
		pSuperior.add(l2);
		pSuperior.add(l3);
		pSuperior.add(l4);
		pSuperior.add(l5);

		pSuperior.setBackground(Color.BLACK);
		pSuperior.setPreferredSize(new Dimension(640,27));
		imagenes= new MiPanel(tarea1.dameMapa());
		imagenes.setPreferredSize(getPreferredSize());
		this.add(pSuperior, BorderLayout.NORTH);
		this.add(imagenes, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(647,402));
		soundThreadsJugar sonido= new soundThreadsJugar();
		sonido.start();
		
		this.setResizable(false);
		this.setFocusable(true);
		this.pack();
		JOptionPane.showMessageDialog(this, "Para abandonar el juego precione 'Esc'.\n Para mover a Rock Ford precione las flechas.", "Indicaciones básicas", JOptionPane.INFORMATION_MESSAGE);
		this.addKeyListener(new MiKeyAdapter());
		tarea2=new MiTimerTime();
		planificador1=new Timer();
		planificador1.schedule(tarea1, 100, 400);
		planificador1.schedule(tarea2,0, 1000);
		this.setVisible(true);
	}
	
	

	//Clases que extienden de TimerTask y que son internas al JDialog
	public class MiTimerCodigo extends TimerTask {
		private Juego miJuego; 
		private JugadorEnRanking jugador;
		public MiTimerCodigo(Integer nivel){
			miJuego=new Juego(nivel);		
		}
		
		public Juego dameJuego(){
			return miJuego;
		}
		public void reiniciarTiempo(){
			l4.setText(""+150);
		}
		public void avanzarNivel(){
			l1.setText(" "+ tarea1.dameDiamantes());
			pSuperior.repaint();
		}
		public void sumarTiempo(){
				puntosAcumulados=puntosAcumulados+new Integer(10*this.dameAcumulados()+new Integer(l4.getText().trim()));
				l5.setText("Puntaje: "+puntosAcumulados);
				
		}
		@Override
		public void run() {
			for(int a=0;a<4;a++){					//cada 0.4 segundo se ejecutaran 4 actualizaciones
				if (miJuego.dameVidas()>0){
					l3.setText(""+this.dameAcumulados());
					l2.setText(""+miJuego.dameVidas());
					l5.setText("Puntaje: "+new Integer(10*this.dameAcumulados()+puntosAcumulados));
					pSuperior.repaint();
					if(miJuego.siguienteTurno()){		// miJuego.siguienteTurno() actualiza todas las entidades y devuelve verdadero si Rockford pierde una vida
						try {
							TimeUnit.MILLISECONDS.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						miJuego.reiniciar();
						this.reiniciarTiempo();
					}
					if(miJuego.llegue()){
						this.sumarTiempo();
						try {
							TimeUnit.MILLISECONDS.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						this.avanzarNivel();
						this.reiniciarTiempo();
						this.dameJuego().avanzarNivel();
					}
					try {
						TimeUnit.MILLISECONDS.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					MiDialogoDeJuego.this.repaint();
					
				}else {
					jugador=new JugadorEnRanking();
					jugador.setCantDiamantes(new Integer(l3.getText().trim()));
					jugador.setNivel(tarea1.miJuego.dameCampo().getNivelActual());
					jugador.setNombreJugador(referenciaAlPadre.dameNombre() );
					jugador.setPuntos(10*tarea1.dameAcumulados()+puntosAcumulados);
					MiDialogoDeJuego.this.dispose();
					referenciaAlPadre.dameRank().agregarJugador(jugador);
					referenciaAlPadre.dameRank().visibilizar();
					this.cancel();
					
				}
				
			}
		}
		public Integer DameVidas(){
			return miJuego.dameVidas();
		}
		public Integer dameDiamantes(){
			return miJuego.dameDiamantesNecesarios();
		}
		
		public void mover(Direccion d){
			miJuego.moverRockford(d);
		}
		public Integer dameAcumulados(){
			return miJuego.dameDiamantes();
		}
		
		public Mapa dameMapa(){
			return miJuego.getCampo();
		}
	}
	public class MiTimerTime extends TimerTask {		
		@Override
		public void run() {
			if(tarea1.DameVidas()>0){
				Integer dato=new Integer(l4.getText().trim());
				if(dato>0){
					l4.setText(""+(new Integer(l4.getText().trim())-1));
				}
				else{
					tarea1.miJuego.getMiJugador().setVidas(tarea1.miJuego.getMiJugador().getVidas()-1);
					try {
						TimeUnit.MILLISECONDS.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					tarea1.reiniciarTiempo();
					tarea1.miJuego.reiniciar();
					
					MiDialogoDeJuego.this.repaint();
				}
			}
			else{
				this.cancel();
			}
			
		}

	}
	
	public class MiKeyAdapter implements KeyListener{
		private JugadorEnRanking jugador;
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()){
			case KeyEvent.VK_DOWN:
				tarea1.mover(Direccion.Abajo);
				break;
			case KeyEvent.VK_LEFT:
				tarea1.mover(Direccion.Izquierda);
				break;
			case KeyEvent.VK_RIGHT:
				tarea1.mover(Direccion.Derecha);
				break;
			case KeyEvent.VK_UP:
				tarea1.mover(Direccion.Arriba);
				break;
			case KeyEvent.VK_ESCAPE:
				
				jugador=new JugadorEnRanking();
				jugador.setCantDiamantes(new Integer(l3.getText().trim()));
				jugador.setNivel(tarea1.miJuego.dameCampo().getNivelActual());
				jugador.setNombreJugador(referenciaAlPadre.dameNombre() );
				jugador.setPuntos(10*tarea1.dameAcumulados()+puntosAcumulados);
				MiDialogoDeJuego.this.dispose();
				referenciaAlPadre.dameRank().agregarJugador(jugador);
				referenciaAlPadre.dameRank().visibilizar();
				planificador1.cancel();
				break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
	}
	
	public class miAdapterWindow extends WindowAdapter{
			private JugadorEnRanking jugador;
		 public void windowClosing(WindowEvent e) {
			 	jugador=new JugadorEnRanking();
				jugador.setCantDiamantes(new Integer(l3.getText().trim()));
				jugador.setNivel(tarea1.miJuego.dameCampo().getNivelActual());
				jugador.setNombreJugador(referenciaAlPadre.dameNombre() );
				jugador.setPuntos(10*tarea1.dameAcumulados()+puntosAcumulados);
				MiDialogoDeJuego.this.dispose();
				referenciaAlPadre.dameRank().agregarJugador(jugador);
				referenciaAlPadre.dameRank().visibilizar();
				planificador1.cancel();
            }
	}
}