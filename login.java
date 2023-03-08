package javaproject;


import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import javaproject.Main;

public class login extends JFrame {
	Main main;

	JLabel la_id; 
	JLabel la_pw; 
	JTextField t_id; 
	JPasswordField t_pw;
	JButton bt_add;
	JButton bt_login;
	
	LoginKeyAdapter loginKeyAdapter;

	private JPanel contentPane;
	private JLabel la_head;

	public login(Main main) {
		this.main=main;
		Dimension dm = new Dimension(60, 20);
		la_pw = new JLabel("비밀번호");
		t_pw = new JPasswordField(20);
		bt_add = new JButton("\uD68C\uC6D0\uAC00\uC785");
		bt_login = new JButton("로그인");
		la_pw.setPreferredSize(dm);
		JPanel center = new JPanel();
		JPanel north = new JPanel();
		JPanel south = new JPanel();
		la_id = new JLabel("아이디"); 
		center.add(la_id);
		la_id.setPreferredSize(dm);
		t_id = new JTextField(20);
		center.add(t_id);
		center.add(la_pw); 
		center.add(t_pw); 
		south.add(bt_add); 
		south.add(bt_login);
		
		bt_add.addActionListener((e) -> {
			regist();
			setVisible(false);
		});

		bt_login.addActionListener((e) -> {
			logining();
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(center, BorderLayout.CENTER);
		contentPane.add(north, BorderLayout.NORTH);
		
		la_head = new JLabel("\uB85C\uADF8\uC778");
		la_head.setFont(new Font("함초롬돋움", Font.BOLD, 32));
		north.add(la_head);
		contentPane.add(south, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void regist() {
		new writing01(main);
	}
	
	public void logining() {
		String id = t_id.getText();
		String pw = new String(t_pw.getPassword());

		String sql = "select * from member where id=? and pw=?";
		Connection con = main.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int user_num = rs.getInt("id");
				JOptionPane.showMessageDialog(this, "로그인 성공");

				main.userInfo.setData(rs.getString("id"), rs.getString("name"),
						rs.getString("phone"));
				this.setVisible(false);
				new project1(main);
			} else {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 확인해주세요");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			main.closeDB(pstmt, rs);
		}
	}
}
class LoginKeyAdapter extends KeyAdapter {
	login lgi;

	public LoginKeyAdapter(login lgi) {
		this.lgi = lgi;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			lgi.logining();
		}
	}
}
