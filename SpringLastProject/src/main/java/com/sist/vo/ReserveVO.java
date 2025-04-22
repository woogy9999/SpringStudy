package com.sist.vo;

import lombok.Data;
import java.util.*;

// busan_reserve

@Data
public class ReserveVO {
	private int rno,isReserve,fno;
	private String userid,rday,rtime,rinwon,dbday;
	private Date regdate;
	private FoodVO fvo=new FoodVO();
	private MemberVO mvo=new MemberVO();
}
 