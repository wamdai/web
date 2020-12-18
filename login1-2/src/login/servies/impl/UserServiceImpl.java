package login.servies.impl;

import java.util.List;

import login.dao.UserDao;
import login.dao.impl.UserDaoImpl;
import login.domain.Users;
import login.servies.UserService;


public class UserServiceImpl implements UserService{
	private UserDao ud = new UserDaoImpl();
	@Override
	public Users queryUser(String userName,String password) {	
		return ud.queryUser(userName, password);
	}
	@Override
	public int queryUsername(String userName) {
		return ud.queryUsername(userName);
	}
	@Override
	public int queryUserPwd(String userName, String password) {
		return ud.queryUserPwd(userName,password);
	}
	@Override
	public List<Users> selectAll(Integer id) {
	
		return null;
	}

}
