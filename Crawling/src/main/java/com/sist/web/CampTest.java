package com.sist.web;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sist.dao.CampingSiteDAO;
import com.sist.vo.CampingSiteVO;

public class CampTest {
    public static void main(String[] args) {
    	ApplicationContext app = new FileSystemXmlApplicationContext(
    		    "C:/springDev/springStudy/Crawling/src/main/webapp/WEB-INF/config/application-context.xml", 
    		    "C:/springDev/springStudy/Crawling/src/main/webapp/WEB-INF/config/application-dbsource.xml"
    		);
    	CampingSiteDAO dao = (CampingSiteDAO) app.getBean("campingSiteDAO");
        try {
            String serviceKey = "3awQqYqOIfLEJmX7kv5Dn2CvIdZqvyd3ixwvGUoSM21wNSlNW0spnDDq2mOW%2FqroOs6AAvQ%2FuOBeUbxagjW%2FGw%3D%3D";


            for (int page = 1; page <= 9; page++) {
                String urlStr = "https://apis.data.go.kr/B551011/GoCamping/basedList"
                        + "?numOfRows=500&pageNo=" + page
                        + "&MobileOS=WIN&MobileApp=camping"
                        + "&serviceKey=" + serviceKey
                        + "&_type=json";
            Thread.sleep(1000);
            URL url = new URL(urlStr); 
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            br.close();
            conn.disconnect();

            JSONObject json = new JSONObject(sb.toString());
            JSONArray items = json
                    .getJSONObject("response")
                    .getJSONObject("body")
                    .getJSONObject("items")
                    .getJSONArray("item");

//            for (int i = 0; i < items.length(); i++) {
//                JSONObject o = items.getJSONObject(i);
//                System.out.println("[" + (i + 1) + "]");
//                System.out.println("contentId: " + o.optString("contentId"));
//                System.out.println("facltNm: " + o.optString("facltNm"));
//                System.out.println("lineIntro: " + o.optString("lineIntro"));
//                System.out.println("intro: " + o.optString("intro"));
//                System.out.println("allar: " + o.optString("allar"));
//                System.out.println("insrncAt: " + o.optString("insrncAt"));
//                System.out.println("trsagntNo: " + o.optString("trsagntNo"));
//                System.out.println("bizrno: " + o.optString("bizrno"));
//                System.out.println("facltDivNm: " + o.optString("facltDivNm"));
//                System.out.println("mangeDivNm: " + o.optString("mangeDivNm"));
//                System.out.println("mgcDiv: " + o.optString("mgcDiv"));
//                System.out.println("manageSttus: " + o.optString("manageSttus"));
//                System.out.println("hvofBgnde: " + o.optString("hvofBgnde"));
//                System.out.println("hvofEnddle: " + o.optString("hvofEnddle"));
//                System.out.println("featureNm: " + o.optString("featureNm"));
//                System.out.println("induty: " + o.optString("induty"));
//                System.out.println("lctCl: " + o.optString("lctCl"));
//                System.out.println("doNm: " + o.optString("doNm"));
//                System.out.println("sigunguNm: " + o.optString("sigunguNm"));
//                System.out.println("zipcode: " + o.optString("zipcode"));
//                System.out.println("addr1: " + o.optString("addr1"));
//                System.out.println("addr2: " + o.optString("addr2"));
//                System.out.println("mapX: " + o.optString("mapX"));
//                System.out.println("mapY: " + o.optString("mapY"));
//                System.out.println("direction: " + o.optString("direction"));
//                System.out.println("tel: " + o.optString("tel"));
//                System.out.println("homepage: " + o.optString("homepage"));
//                System.out.println("resveUrl: " + o.optString("resveUrl"));
//                System.out.println("resveCl: " + o.optString("resveCl"));
//                System.out.println("manageNmpr: " + o.optString("manageNmpr"));
//                System.out.println("gnrlSiteCo: " + o.optString("gnrlSiteCo"));
//                System.out.println("autoSiteCo: " + o.optString("autoSiteCo"));
//                System.out.println("glampSiteCo: " + o.optString("glampSiteCo"));
//                System.out.println("caravSiteCo: " + o.optString("caravSiteCo"));
//                System.out.println("indvdlCaravSiteCo: " + o.optString("indvdlCaravSiteCo"));
//                System.out.println("sitedStnc: " + o.optString("sitedStnc"));
//                System.out.println("siteMg1Width: " + o.optString("siteMg1Width"));
//                System.out.println("siteMg2Width: " + o.optString("siteMg2Width"));
//                System.out.println("siteMg3Width: " + o.optString("siteMg3Width"));
//                System.out.println("siteMg1Vrticl: " + o.optString("siteMg1Vrticl"));
//                System.out.println("siteMg2Vrticl: " + o.optString("siteMg2Vrticl"));
//                System.out.println("siteMg3Vrticl: " + o.optString("siteMg3Vrticl"));
//                System.out.println("siteMg1Co: " + o.optString("siteMg1Co"));
//                System.out.println("siteMg2Co: " + o.optString("siteMg2Co"));
//                System.out.println("siteMg3Co: " + o.optString("siteMg3Co"));
//                System.out.println("siteBottomCl1: " + o.optString("siteBottomCl1"));
//                System.out.println("siteBottomCl2: " + o.optString("siteBottomCl2"));
//                System.out.println("siteBottomCl3: " + o.optString("siteBottomCl3"));
//                System.out.println("siteBottomCl4: " + o.optString("siteBottomCl4"));
//                System.out.println("siteBottomCl5: " + o.optString("siteBottomCl5"));
//                System.out.println("tooltip: " + o.optString("tooltip"));
//                System.out.println("glampInnerFclty: " + o.optString("glampInnerFclty"));
//                System.out.println("caravInnerFclty: " + o.optString("caravInnerFclty"));
//                System.out.println("prmisnDe: " + o.optString("prmisnDe"));
//                System.out.println("operPdCl: " + o.optString("operPdCl"));
//                System.out.println("operDeCl: " + o.optString("operDeCl"));
//                System.out.println("trlerAcmpnyAt: " + o.optString("trlerAcmpnyAt"));
//                System.out.println("caravAcmpnyAt: " + o.optString("caravAcmpnyAt"));
//                System.out.println("toiletCo: " + o.optString("toiletCo"));
//                System.out.println("swrmCo: " + o.optString("swrmCo"));
//                System.out.println("wtrplCo: " + o.optString("wtrplCo"));
//                System.out.println("brazierCl: " + o.optString("brazierCl"));
//                System.out.println("sbrsCl: " + o.optString("sbrsCl"));
//                System.out.println("sbrsEtc: " + o.optString("sbrsEtc"));
//                System.out.println("posblFcltyCl: " + o.optString("posblFcltyCl"));
//                System.out.println("posblFcltyEtc: " + o.optString("posblFcltyEtc"));
//                System.out.println("clturEventAt: " + o.optString("clturEventAt"));
//                System.out.println("clturEvent: " + o.optString("clturEvent"));
//                System.out.println("exprnProgrmAt: " + o.optString("exprnProgrmAt"));
//                System.out.println("exprnProgrm: " + o.optString("exprnProgrm"));
//                System.out.println("extshrCo: " + o.optString("extshrCo"));
//                System.out.println("frprvtWrppCo: " + o.optString("frprvtWrppCo"));
//                System.out.println("frprvtSandCo: " + o.optString("frprvtSandCo"));
//                System.out.println("fireSensorCo: " + o.optString("fireSensorCo"));
//                System.out.println("themaEnvrnCl: " + o.optString("themaEnvrnCl"));
//                System.out.println("eqpmnLendCl: " + o.optString("eqpmnLendCl"));
//                System.out.println("animalCmgCl: " + o.optString("animalCmgCl"));
//                System.out.println("tourEraCl: " + o.optString("tourEraCl"));
//                System.out.println("firstImageUrl: " + o.optString("firstImageUrl"));
//                System.out.println("createdtime: " + o.optString("createdtime"));
//                System.out.println("modifiedtime: " + o.optString("modifiedtime"));
//                System.out.println("----------------------------");
//            }
            
            for (int i = 0; i < items.length(); i++) {
            	
            	    JSONObject camp = items.getJSONObject(i);
            	    CampingSiteVO vo = new CampingSiteVO();

            	    vo.setContentId(camp.optString("contentId"));
            	    vo.setFacltNm(camp.optString("facltNm"));
            	    vo.setLineIntro(camp.optString("lineIntro"));
            	    vo.setIntro(camp.optString("intro"));
            	    vo.setAllar(camp.optString("allar"));
            	    vo.setInsrncAt(camp.optString("insrncAt"));
            	    vo.setTrsagntNo(camp.optString("trsagntNo"));
            	    vo.setBizrno(camp.optString("bizrno"));
            	    vo.setFacltDivNm(camp.optString("facltDivNm"));
            	    vo.setMangeDivNm(camp.optString("mangeDivNm"));
            	    vo.setMgcDiv(camp.optString("mgcDiv"));
            	    vo.setManageSttus(camp.optString("manageSttus"));
            	    vo.setHvofBgnde(camp.optString("hvofBgnde"));
            	    vo.setHvofEnddle(camp.optString("hvofEnddle"));
            	    vo.setFeatureNm(camp.optString("featureNm"));
            	    vo.setInduty(camp.optString("induty"));
            	    vo.setLctCl(camp.optString("lctCl"));
            	    vo.setDoNm(camp.optString("doNm"));
            	    vo.setSigunguNm(camp.optString("sigunguNm"));
            	    vo.setZipcode(camp.optString("zipcode"));
            	    vo.setAddr1(camp.optString("addr1"));
            	    vo.setAddr2(camp.optString("addr2"));
            	    vo.setMapX(camp.optString("mapX"));
            	    vo.setMapY(camp.optString("mapY"));
            	    vo.setDirection(camp.optString("direction"));
            	    vo.setTel(camp.optString("tel"));
            	    vo.setHomepage(camp.optString("homepage"));
            	    vo.setResveUrl(camp.optString("resveUrl"));
            	    vo.setResveCl(camp.optString("resveCl"));
            	    vo.setManageNmpr(camp.optString("manageNmpr"));
            	    vo.setGnrlSiteCo(camp.optString("gnrlSiteCo"));
            	    vo.setAutoSiteCo(camp.optString("autoSiteCo"));
            	    vo.setGlampSiteCo(camp.optString("glampSiteCo"));
            	    vo.setCaravSiteCo(camp.optString("caravSiteCo"));
            	    vo.setIndvdlCaravSiteCo(camp.optString("indvdlCaravSiteCo"));
            	    vo.setSitedStnc(camp.optString("sitedStnc"));
            	    vo.setSiteMg1Width(camp.optString("siteMg1Width"));
            	    vo.setSiteMg2Width(camp.optString("siteMg2Width"));
            	    vo.setSiteMg3Width(camp.optString("siteMg3Width"));
            	    vo.setSiteMg1Vrticl(camp.optString("siteMg1Vrticl"));
            	    vo.setSiteMg2Vrticl(camp.optString("siteMg2Vrticl"));
            	    vo.setSiteMg3Vrticl(camp.optString("siteMg3Vrticl"));
            	    vo.setSiteMg1Co(camp.optString("siteMg1Co"));
            	    vo.setSiteMg2Co(camp.optString("siteMg2Co"));
            	    vo.setSiteMg3Co(camp.optString("siteMg3Co"));
            	    vo.setSiteBottomCl1(camp.optString("siteBottomCl1"));
            	    vo.setSiteBottomCl2(camp.optString("siteBottomCl2"));
            	    vo.setSiteBottomCl3(camp.optString("siteBottomCl3"));
            	    vo.setSiteBottomCl4(camp.optString("siteBottomCl4"));
            	    vo.setSiteBottomCl5(camp.optString("siteBottomCl5"));
            	    vo.setTooltip(camp.optString("tooltip"));
            	    vo.setGlampInnerFclty(camp.optString("glampInnerFclty"));
            	    vo.setCaravInnerFclty(camp.optString("caravInnerFclty"));
            	    vo.setPrmisnDe(camp.optString("prmisnDe"));
            	    vo.setOperPdCl(camp.optString("operPdCl"));
            	    vo.setOperDeCl(camp.optString("operDeCl"));
            	    vo.setTrlerAcmpnyAt(camp.optString("trlerAcmpnyAt"));
            	    vo.setCaravAcmpnyAt(camp.optString("caravAcmpnyAt"));
            	    vo.setToiletCo(camp.optString("toiletCo"));
            	    vo.setSwrmCo(camp.optString("swrmCo"));
            	    vo.setWtrplCo(camp.optString("wtrplCo"));
            	    vo.setBrazierCl(camp.optString("brazierCl"));
            	    vo.setSbrsCl(camp.optString("sbrsCl"));
            	    vo.setSbrsEtc(camp.optString("sbrsEtc"));
            	    vo.setPosblFcltyCl(camp.optString("posblFcltyCl"));
            	    vo.setPosblFcltyEtc(camp.optString("posblFcltyEtc"));
            	    vo.setClturEventAt(camp.optString("clturEventAt"));
            	    vo.setClturEvent(camp.optString("clturEvent"));
            	    vo.setExprnProgrmAt(camp.optString("exprnProgrmAt"));
            	    vo.setExprnProgrm(camp.optString("exprnProgrm"));
            	    vo.setExtshrCo(camp.optString("extshrCo"));
            	    vo.setFrprvtWrppCo(camp.optString("frprvtWrppCo"));
            	    vo.setFrprvtSandCo(camp.optString("frprvtSandCo"));
            	    vo.setFireSensorCo(camp.optString("fireSensorCo"));
            	    vo.setThemaEnvrnCl(camp.optString("themaEnvrnCl"));
            	    vo.setEqpmnLendCl(camp.optString("eqpmnLendCl"));
            	    vo.setAnimalCmgCl(camp.optString("animalCmgCl"));
            	    vo.setTourEraCl(camp.optString("tourEraCl"));
            	    vo.setFirstImageUrl(camp.optString("firstImageUrl"));
            	    vo.setCreatedtime(camp.optString("createdtime"));
            	    vo.setModifiedtime(camp.optString("modifiedtime"));

            	    dao.campingInsert(vo);
            	    System.out.println("도는중 " + i+"page"+page);
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}