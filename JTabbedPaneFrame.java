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
super("����,���� ��������"); 
JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP); 
JPanel jpn1 = new JPanel(); //�г� ��ü ����
JPanel jpn2 = new JPanel(); 
JPanel jpn3 = new JPanel(); 
JPanel jpn4 = new JPanel();
bTable jt1 = new bTable();
eTable jt2 = new eTable(); 
fTable jt3 = new fTable(); 
gTable jt4 = new gTable();
JButton btnn=new JButton();
add(btnn);
jpn1.add(jt1); jpn2.add(jt2); jpn3.add(jt3); jpn4.add(jt4); //�гο� ���̺� �߰�
jtp.addTab("��������", jpn1); jtp.addTab("��������", jpn2); 
jtp.addTab("��������", jpn3); jtp.addTab("��������", jpn4);//���ҿ� �г� �߰�
add(jtp, BorderLayout.CENTER);  //������(JFrame)�� ���� �߰�
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