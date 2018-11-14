package Visual;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MiDialogoDeDatos extends JDialog {
	
	private JPanel panel1, panel2,panel3;
	
	private JLabel l1,l2, l3;
	private String[] parametros={"--Seleccione--","Nivel 1", "Nivel 2","Nivel 3", "Nivel 4","Nivel 5","Nivel 6","Nivel 7","Nivel 8","Nivel 9","Nivel 10"};
	private JButton miButton, volver;
	private JTextField campoDeTexto;
	private JComboBox<String> miCombo;
	private Font f,g;
	private Inicio referenciaAlPadre;
	
	public MiDialogoDeDatos(Inicio arg0, String arg1, Boolean arg2){
		super.setTitle(arg1);
		referenciaAlPadre=arg0;
		this.setPreferredSize(new Dimension(701,700));
		f=new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 20);
		g=new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 25);
	
		l1= new JLabel(new ImageIcon(this.getClass().getResource("imagen.GIF")));
		l1.setPreferredSize(getMaximumSize());
		panel1= new JPanel();
		panel1.setLayout(new FlowLayout());
		
		panel1.setOpaque(false);
		l2=new JLabel("Nombre: ");
		l2.setFont(g);
		l2.setForeground(Color.YELLOW);
		panel1.add(l2);
		campoDeTexto=new JTextField(14);
		campoDeTexto.addActionListener(new MiAdapterNombre());
		panel1.add(campoDeTexto);
		
		panel2= new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.setOpaque(false);
		l3=new JLabel("Nivel seleccionado");
		l3.setFont(g);
		l3.setForeground(Color.YELLOW);
		panel2.add(l3);
		miCombo=new JComboBox<String>(parametros);
		miCombo.addItemListener(new MiAdapterItem());
		panel2.add(miCombo);
		
		panel3= new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setOpaque(false);
		miButton=new JButton("JUGAR!");
		miButton.setEnabled(false);
		miButton.setFont(f);
		miButton.addMouseListener(new MiListenerJuego(this));
		panel3.add(miButton);
		
		volver= new JButton("Volver");
		volver.setFont(f);
		volver.addMouseListener(new MiListenerVolver());
		panel3.add(volver);
		l1.setLayout(new GridLayout(3,1));
		
		l1.add(panel1);
		l1.add(panel2);
		l1.add(panel3);
		this.add(l1);
		this.pack();
		this.setVisible(true);
		JOptionPane.showMessageDialog(this, "Debe ingresar un nombre con almenos cuatro letras.\n Debe seleccionar un nivel.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
	public RankingJugadores dameRank(){
		return referenciaAlPadre.damerRanking();
	}
	public Integer dameNivel(){
		return miCombo.getSelectedIndex();
	}
	public String dameNombre(){
		return campoDeTexto.getText();
	}
	public class MiAdapterNombre implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
		if((campoDeTexto.getText().length()>4)&&(miCombo.getItemCount()>=1)){
			miButton.setEnabled(true);
		}else{
			miButton.setEnabled(false);
		}
			
		}
		
	}
	public class MiAdapterItem implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			if((campoDeTexto.getText().length()>4)&&(miCombo.getItemCount()>=1)){
				miButton.setEnabled(true);
			}else{
				miButton.setEnabled(false);
			}
			
		}
		
	}
	
	public class MiListenerVolver extends MiListenerAbstracto {

		@Override
		public void voyHaciaAllí() {
			
			MiDialogoDeDatos.this.setVisible(false);
		}

	}
}
