package javaproject;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import javaproject.Main;
import java.sql.*;
public class MainUI extends JFrame implements ActionListener { 
	Main main;
	
JButton b1, b2, b3;
MainUI() {
super("주유소 가격비교 어플");
setLayout(null); 
JLabel lb1 = new JLabel("주유소 가격 비교");
lb1.setBounds(0,0,500,80);
lb1.setFont(lb1.getFont().deriveFont(20.0f));
lb1.setOpaque(true);
lb1.setBackground(Color.DARK_GRAY);
lb1.setForeground(Color.white);
lb1.setHorizontalAlignment(JLabel.CENTER);

add(lb1);
b1 = new JButton("주유소 가격 확인");
b1.setBounds(120, 150, 250, 50); 
b2 = new JButton("주유소 커뮤니티");
b2.setBounds(120, 250, 250, 50);
b3 = new JButton("오늘의 유가");
b3.setBounds(120, 350, 250, 50);
add(b1); 
add(b2);
add(b3);
setSize(500, 600); 
setVisible(true); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()== b1){
		pricecf o1 = new pricecf();
		this.setVisible(false);
	}
	if(e.getSource()== b2){
		login log = new login(main);
		this.setVisible(false);
    }
	if(e.getSource()== b3){ 
		JTabbedPaneFrame jf = new JTabbedPaneFrame();
		this.setVisible(false);
	}
}


public static void main(String[] args) {
new MainUI();
}  
}