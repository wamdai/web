package login.servies.impl;

import java.util.List;

import login.dao.UserDao;
import login.dao.impl.UserDaoImpl;
import login.domain.Users;
import login.servies.UserService;
import login.utils.PageBean;


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
	@Override
	public int addUsers(Users users) {
		
		return ud.addUsers(users);
	}
	@Override
	public int queryEmailname(String email) {
		return ud.queryEmailname(email);
	}
	@Override
	public Integer delUserById(Integer id) {
		return ud.delUserById(id);
	}
	
	@Override
	public Integer selectCount(String userName, String name, String email,
			String shengfen) {
		return ud.selectCount(userName,name,email,shengfen);
	}
	
	@Override
	public PageBean<Users> getPageBean(Integer pageNos, Integer pageSize, String userName, String name, String email,
			String shengfen) {
		//查询总的记录数
		Integer count = ud.selectCount(userName,name,email,shengfen);
		
		//获取pageBean中需要的数据
		PageBean<Users> pb =new PageBean<Users>(pageSize, pageNos, count);
		
		
		pb.setList(ud.FenyeselectAll(pb.getPageNos(), pageSize, userName,name,email,shengfen));
		
		return pb;
	}
	@Override
	public List<Users> selectUserAll() {
		return ud.selectUserAll();
	}
	@Override
	public int delUsersAll(Integer[] sid) {
		return ud.delUsersAll(sid);
	}
	@Override
	public Users findUserByID(Integer sid) {
		return ud.findUserByID(sid);
	}
	@Override
	public int updateUsers(Users users) {
		return ud.updateUsers(users);
	}

}
