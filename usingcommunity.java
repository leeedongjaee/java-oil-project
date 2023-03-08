package javaproject;


import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javaproject.Main;

// !! 글쓰기 파일 !!
public class usingcommunity extends JFrame {
	
	public static final int NEW=1;
	public static final int READ=2;
	int writemode;
	int readno;
	Main main;

	private JPanel contentPane;
	private JTextField t_head;
	private JTextField t_write;
	private JButton bt_ok;
	private JTextField t_writer;
	public usingcommunity(Main main) {
		this.main=main;
		
		setBounds(100, 100, 510, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(10, 75));
		panel.setPreferredSize(new Dimension(10, 75));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(100, 100));
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel la_head = new JLabel("\uC81C\uBAA9");
		la_head.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(la_head);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(panel_3, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		t_write = new JTextField();
		panel_1.add(t_write);
		t_write.setColumns(33);
		setContentPane(contentPane);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		JLabel lb_writer = new JLabel("\uC791\uC131\uC790\uBA85");
		panel_5.add(lb_writer);
		
		t_writer = new JTextField();
		panel_5.add(t_writer);
		t_writer.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2, BorderLayout.EAST);
		
		bt_ok = new JButton("\uC791\uC131");
		panel_2.add(bt_ok);
		bt_ok.addActionListener((e)-> {
			logining();
			setVisible(false);
		});
		
		t_head = new JTextField();
		panel_3.add(t_head);
		t_head.setColumns(25);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void logining() {
		Connection con = main.getCon();
		PreparedStatement pstmt = null;
		String writer=t_writer.getText();
		String title = t_head.getText();
		String content = t_write.getText();

		String sql = "insert into board(writer,title,content)";
		sql += " values(?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(this, "작성완료");
			new project1(main);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			main.closeDB(pstmt);
		}
	}
	
}
