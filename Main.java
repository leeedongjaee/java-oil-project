package javaproject;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javaproject.Main;

public class Main {
	private final DBManager dbManager = new DBManager(); 
	public final UserInfo userInfo = new UserInfo(); 
	private String appTitle = "OilManager";

	public void frameClose() {
		dbManager.closeDB();
		System.exit(0);
	}

	public String getTitle() {
		return appTitle;
	}

	public Connection getCon() {
		return dbManager.getCon();
	}

	public void closeDB(PreparedStatement pstmt, ResultSet rs) {
		dbManager.closeDB(pstmt, rs);
	}

	public void closeDB(PreparedStatement pstmt) {
		dbManager.closeDB(pstmt);
	}
	

	public static void main(String[] args) {
		Main main = new Main();
		new login(main);
	}

}