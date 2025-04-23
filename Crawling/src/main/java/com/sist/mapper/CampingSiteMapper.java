package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import com.sist.vo.CampingSiteVO;

public interface CampingSiteMapper {
    @Insert({
        "INSERT INTO camping_site(",
        "contentId, facltNm, lineIntro, intro, allar, insrncAt, trsagntNo, bizrno, ",
        "facltDivNm, mangeDivNm, mgcDiv, manageSttus, hvofBgnde, hvofEnddle, featureNm, induty, lctCl, doNm, sigunguNm, zipcode, ",
        "addr1, addr2, mapX, mapY, direction, tel, homepage, resveUrl, resveCl, manageNmpr, gnrlSiteCo, autoSiteCo, ",
        "glampSiteCo, caravSiteCo, indvdlCaravSiteCo, sitedStnc, siteMg1Width, siteMg2Width, siteMg3Width, ",
        "siteMg1Vrticl, siteMg2Vrticl, siteMg3Vrticl, siteMg1Co, siteMg2Co, siteMg3Co, ",
        "siteBottomCl1, siteBottomCl2, siteBottomCl3, siteBottomCl4, siteBottomCl5, ",
        "tooltip, glampInnerFclty, caravInnerFclty, prmisnDe, operPdCl, operDeCl, ",
        "trlerAcmpnyAt, caravAcmpnyAt, toiletCo, swrmCo, wtrplCo, brazierCl, sbrsCl, sbrsEtc, ",
        "posblFcltyCl, posblFcltyEtc, clturEventAt, clturEvent, exprnProgrmAt, exprnProgrm, ",
        "extshrCo, frprvtWrppCo, frprvtSandCo, fireSensorCo, themaEnvrnCl, eqpmnLendCl, animalCmgCl, tourEraCl, ",
        "firstImageUrl, createdtime, modifiedtime",
        ") VALUES (",
        "#{contentId,jdbcType=VARCHAR}, #{facltNm,jdbcType=VARCHAR}, #{lineIntro,jdbcType=VARCHAR}, #{intro,jdbcType=VARCHAR}, ",
        "#{allar,jdbcType=VARCHAR}, #{insrncAt,jdbcType=VARCHAR}, #{trsagntNo,jdbcType=VARCHAR}, #{bizrno,jdbcType=VARCHAR}, ",
        "#{facltDivNm,jdbcType=VARCHAR}, #{mangeDivNm,jdbcType=VARCHAR}, #{mgcDiv,jdbcType=VARCHAR}, #{manageSttus,jdbcType=VARCHAR}, ",
        "#{hvofBgnde,jdbcType=VARCHAR}, #{hvofEnddle,jdbcType=VARCHAR}, #{featureNm,jdbcType=VARCHAR}, #{induty,jdbcType=VARCHAR}, ",
        "#{lctCl,jdbcType=VARCHAR}, #{doNm,jdbcType=VARCHAR}, #{sigunguNm,jdbcType=VARCHAR}, #{zipcode,jdbcType=VARCHAR}, ",
        "#{addr1,jdbcType=VARCHAR}, #{addr2,jdbcType=VARCHAR}, #{mapX,jdbcType=VARCHAR}, #{mapY,jdbcType=VARCHAR}, ",
        "#{direction,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, #{homepage,jdbcType=VARCHAR}, #{resveUrl,jdbcType=VARCHAR}, ",
        "#{resveCl,jdbcType=VARCHAR}, #{manageNmpr,jdbcType=VARCHAR}, #{gnrlSiteCo,jdbcType=VARCHAR}, #{autoSiteCo,jdbcType=VARCHAR}, ",
        "#{glampSiteCo,jdbcType=VARCHAR}, #{caravSiteCo,jdbcType=VARCHAR}, #{indvdlCaravSiteCo,jdbcType=VARCHAR}, #{sitedStnc,jdbcType=VARCHAR}, ",
        "#{siteMg1Width,jdbcType=VARCHAR}, #{siteMg2Width,jdbcType=VARCHAR}, #{siteMg3Width,jdbcType=VARCHAR}, ",
        "#{siteMg1Vrticl,jdbcType=VARCHAR}, #{siteMg2Vrticl,jdbcType=VARCHAR}, #{siteMg3Vrticl,jdbcType=VARCHAR}, ",
        "#{siteMg1Co,jdbcType=VARCHAR}, #{siteMg2Co,jdbcType=VARCHAR}, #{siteMg3Co,jdbcType=VARCHAR}, ",
        "#{siteBottomCl1,jdbcType=VARCHAR}, #{siteBottomCl2,jdbcType=VARCHAR}, #{siteBottomCl3,jdbcType=VARCHAR}, ",
        "#{siteBottomCl4,jdbcType=VARCHAR}, #{siteBottomCl5,jdbcType=VARCHAR}, ",
        "#{tooltip,jdbcType=VARCHAR}, #{glampInnerFclty,jdbcType=VARCHAR}, #{caravInnerFclty,jdbcType=VARCHAR}, ",
        "#{prmisnDe,jdbcType=VARCHAR}, #{operPdCl,jdbcType=VARCHAR}, #{operDeCl,jdbcType=VARCHAR}, ",
        "#{trlerAcmpnyAt,jdbcType=VARCHAR}, #{caravAcmpnyAt,jdbcType=VARCHAR}, #{toiletCo,jdbcType=VARCHAR}, #{swrmCo,jdbcType=VARCHAR}, ",
        "#{wtrplCo,jdbcType=VARCHAR}, #{brazierCl,jdbcType=VARCHAR}, #{sbrsCl,jdbcType=VARCHAR}, #{sbrsEtc,jdbcType=VARCHAR}, ",
        "#{posblFcltyCl,jdbcType=VARCHAR}, #{posblFcltyEtc,jdbcType=VARCHAR}, #{clturEventAt,jdbcType=VARCHAR}, #{clturEvent,jdbcType=VARCHAR}, ",
        "#{exprnProgrmAt,jdbcType=VARCHAR}, #{exprnProgrm,jdbcType=VARCHAR}, #{extshrCo,jdbcType=VARCHAR}, #{frprvtWrppCo,jdbcType=VARCHAR}, ",
        "#{frprvtSandCo,jdbcType=VARCHAR}, #{fireSensorCo,jdbcType=VARCHAR}, #{themaEnvrnCl,jdbcType=VARCHAR}, #{eqpmnLendCl,jdbcType=VARCHAR}, ",
        "#{animalCmgCl,jdbcType=VARCHAR}, #{tourEraCl,jdbcType=VARCHAR}, #{firstImageUrl,jdbcType=VARCHAR}, ",
        "#{createdtime,jdbcType=VARCHAR}, #{modifiedtime,jdbcType=VARCHAR}",
        ")"
    })
    public void campingInsert(CampingSiteVO vo);
}