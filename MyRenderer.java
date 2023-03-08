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
                        if (value.equals("(��)����")) {
                              cell.setForeground(Color.MAGENTA);
                        } else if (value.equals("�뼺�����Ǹ�(��) �Ⱦ�����")) {
                              cell.setForeground(Color.RED);
                        } else if (value.equals("�꺻")) {
                              cell.setForeground(Color.RED);
                        } else if (value.equals("�����ϾȾ�")) {
                              cell.setForeground(Color.GREEN);
                        }
                          else if (value.equals("����")) {
                            cell.setForeground(Color.MAGENTA);
                        }
                          else if (value.equals("�Ⱦ����")) {
                              cell.setForeground(Color.GREEN);
                        }
                          else if (value.equals("����")) {
                              cell.setForeground(Color.RED);
                        }
                          else if (value.equals("�ø�")) {
                              cell.setForeground(Color.BLUE);
                        }
                          else if (value.equals("û���")) {
                              cell.setForeground(Color.BLUE);
                        }
                          else if (value.equals("��������")) {
                              cell.setForeground(Color.BLUE);
                        }
                          else if (value.equals("������")) {
                              cell.setForeground(Color.RED);
                        }
                          else if (value.equals("SK KH������ ����")) {
                              cell.setForeground(Color.RED);
                        }
                        
                 } else {
                        cell.setBackground(Color.white);
                 }
          }
          return this;
    }
}