package com.hjianfei.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hibernate.Query;

import com.hjianfei.entity.User;


public interface UserService {

	<T> void save(User user, File file, String filePath);
	
	<T> void save(User user);

	<T> void merge(User user, File file);

	<T> void delete(Class<T> clazz, Object id);

	<T> Query getQuery(String hql);

	<T> T find(Class<T> clazz, Object id);

	public <T> List<T> getResult(String hql, int firstIndex, int maxSize);

	// 保存附件
	String saveFile(File file, User user) throws IOException;
}
