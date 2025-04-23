package com.sist.manager;
import java.net.URLEncoder;
import java.util.*;

import org.apache.http.impl.execchain.MainClientExec;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import com.sist.vo.*;
@Component
public class YoutubeManager {
	public static void main(String[] args) {
		YoutubeManager y=new YoutubeManager();
		y.youtubeJsonData("부산여행");
	}
	public String youtubeJsonData(String fd) {
		
		String result="";
		try {
		
			String strUrl="https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=25&q="+URLEncoder.encode(fd,"UTF-8")+"&type=video&key=AIza";
			URL url=new URL(strUrl);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			
			
			if(conn!=null)
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }

                in.close();
                conn.disconnect();
                result = sb.toString();
                System.out.println(sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
