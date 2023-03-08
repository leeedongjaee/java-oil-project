package javaproject;
import javaproject.Main;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
class gTable extends JPanel { 
public gTable() { 
String[] title={"구분","휘발유","경유"}; 
String[][] data={{"12/01","88.86","119.84"}, 
		{"12/02","87.21","118.42"}, 
		{"12/05","87.27","116.25"},
		{"12/06","84.46","111.31"},
		{"12/07","81.85","107.07"},
		{"12/08","79.98","103.19"},
		{"12/09","78.76","106.54"},
		{"12/12","78.3","103.36"},
		{"12/13","83.77","110.96"},
		{"12/14","81.14","108.72"}};
JTable table = new JTable(data, title); 
int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS; 
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
JScrollPane js = new JScrollPane(table, v, h); 
add(js); } }