package login.servies;

import java.util.List;

import login.domain.Users;

public interface UserService {

	//查询单个用户信息
	public Users queryUser(String userName,String password);

	//查询用户名是否存在
	public int queryUsername(String userName);

	//检测用户是否存在
	public int queryUserPwd(String userName, String password);

	//获取数据库路径数据
	public List<Users> selectAll(Integer id);


}
