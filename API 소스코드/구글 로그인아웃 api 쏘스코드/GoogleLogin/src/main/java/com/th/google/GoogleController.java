package com.th.google;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GoogleController {
	String c_id="420375394905-l10l1bm0oshs9oogmn90c187d73jl9e6.apps.googleusercontent.com";
	String c_sc="PZmi-g9PwcEsEJNVBTfQwtMa";
	
	
	public String getTocken(String code) throws IOException {
		String accessTocken="";
		String tockenUrl="https://oauth2.googleapis.com/token";
		String param="code="+code+"&client_id="+c_id+"&client_secret="+c_sc+"&redirect_uri=http://localhost:4520/google/login.do&grant_type=authorization_code";
		URL url= new URL(tockenUrl);
		
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
	    con.setDoInput(true);//인풋스트림 사용할거임
	    con.setDoOutput(true);//아웃풋스트림 사용할거임
	
		  OutputStreamWriter outputStreamWriter=new OutputStreamWriter(con.getOutputStream(),"UTF8");//OutputStreamWriter을 통해 위에서 작성했던 파라미터 값을 conn의 바디에 담아버린다.
	      outputStreamWriter.write(param);
	      outputStreamWriter.flush();
	      outputStreamWriter.close();

		
		int responseCode= con.getResponseCode();
        System.out.println("responseCode : " + responseCode);
        
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jnode=objectMapper.readTree(con.getInputStream());
        System.out.println(jnode);
        accessTocken=jnode.get("access_token").toString();
        
		System.out.println(accessTocken);
		return accessTocken;
	
	}
			
	public HashMap<String,String> getUserInfo(String accessTocken) throws Exception {
		HashMap<String, String> map=new HashMap<String, String>();
		String userInfoUrl="https://www.googleapis.com/oauth2/v1/userinfo?access_token="+accessTocken;
		
		URL url=new URL(userInfoUrl);
		
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		
		int responseCode= con.getResponseCode();
        System.out.println("responseCode : " + responseCode);
        
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jnode=objectMapper.readTree(con.getInputStream());
        System.out.println(jnode);
        
        map.put("email", jnode.get("email").toString().replace("\"", ""));
        map.put("picture",jnode.get("picture").toString().replace("\"",""));
        
     
        
		
		
		return map;
	}


}
