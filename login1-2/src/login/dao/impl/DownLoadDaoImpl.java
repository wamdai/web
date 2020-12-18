package login.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import login.dao.DownLoadDao;
import login.domain.DownLoad;
import login.utils.JDBCUtils;

public class DownLoadDaoImpl implements DownLoadDao{

	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	
	@Override
	public List<DownLoad> selectAll() {
		List<DownLoad> list=null;
		String sql ="select * from `t_downloadlist`";
		try {
			list = qr.query(sql, new BeanListHandler<DownLoad>(DownLoad.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public DownLoad selectById(Integer id) {
		String sql ="select * from `t_downloadlist` where id=?";
		DownLoad downLoad=null;
		try {
			downLoad= qr.query(sql, new BeanHandler<DownLoad>(DownLoad.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return downLoad;	
	}

}
