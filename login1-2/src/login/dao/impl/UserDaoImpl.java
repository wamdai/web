package login.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import login.dao.UserDao;
import login.domain.Users;
import login.utils.JDBCUtils;

public class UserDaoImpl implements UserDao{
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	//查询单个用户信息
	public Users queryUser(String userName,String password) {
		String sql ="select * from `t_user` where userName=? and password=?";
		
		try {
			return qr.query(sql,new BeanHandler<Users>(Users.class),userName,password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int queryUsername(String userName) {
		String sql ="select * from `t_user` where userName=?";
		Users users=null;
		try {
			users = qr.query(sql, new BeanHandler<Users>(Users.class),userName);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (users!=null) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int queryUserPwd(String userName, String password) {
		String sql ="select * from `t_user` where userName=? and password=?";
		Users users=null;
		try {
			users = qr.query(sql,new BeanHandler<Users>(Users.class),userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if (users!=null) {
				return 1;
			}else {
				return 0;
			}
	}

	
	
}
