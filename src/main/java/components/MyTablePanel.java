package components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import static models.TableModel.getTableModel;

public class MyTablePanel extends JPanel {

    JFrame parentFrame;

    private int currentRows;
    private JTable table;
    private DefaultTableModel model;

    private JScrollPane scroll;

    public MyTablePanel(int currentRows, JFrame parentFrame) {
        this.currentRows = currentRows;
        this.parentFrame = parentFrame;
        table = new JTable();
        scroll = new JScrollPane(table);
        model = getTableModel();
        table.setModel(model);
        model.addColumn("Index");
        model.addColumn("Original Filename");
        model.addColumn("Modified Filename");
        model.addColumn("Original Foldername");
        model.addColumn("Modified Foldername");
        model.addColumn("Status");
        table.getColumn("Status").setCellRenderer(new StatusCellRender());
        this.createLayout();
    }

    public void addNewRow(int index, String originalFileName, String modifiedFileName, String originalFolderName, String modifiedFolderName, String status){
        model.addRow(new Object[]{index,originalFileName,modifiedFileName,originalFolderName,modifiedFolderName,status});
        if (!(parentFrame.getExtendedState() == Frame.MAXIMIZED_BOTH)){
            parentFrame.pack();
        } else {
            parentFrame.pack();
            parentFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        }
    }

    public void modifyRow(int index , Object aValue, int column) {
        model.setValueAt(aValue,index,column);
    }

    public Object getRowAt(int index, int column) {
        return model.getValueAt(index, column);
    }

    public void removeRow(int index){
        model.removeRow(index);
        if (!(parentFrame.getExtendedState() == Frame.MAXIMIZED_BOTH)){
            parentFrame.pack();
        } else {
            parentFrame.pack();
            parentFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        }
    }

    public int getModelRowCount(){
        return model.getRowCount();
    }

    private void createLayout(){
        this.setLayout(new GridLayout(currentRows,1));
        this.add(scroll);
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getTable() {
        return table;
    }

    public int getCurrentRows() {
        return currentRows;
    }
}
