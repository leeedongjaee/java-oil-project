package javaproject;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javaproject.Main;
class fTable extends JPanel { 
public fTable() { 
String[] title={"±¸ºÐ","DUBAI"}; 
String[][] data={{"12/01","81.37"}, 
		{"12/02","80.98"}, 
		{"12/05","80.81"},
		{"12/06","77.97"},
		{"12/07","74.85"},
		{"12/08","73.09"},
		{"12/09","72.05"},
		{"12/12","71.83"},
		{"12/13","75.48"},
		{"12/14","77.66"}};
JTable table = new JTable(data, title); 
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
JScrollPane js = new JScrollPane(table, v, h); 
add(js);
}
}