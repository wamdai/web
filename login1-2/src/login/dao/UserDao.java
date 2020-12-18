package login.dao;


import login.domain.Users;



public interface UserDao {

		//查询单个用户信息
		public Users queryUser(String userName,String password);

		public int queryUsername(String userName);

		public int queryUserPwd(String userName, String password);
		
	
}
