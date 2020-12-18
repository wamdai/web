package login.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import login.dao.UserDao;
import login.domain.Users;
import login.utils.JDBCUtils;
import login.utils.PageBean;

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

	@Override
	public int addUsers(Users users) {
		String sql ="insert into `t_user` values(?,?,?,?,?,?,?,?);";      
		try {
			return  qr.update(sql,users.getUserName(),users.getPassword(),
					null,users.getName(),null,users.getEmail(),
					users.getShengfen(),users.getCity());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int queryEmailname(String email) {
		String sql ="select * from `t_user` where email=?";
		Users users=null;
		try {
			users = qr.query(sql, new BeanHandler<Users>(Users.class),email);
		
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
	public Integer delUserById(Integer id) {
		String sql="delete from `t_user` where id=?";
		try {
			return qr.update(sql,id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	//查询对应条件的总记录数
	@Override
	public Integer selectCount(String userName, String name, String email, String shengfen) {
		StringBuffer sb =new StringBuffer("select count(1) from `t_user` where 1=1");
		if(userName !=null&&  !userName.trim().equals("")){ 
			sb.append(" and userName like '%"+userName+"%'");
		}
		if(name !=null && !name.trim().equals("")){
			sb.append(" and Name like '%"+name+"%'");
		}
		if(email !=null&& !email.equals("")){
			sb.append(" and email like '%"+email+"%'");
		}
		if(shengfen !=null&& !shengfen.equals("")){
			sb.append(" and shengfen like '%"+shengfen+"%'");
		}
		
		
		String sql =sb.toString();

		try {
			Long l=qr.query(sql, new ScalarHandler<Long>("count(1)"));
			
			return l.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Users> FenyeselectAll(Integer pageNos, Integer pageSize, String userName, String name, String email,
			String shengfen) {
		List<Users> list=null;
		StringBuffer sb =new StringBuffer("select * from `t_user` where 1=1");
		if(userName !=null&&  !userName.trim().equals("")){ 
			sb.append(" and userName like '%"+userName+"%'");
		}
		if(name !=null && !name.trim().equals("")){
			sb.append(" and Name like '%"+name+"%'");
		}
		if(email !=null&& !email.equals("")){
			sb.append(" and email like '%"+email+"%'");
		}
		if(shengfen !=null&& !shengfen.equals("")){
			sb.append(" and shengfen like '%"+shengfen+"%'");
		}
		sb.append(" limit ?,? ");
		
		String sql =sb.toString();
		
		//判断传参是否为null
		try {
			list = qr.query(sql,new BeanListHandler<Users>(Users.class),(pageNos-1)*pageSize,pageSize);
			
			return list; 
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Users> selectUserAll() {
		String sql="select * from `t_user`";
		try {
			return qr.query(sql,new BeanListHandler<Users>(Users.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int delUsersAll(Integer[] sid) {
		StringBuffer sb = new StringBuffer("delete from `t_user` where id in(");
		
		if (sid!=null) {
			for(int i=0; i<sid.length;i++){
				if(i !=sid.length-1){
					sb.append(sid[i]+",");
				}else {
					sb.append(sid[i]+")");
				}
			}
		}
		String sql =sb.toString();
		try {
			return qr.update(sql);
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}

	@Override
	public Users findUserByID(Integer sid) {
		String sql="select * from `t_user` where id=?";
		try {
			return  qr.query(sql,new BeanHandler<Users>(Users.class),sid);
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}

	@Override
	public int updateUsers(Users users) {
		String sql ="update `t_user` set userName=?,password=?,role=?,Name=?,email=?,shengfen=?,city=? where id=?";      
		
		try {
			return  qr.update(sql,users.getUserName(),users.getPassword(),users.getRole(),users.getName(),
					users.getEmail(),users.getShengfen(),users.getCity(),users.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	

	
	
}
