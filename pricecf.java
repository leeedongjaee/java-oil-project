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
	String[] title= {"기름 종류","휘발유","경유"};
	pricecf() {
		super("주유소 가격 확인");
		setLayout(new FlowLayout());
		jp1=new JPanel();
        jcm1 = new JComboBox(title);
        JLabel lb1 = new JLabel("기름 종류를 선택하세요.");
        add(lb1);
        add(jcm1);
        setSize(500,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jcm1.addActionListener(this);
        }

		public void actionPerformed(ActionEvent e) {
			String jcm = jcm1.getSelectedItem().toString();
			if(jcm == "휘발유") {
				oilprice o1 = new oilprice();
				this.setVisible(false);          
				}
			if(jcm == "경유") {
				oilprice2 o2 = new oilprice2();
				this.setVisible(false);          
				}
		}
        
	public static void main(String[] args) {
		new pricecf();
		}
}
