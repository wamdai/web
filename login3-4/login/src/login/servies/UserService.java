package login.servies;

import java.util.List;

import login.domain.Users;
import login.utils.PageBean;

public interface UserService {

	//查询单个用户信息
	public Users queryUser(String userName,String password);

	//查询用户名是否存在
	public int queryUsername(String userName);

	//检测用户是否存在
	public int queryUserPwd(String userName, String password);

	//获取数据库路径数据
	public List<Users> selectAll(Integer id);

	//增加学生信息
	public int addUsers(Users users);

	//查询邮箱是否存在
	public int queryEmailname(String email);

	//根据id删除单个用户
	public Integer delUserById(Integer id);
	
	//查询总的记录数
	public Integer selectCount(String userName, String name, String email,
			String shengfen);
	

	//分页＋查询对应的方法  
	public PageBean<Users> getPageBean(Integer pageNos, Integer pageSize, String userName, String name, String email,
			String shengfen);

	//查询所有用户
	public List<Users> selectUserAll();

	//批量删除用户
	public int delUsersAll(Integer[] sid);

	//根据用户传进来的id查询并且进行数据回显
	public Users findUserByID(Integer sid);

	//根据用户传进来的id修改信息
	public int updateUsers(Users users);


}
