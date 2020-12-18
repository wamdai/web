package login.dao;


import java.util.List;

import login.domain.Users;
import login.utils.PageBean;



public interface UserDao {

		//查询单个用户信息
		public Users queryUser(String userName,String password);

		public int queryUsername(String userName);

		public int queryUserPwd(String userName, String password);

		public int addUsers(Users users);

		public int queryEmailname(String email);

		public Integer delUserById(Integer id);

	
		public Integer selectCount(String userName, String name, String email, String shengfen);

		public List<Users> FenyeselectAll(Integer pageNos, Integer pageSize, String userName, String name, String email,
				String shengfen);

		public List<Users> selectUserAll();

		public int delUsersAll(Integer[] sid);

		public Users findUserByID(Integer sid);

		public int updateUsers(Users users);


		
	
}
