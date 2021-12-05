package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AppTM extends AbstractTableModel{

    private List<String[]> linhas;
    private String[] colunas = new String[]{"Matrícula","Nome"};
    
    public AlunoTM() {
        linhas = new ArrayList<String[]>();
    }
    
    public AlunoTM(List<String[]> lista) {
        linhas = new ArrayList<String[]>(lista);
    }
    
    @Override
    public int getColumnCount() {        
        return colunas.length;
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String t[] = linhas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return t[0];
            case 1:
                return t[1];
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String t[] = linhas.get(rowIndex); 

        switch (columnIndex) { // Seta o valor do campo respectivo
            case 0:
                t[0] = aValue.toString();
                break;
            case 1:
                t[1] = aValue.toString();
                break;
            default:            
        }
        fireTableCellUpdated(rowIndex, columnIndex);
     }
    
    public void setValueAt(String aValue[], int rowIndex) {
        String t[] = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado
        
        t[0] = aValue[0];
        t[1] = aValue[1];
        
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public String[] getApp(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    public void addApp(String a[]) {
        linhas.add(a);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void remove(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addLista(List<String[]> a) {
        int tamanhoAntigo = getRowCount();

        linhas.addAll(a);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }
    public boolean isEmpty() {
        return linhas.isEmpty();
    }   
}