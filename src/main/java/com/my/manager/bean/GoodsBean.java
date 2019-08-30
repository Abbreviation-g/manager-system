package com.my.manager.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsBean implements Serializable {

    public Integer id;

    public String name;

    public double price;

    public int num;
}
