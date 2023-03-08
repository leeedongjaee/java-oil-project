package javaproject;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javaproject.Main;
public class oilprice2 extends JFrame implements ActionListener{

    JPanel jp1;
    JButton jbtn1,jbtn2;
    oilprice2(){
        super("������ ����Ȯ��(����)");
        setLayout(new FlowLayout());
        jp1=new JPanel();
        jbtn1 = new JButton("����ȭ��");
        jbtn2 = new JButton("�ڷΰ���");
        
        ImageIcon GS = new ImageIcon("images/GS.jpg"); // ������ �̹��� ũ�� ����
        ImageIcon SK = new ImageIcon("images/SK.png");
        ImageIcon SOIL = new ImageIcon("images/S-OIL.png");
        ImageIcon HYUNDAI = new ImageIcon("images/HYUNDAI.png");
        
        Image GS1 = GS.getImage();
        Image changeImg1 = GS1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon GS2 = new ImageIcon(changeImg1);
        
        Image SK1 = SK.getImage();
        Image changeImg2 = SK1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon SK2 = new ImageIcon(changeImg2);
        
        Image SOIL1 = SOIL.getImage();
        Image changeImg3 = SOIL1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon SOIL2 = new ImageIcon(changeImg3);
        
        Image HYUNDAI1 = HYUNDAI.getImage();
        Image changeImg4 = HYUNDAI1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon HYUNDAI2 = new ImageIcon(changeImg4);
        
        JLabel lb1 = new JLabel("<html><br>* �� ������ Ư�� ������ ������ �����̹Ƿ� ���� �ǸŰ��ݰ� ���̰� ���� �� �ֽ��ϴ�.<br> �湮 �� �����ҿ� ���� Ȯ���� ����帳�ϴ�.</html>");
        lb1.setForeground(Color.red);
        JLabel lb2 = new JLabel(GS2);
        JLabel lb3 = new JLabel(SK2);
        JLabel lb4 = new JLabel(SOIL2);
        JLabel lb5 = new JLabel(HYUNDAI2);
        JLabel lb6 = new JLabel("(GS Į�ؽ�) = ��ȫ�� ");
        JLabel lb7 = new JLabel("(SK ������) = ������ ");
        JLabel lb8 = new JLabel("(S-OIL) = �ʷϻ� ");
        JLabel lb9 = new JLabel("(���� ���Ϲ�ũ) = �Ķ��� ");
        JLabel lb10 = new JLabel("������ġ : ��⵵ �Ⱦ�� ���ȱ� �Ⱦ絿 400-10");
        add(lb10);
        add(jbtn1);
        add(jbtn2);
 
        String[] title={"������ �̸�","��ġ","����","������"}; 
        String[][] data= {
                {"û���","��� �Ⱦ�� ���ȱ� ���ȷ� 114","1698��","O"},
                {"����","��� �Ⱦ�� ���ȱ� �������� 56 (ȣ�赿)","1715��","O"},
                {"������","��� ������ �������� 178(�꺻��)","1725��","O"},
                {"SK KH������ ����","��� �Ⱦ�� ���ȱ� ���̴�� 99 (ȣ�赿)","1725��","O"},
                {"�뼺�����Ǹ�(��) �Ⱦ�����","��� �Ⱦ�� ���ȱ� �ڴ޷� 552 (�Ⱦ絿)","1739��","X"},
                {"(��)����","��� �Ⱦ�� ���ȱ� ��ȭ�� 44 (�Ⱦ絿)","1739��","O"},
                {"����","��� ������ ���ܷ� 278-29","1739��","X"},
                {"�꺻","��� ������ ������ 607(������)","1745��","O"},
                {"��������","��� ������ �꺻�� 323���� 27","1749��","X"},
                {"�����ϾȾ�","��� �Ⱦ�� ���ȱ� ���ȷ� 135","1754��","O"}
                };
        JTable table = new JTable(data, title);

        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane js = new JScrollPane(table, v, h); 
        add(js);
        table.getColumn("������ �̸�").setPreferredWidth(140);
        table.getColumn("��ġ").setPreferredWidth(210);
        table.getColumn("����").setPreferredWidth(40);
        table.getColumn("������").setPreferredWidth(30); 
        add(lb1);
        add(lb2);
        add(lb6);
        add(lb3);
        add(lb7);
        add(lb4);
        add(lb8);
        add(lb5);
        add(lb9);
        setSize(500,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtn1.addActionListener(this);
        jbtn2.addActionListener(this);
        
        TableCellRenderer renderer = new MyRenderer();
        try {
			table.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()== jbtn1){
    		MainUI MU = new MainUI();
    		this.setVisible(false);
    }
    	if(e.getSource()== jbtn2){
    		pricecf cf = new pricecf();
    		this.setVisible(false);
    }
    }

    public static void main(String[] args) {
        new oilprice();
    }
}