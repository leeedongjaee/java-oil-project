package javaproject;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javaproject.Main;
public class pricecf extends JFrame implements ActionListener {
	JComboBox  jcm1;
	JPanel jp1;
	String[] title= {"�⸧ ����","�ֹ���","����"};
	pricecf() {
		super("������ ���� Ȯ��");
		setLayout(new FlowLayout());
		jp1=new JPanel();
        jcm1 = new JComboBox(title);
        JLabel lb1 = new JLabel("�⸧ ������ �����ϼ���.");
        add(lb1);
        add(jcm1);
        setSize(500,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jcm1.addActionListener(this);
        }

		public void actionPerformed(ActionEvent e) {
			String jcm = jcm1.getSelectedItem().toString();
			if(jcm == "�ֹ���") {
				oilprice o1 = new oilprice();
				this.setVisible(false);          
				}
			if(jcm == "����") {
				oilprice2 o2 = new oilprice2();
				this.setVisible(false);          
				}
		}
        
	public static void main(String[] args) {
		new pricecf();
		}
}
