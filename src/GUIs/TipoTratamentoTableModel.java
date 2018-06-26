package GUIs;




import Entidades.TipoTratamento;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TipoTratamentoTableModel extends AbstractTableModel {

    private final Class classes[] = new Class[]{Integer.class, String.class};
    private final String colunas[] = new String[]{"id", "Nome"};
    private List<TipoTratamento> dados;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //private final SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
  

    public TipoTratamentoTableModel(List<TipoTratamento> dados) {
        this.dados = dados;
    }

    public void setDados(List<TipoTratamento> dados) {
        this.dados = dados;
    }

    public List<TipoTratamento> getDados() {
        return this.dados;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        TipoTratamento s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getIdTipoTratamento();
            case 1:
                return s.getNomeTipoTratamentocol();            
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex==0) {
            return false;
        }
        return true;
    }

  
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

      //  mudou = true;
        TipoTratamento s = dados.get(rowIndex);
        switch (columnIndex) {
            case 0:              
                    s.setIdTipoTratamento((Integer) aValue);                
                break;
            case 1:
                s.setNomeTipoTratamentocol((String) aValue);
                break;          
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
        fireTableDataChanged();
    }

    public TipoTratamento getValue(int rowIndex) {
        return dados.get(rowIndex);
    }

    public int indexOf(TipoTratamento tc) {
        return dados.indexOf(tc);
    }

    public void onAdd(TipoTratamento tipoConta) {
        dados.add(tipoConta);
        fireTableRowsInserted(indexOf(tipoConta), indexOf(tipoConta));
    }

    public void onRemove(int[] rowIndex) {
        int x;
        for (x = rowIndex.length - 1; x >= 0; x--) {
            dados.remove(rowIndex[x]);
            fireTableRowsDeleted(rowIndex[x], rowIndex[x]);
        }
    }
}
