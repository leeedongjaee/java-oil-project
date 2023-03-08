package javaproject;


import java.util.regex.Pattern;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javaproject.Main;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
// !! 회원 가입 파일 !! 
public class writing01 extends JFrame {
	Main main;

	private JPanel contentPane;

	JLabel la_id;
	JTextField t_id;
	JLabel la_name;
	JTextField t_name;
	JLabel la_pw;
	JPasswordField t_pw;
	JLabel la_phone;
	JTextField t_phone;
	
	JPanel center;
	JPanel west;
	JPanel east;
	JPanel south;
	
	JButton bt_check;
	JButton bt_ok;
	
	boolean idChecked = false; 
	boolean flag = true;
	
	public writing01(Main main) {
		this.main=main;
		la_id=new JLabel();
		la_id.setHorizontalAlignment(SwingConstants.CENTER);
		la_id.setFont(new Font("굴림", Font.BOLD, 15));
		la_id.setText("\uC544\uC774\uB514");
		la_name=new JLabel();
		la_name.setHorizontalAlignment(SwingConstants.CENTER);
		la_name.setFont(new Font("굴림", Font.BOLD, 15));
		la_name.setText("\uC774\uB984");
		la_pw=new JLabel();
		la_pw.setHorizontalAlignment(SwingConstants.CENTER);
		la_pw.setFont(new Font("굴림", Font.BOLD, 15));
		la_pw.setText("\uBE44\uBC00\uBC88\uD638");
		la_phone=new JLabel();
		la_phone.setHorizontalAlignment(SwingConstants.CENTER);
		la_phone.setFont(new Font("굴림", Font.BOLD, 15));
		la_phone.setText("\uC804\uD654\uBC88\uD638");
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Dimension la_dm = new Dimension(100, 22);
		la_id.setPreferredSize(la_dm);
		la_name.setPreferredSize(la_dm);
		la_pw.setPreferredSize(la_dm);
		la_phone.setPreferredSize(la_dm);
		
		t_id = new JTextField(15);
		t_id.setBackground(new Color(255, 255, 255));
		t_id.setPreferredSize(new Dimension(172, 21));
		t_name = new JTextField(15);
		t_pw = new JPasswordField(15);
		t_phone = new JTextField(15);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		center = new JPanel();
		center.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		center.setBackground(new Color(240, 240, 240));
		contentPane.add(center, BorderLayout.CENTER);
		
		west = new JPanel();
		west.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		west.setBackground(new Color(240, 240, 240));
		west.setPreferredSize(new Dimension(120, 300));
		contentPane.add(west, BorderLayout.WEST);
		
		east = new JPanel();
		east.setBackground(new Color(240, 240, 240));
		east.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(east, BorderLayout.EAST);
		
		bt_check = new JButton("\uC911\uBCF5 \uCCB4\uD06C");
		east.add(bt_check);
		
		bt_check.addActionListener((e) -> {
			checkId();
		});
		
		south = new JPanel();
		south.setBackground(new Color(240, 240, 240));
		contentPane.add(south, BorderLayout.SOUTH);
		bt_ok = new JButton("\uB4F1\uB85D\uD558\uAE30");
		south.add(bt_ok);
		
		bt_ok.addActionListener((e) -> {
			regist();
		});
		
		west.add(la_id);
		center.add(t_id);
		
		west.add(la_name);
		center.add(t_name);
		
		west.add(la_pw);
		center.add(t_pw);
		
		west.add(la_phone);
		center.add(t_phone);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 628);
		setVisible(true);

	}
	public void regist() {
		if (idChecked == false) { 
			t_id.requestFocus();
			JOptionPane.showMessageDialog(this, "아이디 중복체크 하지않음");
			return;
		}

		String id = t_id.getText();
		String name = t_name.getText();
		String pw = new String(t_pw.getPassword());
		String phone = t_phone.getText();

		if (name.length() == 0) {
			JOptionPane.showMessageDialog(this, "이름을 입력하세요");
			t_name.requestFocus();
			return;
		}

		if (pw.length() == 0) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
			t_pw.requestFocus();
			return;
		}

		if (phone.length()==0) {
			JOptionPane.showMessageDialog(this, "전화번호를 입력하세요");
			t_phone.requestFocus();
			return;
		}
		
		String sql = "insert into member(id,name,pw,phone) values(?,?,?,?)";

		Connection con = main.getCon();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pw);
			pstmt.setString(4, phone);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				JOptionPane.showMessageDialog(this, "가입실패");
			} else {
				JOptionPane.showMessageDialog(this, "가입성공");
				flag = false;
				setVisible(flag);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			main.closeDB(pstmt);
		}
	}

	public void checkId() {

		String id = t_id.getText();
		String sql = "select * from member where id=?";
		Connection con = main.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(this, "이미 사용중인 아이디입니다");
			}
			else if (id.length() >= 3 && Pattern.matches("^[a-z0-9_]{3,12}$", t_id.getText())) {
				idChecked = true;
				JOptionPane.showMessageDialog(this, "사용 가능한 아이디입니다");
				t_id.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(this, "아이디는 영문 또는 영문 숫자 포함 3글자이상 입력하세요");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			main.closeDB(pstmt, rs);
		}
	}
}
