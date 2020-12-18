package login.domain;

public class Users {
	private Integer id;
	private String userName;
	private String password;
	private String Name; //中文名
	private String role;  //角色  规定1为管理员  2为普通用户
	private String email;
	private String shengfen;
	private String city;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public Users(Integer id, String userName, String password, String name, String email, String shengfen,
			String city) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.Name = name;
		this.email = email;
		this.shengfen = shengfen;
		this.city = city;
	}


	public Users(Integer id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}


	public Users(Integer id, String userName, String password, String name, String role, String email, String shengfen,
			String city) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		Name = name;
		this.role = role;
		this.email = email;
		this.shengfen = shengfen;
		this.city = city;
	}




	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShengfen() {
		return shengfen;
	}

	public void setShengfen(String shengfen) {
		this.shengfen = shengfen;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	} 

	
	
	

	
	
	

}
