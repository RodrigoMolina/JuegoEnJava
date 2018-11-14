
package Visual;

import java.awt.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Inicio extends JFrame{
	private  JButton b1,b2,b3, b4;
	private Font f;
	private JPanel miPanel;
	private JLabel l1;
	private static soundThreadsinicio musica;
	private RankingJugadores ranking;
	
	
	private Inicio(){
		super("Boulder Dush");
		
	}
	
	private void comenzar(){
		ranking= new RankingJugadores();
		f=new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 18);
		
		b1= new JButton("REGLAS DEL JUEGO");
		b1.setFont(f);
		b1.setForeground(Color.BLUE);
		b1.addMouseListener(new MiListenerReglas(this));
		
		
		b2= new JButton("¡QUIERO JUGAR!");
		b2.setFont(f);
		b2.setForeground(Color.BLUE);
		b2.addMouseListener(new MiListenerDatos());

		b3= new JButton("RANKING DE JUGADORES");
		b3.setFont(f);
		b3.setForeground(Color.BLUE);
		b3.addMouseListener( new MiListenerRanking());
		
		miPanel= new JPanel();
		
		miPanel.setLayout(new GridBagLayout());
		
		l1= new JLabel(new ImageIcon(getClass().getResource("imagen.GIF")));
		l1.setLayout(new GridBagLayout());
		
		b4= new JButton("¡¡¡SALIR!!!");
		b4.setFont(f);
		b4.setForeground(Color.RED);
		b4.addMouseListener(new MiListenerSalir());
		l1.add(b1);
		l1.add(b2);
		l1.add(b3);
		l1.setPreferredSize(getMaximumSize());
		miPanel.setLayout(new BorderLayout());

		miPanel.add(l1, BorderLayout.CENTER);
		miPanel.add(b4, BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(701,700));
		this.add(miPanel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	public void mostrarTabla(){
		
	}
	public void crearHilo(){
		musica= new soundThreadsinicio();
		musica.start();
	}
	public RankingJugadores damerRanking(){
		return ranking;
	}
	public static void main(String[] args){
		Inicio jugar= new Inicio();	
		jugar.crearHilo();
		jugar.comenzar();
	}

	public class MiListenerRanking extends MiListenerAbstracto {

		@Override
		public void voyHaciaAllí() {
			
			ranking.visibilizar();
		}

	}
	public class MiListenerDatos extends MiListenerAbstracto {
		
		

		@Override
		public void voyHaciaAllí() {
			super.detenerSonido();
			new MiDialogoDeDatos(Inicio.this, "Ingresa tus datos",true);
		}

	}

}

