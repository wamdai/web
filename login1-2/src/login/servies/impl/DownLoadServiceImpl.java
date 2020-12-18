package login.servies.impl;

import java.util.List;

import login.dao.DownLoadDao;
import login.dao.impl.DownLoadDaoImpl;
import login.domain.DownLoad;
import login.servies.DownLoadService;

public class DownLoadServiceImpl implements DownLoadService{

	private DownLoadDao dd = new DownLoadDaoImpl();
	@Override
	public List<DownLoad> selectAll() {
		return dd.selectAll();
	}
	
	@Override
	public DownLoad selectById(Integer id) {
		return dd.selectById(id);
	}

}
