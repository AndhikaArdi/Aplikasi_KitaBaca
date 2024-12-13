package helpers;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {

    private final boolean[] CanEdit;

    public CustomTableModel(Object[][] data, Object[] columnNames, boolean canEdit) {
        super(data, columnNames);

        CanEdit = new boolean[columnNames.length];
        
        for (int i = 0; i < columnNames.length; i++) {
            CanEdit[i] = canEdit;
        }
        
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return CanEdit[column];
    }
}

