package login.servies;

import java.util.List;

import login.domain.DownLoad;

public interface DownLoadService {
	
	//获取所有数据库数据
	public List<DownLoad> selectAll();
	
	//获取id对应数据库路径数据
	public DownLoad selectById(Integer id);

}
