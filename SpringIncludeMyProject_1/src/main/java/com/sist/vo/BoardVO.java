package com.sist.vo;
/*
 * NO         NOT NULL NUMBER         
NAME       NOT NULL VARCHAR2(51)   
SUBJECT    NOT NULL VARCHAR2(2000) 
CONTENT    NOT NULL CLOB           
PWD        NOT NULL VARCHAR2(10)   
REGDATE             DATE           
HIT                 NUMBER         
GROUP_ID            NUMBER         
GROUP_STEP          NUMBER         
GROUP_TEB           NUMBER         
ROOT                NUMBER         
DEPTH               NUMBER  
 */
import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
    private int no, hit, group_id, group_step, group_teb, root, depth;
    private String name, subject, content, pwd,dbday;
    private Date regdate;
}