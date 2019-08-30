package com.my.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.manager.bean.GoodsBean;
import com.my.manager.mapper.GoodsMapper;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	GoodsMapper goodsMapper;
	
	@Override
	public List<GoodsBean> queryAllGoods() {
		return goodsMapper.queryAllGoods();
	}
	
}
