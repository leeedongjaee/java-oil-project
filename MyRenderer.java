package javaproject;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;
import javaproject.Main;
public class MyRenderer extends DefaultTableCellRenderer  
{
    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
          Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          if (!isSelected) {
                 if (column == 0) {
                        cell.setForeground(Color.white);
                        if (value.equals("(주)양지")) {
                              cell.setForeground(Color.MAGENTA);
                        } else if (value.equals("대성유류판매(주) 안양지점")) {
                              cell.setForeground(Color.RED);
                        } else if (value.equals("산본")) {
                              cell.setForeground(Color.RED);
                        } else if (value.equals("구도일안양")) {
                              cell.setForeground(Color.GREEN);
                        }
                          else if (value.equals("서일")) {
                            cell.setForeground(Color.MAGENTA);
                        }
                          else if (value.equals("안양알찬")) {
                              cell.setForeground(Color.GREEN);
                        }
                          else if (value.equals("금정")) {
                              cell.setForeground(Color.RED);
                        }
                          else if (value.equals("시몬")) {
                              cell.setForeground(Color.BLUE);
                        }
                          else if (value.equals("청기와")) {
                              cell.setForeground(Color.BLUE);
                        }
                          else if (value.equals("군포제일")) {
                              cell.setForeground(Color.BLUE);
                        }
                          else if (value.equals("금정역")) {
                              cell.setForeground(Color.RED);
                        }
                          else if (value.equals("SK KH에너지 평촌")) {
                              cell.setForeground(Color.RED);
                        }
                        
                 } else {
                        cell.setBackground(Color.white);
                 }
          }
          return this;
    }
}