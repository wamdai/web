package login.domain;

public class Users {
	private String userName;
	private String password;
	private String chrName; //中文名
	private String role;  //角色  规定1为管理员  2为普通用户
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String userName, String password, String chrName, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.chrName = chrName;
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChrName() {
		return chrName;
	}
	public void setChrName(String chrName) {
		this.chrName = chrName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
	
	

}
