package Visual;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;


public class RankingJugadores extends JFrame{

	private JTable tabla= new JTable();
	private MiModelo modeloDeTabla;
	private JScrollPane miScroll;
	private JPanel p1,p2, p3,p4;
	private JButton b1,b2;
	private JLabel l1;
	private Font f;
	public RankingJugadores(){
		super("Historial de Jugadores");
		this.setPreferredSize(new Dimension(701,700));
		l1=new JLabel(new ImageIcon(getClass().getResource("imagen.GIF")));
		this.setLayout(new GridLayout(1,1));
		l1.setLayout(new BorderLayout());
		
		Object[] titulosTabla={"Jugador","Diamantes","Nivel", "Puntaje"};
		modeloDeTabla= new MiModelo(titulosTabla,0);
		
		tabla.setModel(modeloDeTabla);
		tabla.setOpaque(false);
		miScroll=new JScrollPane(tabla);
		miScroll.setOpaque(false);
		miScroll.setPreferredSize(tabla.getMinimumSize());
		p1= new JPanel();
		p1.setLayout(new GridBagLayout());
		p1.setPreferredSize(new Dimension(200,50));
		p1.setOpaque(false);
		f=new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 18);
		b1=new JButton("Volver");
		b1.setFont(f);
		b1.setForeground(Color.BLUE);
		b1.addMouseListener(new MiListenerVolver());
		
		p1.add(b1);
		
		b2=new JButton("Borrar Ranking");
		b2.setFont(f);
		b2.setForeground(Color.RED);
		b2.addMouseListener(new MiListenerLimpiar());

		p1.add(b2);
		
		p2= new JPanel();
		p2.setPreferredSize(new Dimension(50,50));
		p2.setOpaque(false);
		p3= new JPanel();
		p3.setPreferredSize(new Dimension(50,50));
		p3.setOpaque(false);
		p4= new JPanel();
		p4.setOpaque(false);
		l1.add(p1, BorderLayout.NORTH);
		l1.add(p2, BorderLayout.WEST);
		l1.add(p3, BorderLayout.EAST);
		l1.add(p4, BorderLayout.SOUTH);
		
		l1.add(miScroll, BorderLayout.CENTER);
		this.add(l1);
		this.pack();
	}
	
	public void visibilizar(){
		this.setVisible(true);
	}
	public void ocultar(){
		this.setVisible(false);
	}
	public void agregarJugador(JugadorEnRanking arg){
		Object[] cadena={arg.getNombreJugador(), arg.getCantDiamantes().toString(),arg.getNivel().toString(), arg.getPuntos().toString()};
		((DefaultTableModel)tabla.getModel()).addRow(cadena);
	}
	
	public class MiListenerVolver extends MiListenerAbstracto {
		@Override
		public void voyHaciaAllí() {
		RankingJugadores.this.setVisible(false);
		}

	}
	
	public class MiListenerLimpiar extends MiListenerAbstracto {


		@Override
		public void voyHaciaAllí() {
			try {
				MiModelo modelo=(MiModelo)tabla.getModel();
				modelo.setRowCount(0);
				} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
				}

		}

	}
}
