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
        super("주유소 가격확인(경유)");
        setLayout(new FlowLayout());
        jp1=new JPanel();
        jbtn1 = new JButton("메인화면");
        jbtn2 = new JButton("뒤로가기");
        
        ImageIcon GS = new ImageIcon("images/GS.jpg"); // 아이콘 이미지 크기 조절
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
        
        JLabel lb1 = new JLabel("<html><br>* 본 가격은 특정 시점에 수집된 가격이므로 실제 판매가격과 차이가 있을 수 있습니다.<br> 방문 전 주유소에 가격 확인을 권장드립니다.</html>");
        lb1.setForeground(Color.red);
        JLabel lb2 = new JLabel(GS2);
        JLabel lb3 = new JLabel(SK2);
        JLabel lb4 = new JLabel(SOIL2);
        JLabel lb5 = new JLabel(HYUNDAI2);
        JLabel lb6 = new JLabel("(GS 칼텍스) = 분홍색 ");
        JLabel lb7 = new JLabel("(SK 에너지) = 빨강색 ");
        JLabel lb8 = new JLabel("(S-OIL) = 초록색 ");
        JLabel lb9 = new JLabel("(현대 오일뱅크) = 파랑색 ");
        JLabel lb10 = new JLabel("현재위치 : 경기도 안양시 만안구 안양동 400-10");
        add(lb10);
        add(jbtn1);
        add(jbtn2);
 
        String[] title={"주유소 이름","위치","가격","세차장"}; 
        String[][] data= {
                {"청기와","경기 안양시 만안구 만안로 114","1698원","O"},
                {"서일","경기 안양시 동안구 엘에스로 56 (호계동)","1715원","O"},
                {"금정역","경기 군포시 엘에스로 178(산본동)","1725원","O"},
                {"SK KH에너지 평촌","경기 안양시 동안구 평촌대로 99 (호계동)","1725원","O"},
                {"대성유류판매(주) 안양지점","경기 안양시 만안구 박달로 552 (안양동)","1739원","X"},
                {"(주)양지","경기 안양시 만안구 양화로 44 (안양동)","1739원","O"},
                {"금정","경기 군포시 공단로 278-29","1739원","X"},
                {"산본","경기 군포시 번영로 607(금정동)","1745원","O"},
                {"군포제일","경기 군포시 산본로 323번길 27","1749원","X"},
                {"구도일안양","경기 안양시 만안구 만안로 135","1754원","O"}
                };
        JTable table = new JTable(data, title);

        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane js = new JScrollPane(table, v, h); 
        add(js);
        table.getColumn("주유소 이름").setPreferredWidth(140);
        table.getColumn("위치").setPreferredWidth(210);
        table.getColumn("가격").setPreferredWidth(40);
        table.getColumn("세차장").setPreferredWidth(30); 
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