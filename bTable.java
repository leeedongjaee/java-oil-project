package javaproject;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javaproject.Main;
class bTable extends JPanel { 
public bTable() { 
String[] title={"±∏∫–","∞Ì±ﬁ»÷πﬂ¿Ø","»÷πﬂ¿Ø"}; 
String[][] data={{"12/01","1917.43","1621.93"},{"12/02","1916.66","1620.77"},
		{"12/05","1913.07","1615.13"},{"12/06","1910.53","1611.86"},
{"12/07","1908.24","1606.83"},{"12/08","1903.89","1660.33"},
{"12/09","1896.16","1592.81"},{"12/12","1882.65","1575.81"},
{"12/13","1871.8","1566.82"},{"12/14","1858.65","1554.16"}};
JTable table = new JTable(data, title); 
int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
JScrollPane js = new JScrollPane(table, v, h); 
add(js); 
} } 