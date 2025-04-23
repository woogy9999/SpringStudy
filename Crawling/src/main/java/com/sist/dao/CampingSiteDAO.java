package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.CampingSiteMapper;
import com.sist.vo.CampingSiteVO;

@Repository
public class CampingSiteDAO {
    @Autowired
    private CampingSiteMapper mapper;

    public void campingInsert(CampingSiteVO vo) {
        mapper.campingInsert(vo);
    }
}