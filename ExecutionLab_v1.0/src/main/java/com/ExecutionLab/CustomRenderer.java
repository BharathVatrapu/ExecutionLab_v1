package com.ExecutionLab;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by BhaRatH on 18-06-2017.
 */
public class CustomRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row,int column)
    {
        Component c = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        String a = value.toString();
        setForeground(a.contains("Passed")?Color.blue:a.contains("Failed")?Color.red:Color.black);
        return c;
    }
}
