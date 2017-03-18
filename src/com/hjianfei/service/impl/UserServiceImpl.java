package com.hjianfei.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.hjianfei.dao.Dao;
import com.hjianfei.entity.User;
import com.hjianfei.service.UserService;
import com.hjianfei.utils.StringUtil;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Resource(name = "Dao")
	private Dao dao;

	@Override
	public <T> void save(User user, File file, String filePath) {
		// TODO Auto-generated method stub
		if (StringUtil.isNotEmpty(filePath)) { // 保存附件
			String myfilePath = "";
			try {
				myfilePath = saveFile(file, user);
				user.setUser_avatar(myfilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dao.save(user);
	}

	@Override
	public <T> void merge(User user, File file) {
		// TODO Auto-generated method stub
		dao.merge(user);

	}

	@Override
	public <T> void delete(Class<T> clazz, Object id) {
		// TODO Auto-generated method stub
		Object obj = dao.find(clazz, id);
		dao.delete(obj);
	}

	@Override
	public <T> Query getQuery(String hql) {
		// TODO Auto-generated method stub
		return (Query) dao.getQuery(hql);
	}

	@Override
	public <T> T find(Class<T> clazz, Object id) {
		// TODO Auto-generated method stub
		return (T) dao.find(clazz, id);
	}

	@Override
	public <T> List<T> getResult(String hql, int firstIndex, int maxSize) {
		// TODO Auto-generated method stub
		return dao.getResult(hql, firstIndex, maxSize);
	}

	@Override
	public String saveFile(File file, User user) throws IOException {
		// TODO Auto-generated method stub
		// 设置文件路径
		String savePath = ServletActionContext.getServletContext().getRealPath("/user_avatar");
		String filePath = "user_avatar";
		String name = System.currentTimeMillis()+".png";
		// 路径设置
		int user_id = user.getUser_id();
		String uuidName = user_id + name;
		File f = new File(savePath);
		if (!f.exists())
			f.mkdirs();

		// 文件存放
		InputStream in = new FileInputStream(file);
		OutputStream out = new FileOutputStream(new File(savePath, uuidName));
		byte buf[] = new byte[1024];
		int length = 0;
		while ((length = in.read(buf)) > 0) {
			out.write(buf, 0, length);

		}
		in.close();
		out.close();

		// 文件存放路径
		filePath += "/" + uuidName;
		return filePath;
	}

	@Override
	public <T> void save(User user) {
		// TODO Auto-generated method stub
		dao.save(user);

	}

}
