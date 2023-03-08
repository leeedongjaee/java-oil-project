package javaproject;
import javaproject.Main;
public class UserInfo {
	Main main;
	private String id;
	private String name;
	private String phone;

	public void setData(String id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}