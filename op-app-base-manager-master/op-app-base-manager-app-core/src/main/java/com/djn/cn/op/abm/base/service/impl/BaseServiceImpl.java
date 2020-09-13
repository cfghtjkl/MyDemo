package com.djn.cn.op.abm.base.service.impl;

import com.djn.cn.op.abm.base.mapper.MyMapper;
import com.djn.cn.op.abm.base.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class BaseServiceImpl<T> implements IBaseService<T> {
	@Autowired
    private MyMapper<T> myMapper;
	@Override
	public T selectByPrimaryKey(Object entityId) {
		return myMapper.selectByPrimaryKey(entityId);
	}

	@Override
	public int delete(T entity) {
		return myMapper.delete(entity);
	}

	@Override
	public int insert(T record) {
		return myMapper.insert(record);
	}

	@Override
	public int insertSelective(T record) {
		return myMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return myMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return myMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<T> selectAll() {
		return myMapper.selectAll();
	}

	@Override
	public List<T> selectByExample(Example example) {
		return myMapper.selectByExample(example);
	}

}
