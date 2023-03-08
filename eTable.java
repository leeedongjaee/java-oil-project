package javaproject;
import javaproject.Main;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
class eTable extends JPanel { 
public eTable() { 
String[] title={"구분","경유","LPG"}; 
String[][] data={{"12/01","1857.18","1021.84"}, 
{"12/02","1855.78","1021.9"}, 
{"12/05","1850.29","1021.95"},
{"12/06","1846.6","1022"},
{"12/07","1841.35","1021.59"},
{"12/08","1834.09","1021.79"},
{"12/09","1825.76","1021.43"},
{"12/12","1806.16","1021.19"},
{"12/13","1795.29","1021.07"},
{"12/14","1778.04","1021.42"}};
JTable table = new JTable(data, title); 
int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
JScrollPane js = new JScrollPane(table, v, h); 
add(js); } }