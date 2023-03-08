package javaproject;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;
import javaproject.Main;

import javax.swing.table.DefaultTableModel;

// !! 게시판 메인화면 !!
public class project1 extends JFrame {
	Main main;
	JButton bt_search;
	JButton bt_write;
	JTextField t_input;
	JTable table;
	JPanel p_north;
	JPanel p_south;
	JPanel pp_north1;
	JPanel pp_north2;
	JScrollPane scroll;
	JScrollPane scroll2;
	
	BoardTableModel boardTableModel;
	
	String[] ch2_list = { "작성자", "제목", "내용" };
	Choice ch2 = new Choice();
	String [] cor = {"전체"};
	private final String defaultSql = "SELECT writer, title, content from board b ";
	project1(Main main){
		super("주유소 커뮤니티");
		this.main=main;
		
		boardTableModel = new BoardTableModel();
		
		table=new JTable();
		bt_search=new JButton("검색");
		bt_write=new JButton("글쓰기");
		t_input=new JTextField(35);
		t_input.setPreferredSize(new Dimension(120,30));
		boardTableModel = new BoardTableModel();
		p_north = new JPanel();
		p_north.setLayout(new BorderLayout());
		pp_north1=new JPanel();
		pp_north2=new JPanel();
		p_north.setBackground(new Color(255, 255, 255));

		for (int i = 0; i < ch2_list.length; i++) {
			ch2.add(ch2_list[i]);
		}
		
		pp_north2.add(ch2);
		pp_north2.add(t_input);
		pp_north2.add(bt_search);
		pp_north2.add(bt_write);
		p_north.add(pp_north2,BorderLayout.NORTH);
		
		
		bt_search.setPreferredSize(new Dimension(100, 30));
		bt_write.setFont(new Font("굴림", Font.PLAIN, 15));
		ch2.setPreferredSize(new Dimension(125, 40));
		this.setPreferredSize(new Dimension(800, 600));
		p_north.setPreferredSize(new Dimension(150, 900));
		JTextField t_input_1 = new JTextField(35);
		t_input_1.setPreferredSize(new Dimension(120, 30));
		getContentPane().add(p_north, BorderLayout.NORTH);
		bt_search.setBackground(new Color(000, 204, 000));
		bt_search.setPreferredSize(new Dimension(100, 30));
		table = new JTable();
		scroll = new JScrollPane(table);
		p_south=new JPanel();
		p_north.add(p_south, BorderLayout.CENTER);
		p_south.add(scroll);
		scroll.setPreferredSize(new Dimension(900, 850));
		table.setPreferredSize(new Dimension(700, 447));
		p_south.setPreferredSize(new Dimension(450,900));
		p_south.setPreferredSize(new Dimension(800, 50));
		
		table.setModel(boardTableModel);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table.setRowHeight(35);
		table.updateUI();
		
		bt_search.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			search();
			
			}
		});
		bt_write.setBackground(new Color(255, 255, 255));
		bt_write.setFont(new Font("굴림", Font.PLAIN, 15));
		bt_write.setPreferredSize(new Dimension(100, 30));
		
		bt_write.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			gotowrite();
			setVisible(false);
			}
		});
		setLocationRelativeTo(null);
		this.setVisible(true);
		
		showTable();
		table.setModel(boardTableModel);
		DefaultTableCellRenderer cellCenter = new DefaultTableCellRenderer();
		cellCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer cellRight = new DefaultTableCellRenderer();
		cellRight.setHorizontalAlignment(JLabel.RIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 1003);
		setVisible(true);
	}

	public void gotowrite() {
		new usingcommunity(main);
	}
	
	public int setTableData(String sql, String[] value) {
		int total = 0;
		int col = boardTableModel.columnName.length;
		Connection con = main.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[][] tmpData = null;
		String addOrder = sql + " order by writer desc";

		try {
			pstmt = con.prepareStatement(addOrder, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			if (value != null) {
				for (int i = 0; i < value.length; i++) {
					pstmt.setString(i + 1, value[i]);
				}
			}
			rs = pstmt.executeQuery();

			rs.last();
			total = rs.getRow();
			rs.beforeFirst();
			tmpData = new String[total][col];
			for (int i = 0; i < total; i++) {
				rs.next();
				tmpData[i][0] = rs.getString("writer");
				tmpData[i][1] = rs.getString("title");
				tmpData[i][2] = rs.getString("content");
			}

			boardTableModel.data = tmpData;
			table.updateUI();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			main.closeDB(pstmt, rs);
		}
		return total;
	}

	public void showTable() {
		setTableData(defaultSql, null);
	}

	public void search() {
		String sql = null;
		String[] findWord = { "%" + t_input.getText() + "%" };
		String findCond = ch2.getSelectedItem();
		if (findCond.equals("작성자")) { 
			sql = defaultSql + "where writer like ?";
		} else if (findCond.equals("제목")) { 
			sql = defaultSql + "where title like ?";
		} else if (findCond.equals("내용")) { 
			sql = defaultSql + "where content like ?";
		}

		int result = setTableData(sql, findWord);
		if (result == 0) {
			JOptionPane.showMessageDialog(this,"검색 결과가 없습니다.");
			showTable();
		}
	}

	public class BoardTableModel extends AbstractTableModel {
		String[] columnName = { "작성자", "제목", "내용" };
		String data[][] = new String[1][1];

		public int getColumnCount() {

			return columnName.length;
		}

		public int getRowCount() {

			return data.length;
		}

		public String getColumnName(int col) {

			return columnName[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

	}

}
