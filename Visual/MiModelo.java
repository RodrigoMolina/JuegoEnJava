package Visual;

import javax.swing.table.DefaultTableModel;

public class MiModelo extends DefaultTableModel {
	 public MiModelo(Object[] titulosTabla, int i) {
		 super(titulosTabla, i);
	}

	public boolean isCellEditable (int row, int column)
	   {
	       return false;
	   }
}
