package models;

import javax.swing.table.DefaultTableModel;

public class TableModel {
    public static DefaultTableModel getTableModel(){

        DefaultTableModel model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0: //index
                        return Integer.class;
                    case 1: //OGFN
                        return String.class;
                    case 2: //MDFN
                        return String.class;
                    case 3: //OGF
                        return String.class;
                    case 4: //MDF
                        return String.class;
                    case 5: //STS
                        return String.class;
                    default:
                        return String.class;
                }
            }
        };
        return model;
    }
}
