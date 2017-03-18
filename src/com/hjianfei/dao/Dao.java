package com.hjianfei.dao;

import java.util.List;

import org.hibernate.Query;

public interface Dao {

	<T> void save(Object object);
	<T> void merge(Object ojbect);
	<T> void delete(Object object);
	<T> Query getQuery(String hql);
	<T> T find(Class<T> clazz,Object id);
	public <T> List<T> getResult(String hql,int firstIndex,int maxSize);
	
	public int executeSql(String sql);
}
