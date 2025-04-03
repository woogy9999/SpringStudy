package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.GoodsVO;
/*
 * NO                NOT NULL NUMBER         
GOODS_NAME        NOT NULL VARCHAR2(1000) 
GOODS_SUB                  VARCHAR2(1000) 
GOODS_PRICE       NOT NULL VARCHAR2(50)   
GOODS_DISCOUNT             NUMBER         
GOODS_FIRST_PRICE          VARCHAR2(20)   
GOODS_DELIVERY    NOT NULL VARCHAR2(20)   
GOODS_POSTER               VARCHAR2(260)  
HIT                        NUMBER         
LIKECOUNT                  NUMBER         
REPLYCOUNT                 NUMBER         

 */
public interface GoodsMapper {
	
	
	@Select("SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster,num "
			+ "FROM (SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(goods_all gm_no_pk)*/no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster "
			+ "FROM goods_all )) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
	
	//사이드
	@Select("SELECT * FROM (SELECT * FROM goods_all ORDER BY no DESC) WHERE rownum <= 10")
	public List<GoodsVO> goodsAsideData();
	
	/*
	 * 	<select id="recipeFindData" resultType="com.sist.vo.RecipeVO" parameterType="hashmap">
		SELECT no,poster,title,chef,num
		FROM (SELECT no,poster,title,chef,rownum as num
		FROM (SELECT no,poster,title,chef
		FROM recipe WHERE title LIKE '%'||#{fd}||'%' 
		AND no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)))
		WHERE num BETWEEN #{start} AND #{end}
	</select>
	
	<select id="recipeFindTotalPage" resultType="int" parameterType="hashmap">
		SELECT CEIL(COUNT(*)/12.0) FROM recipe
		WHERE REGEXP_LIKE(title,#{fd})
		AND no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)
	</select>
	 */
	
	@Select("SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster,num "
			+ "FROM (SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery,goods_poster "
			+ "FROM goods_all WHERE goods_name LIKE '%'||#{fd}||'%')) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all "
			+ "WHERE REGEXP_LIKE(goods_name,#{fd})")
	public int goodsFindTotalPage(Map map);
}
