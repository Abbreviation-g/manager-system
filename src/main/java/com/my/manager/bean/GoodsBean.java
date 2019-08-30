package com.my.manager.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Integer id;

    public String name;

    public double price;

    public int num;
}
