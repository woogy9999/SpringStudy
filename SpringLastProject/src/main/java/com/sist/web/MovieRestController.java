package com.sist.web;


import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.vo.*;
import com.sist.manager.*;
/*
 *   1. JSON 파싱
 *   
 *   
 *   {  "kind": "youtube#searchListResponse",
 *     "etag": "twcbC1DqxqVax4lNvXYP71c7cxA",
 *     "nextPageToken": "CBkQAA",
 *     "regionCode": "KR",
 *     "pageInfo": {    "totalResults": 1000000,    "resultsPerPage": 25  },
 *     "items": [    {      "kind": "youtube#searchResult",
 *     "etag": "aBLTYrW_Arrt54Xmig6jjAFaVog",
 *     "id": {        "kind": "youtube#video",
 *     "videoId": "H141xYAOZbQ"      }, 
 *     "snippet": {        "publishedAt": "2025-02-15T14:07:32Z",
 *     "channelId": "UChtMCwrP0ClxDqMjQFjbH3A", 
 *     "title": "부산 사람들만 아는 부산여행 꿀팁!", 
 *     "description": "", 
 *     "thumbnails": {         
	   "default": {            "url": "https://i.ytimg.com/vi/H141xYAOZbQ/default.jpg",
       "width": 120,            "height": 90          },   
       "medium": {            "url": "https://i.ytimg.com/vi/H141xYAOZbQ/mqdefault.jpg",     
       "width": 320,            "height": 180          },        
       "high": {            "url": "https://i.ytimg.com/vi/H141xYAOZbQ/hqdefault.jpg",      
       "width": 480,            "height": 360          }        },   
       "channelTitle": "오빠 여기!",       
       "liveBroadcastContent": "none",    
       "publishTime": "2025-02-15T14:07:32Z"      }    }, 
                                            
 */
@RestController
public class MovieRestController {
	@Autowired
	private YoutubeManager ym;
	
	@GetMapping("movie/find_vue.do")
	public Map movie_find(String fd)
	{
		Map map=new HashMap();
		// 동영상 제목 /동영상 키
		try {
			String json=ym.youtubeJsonData(fd);
			System.out.println(json);
			JSONParser jp=new JSONParser();
			// { => JSONObject , [ => JsonArray
			JSONObject root=(JSONObject)jp.parse(json);
			JSONArray items=(JSONArray)root.get("items");
			List<MovieVO> list=new ArrayList<MovieVO>();
			for(int i=-0; i<items.size(); i++)
			{
				JSONObject obj=(JSONObject)items.get(i);
				MovieVO vo=new MovieVO();
				JSONObject id=(JSONObject)obj.get("id");
				String key=(String)id.get("videoId");
				JSONObject sni=(JSONObject)obj.get("snippet");
				String title=(String)sni.get("title");
				
				vo.setTitle(title);
				vo.setVideoId(key);
				list.add(vo);
			}
			map.put("list", list);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}
}
