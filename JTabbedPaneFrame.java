package javaproject;
import java.util.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javaproject.Main;
public class JTabbedPaneFrame extends JFrame implements ActionListener{ 
	JButton btnn;
public JTabbedPaneFrame() { 
super("국제,국내 유가정보"); 
JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP); 
JPanel jpn1 = new JPanel(); //패널 객체 생성
JPanel jpn2 = new JPanel(); 
JPanel jpn3 = new JPanel(); 
JPanel jpn4 = new JPanel();
bTable jt1 = new bTable();
eTable jt2 = new eTable(); 
fTable jt3 = new fTable(); 
gTable jt4 = new gTable();
JButton btnn=new JButton();
add(btnn);
jpn1.add(jt1); jpn2.add(jt2); jpn3.add(jt3); jpn4.add(jt4); //패널에 테이블 추가
jtp.addTab("국내유가", jpn1); jtp.addTab("국내유가", jpn2); 
jtp.addTab("국제유가", jpn3); jtp.addTab("국제유가", jpn4);//탭팬에 패널 추가
add(jtp, BorderLayout.CENTER);  //프레임(JFrame)에 탭팬 추가
setSize(500, 400); 
setVisible(true); 
btnn.addActionListener(this);
} 
public void actionPerformed(ActionEvent e) {
	if(e.getSource()== btnn){
		pricecf o1 = new pricecf();
		this.setVisible(false);
	}}

public static void main(String[] args) { 
JTabbedPaneFrame jt= new JTabbedPaneFrame(); 
jt.setDefaultCloseOperation(EXIT_ON_CLOSE); }}