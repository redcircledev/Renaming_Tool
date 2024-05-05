package components;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class StatusCellRender extends JTextField implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String status = new String();
        if (value instanceof String){
            status = (String) value;
        }
        setText(status);
        if (status.equals("Completed")) {
            setBackground(Color.GREEN);
        } else {
            setBackground(Color.YELLOW);
        }
        return this;
    }
}
