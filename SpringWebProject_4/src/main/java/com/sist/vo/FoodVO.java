package com.sist.vo;

import lombok.Data;

@Data
public class FoodVO {
	private int fno,hit;
	private double score;
	private String name,type,theme,address,phone,poster,images,time,parking,content,price,jjimcount,likecount,replycount,rdays;
}
