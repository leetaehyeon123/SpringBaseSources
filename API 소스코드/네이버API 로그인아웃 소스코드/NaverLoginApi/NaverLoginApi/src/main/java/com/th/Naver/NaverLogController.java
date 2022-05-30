package com.th.Naver;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NaverLogController {

	private String clientId = "wx2pYVRiRw4XXhDt2Kpd";
	private String redirectURI = "http://localhost:4520/Naver/login.do";
	private String clientSecret="JvvHIpv7oy";
	private String state;
	
	NaverLogController(){
	    SecureRandom random = new SecureRandom();
	    state = new BigInteger(130, random).toString();
	}
	
	public String getLoginUrl(){
		String loginUrl="https://nid.naver.com/oauth2.0/authorize?response_type=code"; 

	    loginUrl+="&client_id=" + clientId+ "&redirect_uri=" +redirectURI+ "&state=" + state;

		return loginUrl;
	}
	
	public String getAccessTocken(String code) throws Exception {
		String accessTocken="";
		String tockenUrl="https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
		tockenUrl+="&client_id=" + clientId+ "&code=" + code +"&state=" + state +"&client_secret=" + clientSecret;
		URL url= new URL(tockenUrl);
		
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		int responseCode= con.getResponseCode();
        System.out.println("responseCode : " + responseCode);
        
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jnode=objectMapper.readTree(con.getInputStream());
        
        accessTocken=jnode.get("access_token").toString();
        
		System.out.println(accessTocken);
		return accessTocken;
	}
	
	public Map<String, String> getUserInfo(String accessTocken) throws Exception {
		HashMap< String , String > map =new HashMap<String, String>();
		String userUrl="https://openapi.naver.com/v1/nid/me";
		URL url=new URL(userUrl);
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		con.setRequestProperty("Authorization",  "Bearer "+accessTocken);
		int responseCode= con.getResponseCode();
        System.out.println("responseCode : " + responseCode);
        
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jnode=objectMapper.readTree(con.getInputStream());
        
        System.out.println(jnode);
        
        JsonNode response=jnode.get("response");
        
        String nickname=response.get("nickname").toString().replace("\"", "");
        String profile_image=response.get("profile_image").toString().replace("\"", "");
        String gender= response.get("gender").toString().replace("\"", "");
        String email=response.get("email").toString().replace("\"", "");
        String name=response.get("name").toString().replace("\"", "");
        String birthday=response.get("birthday").toString().replace("\"", "");
        
        map.put("nickname", nickname);
        map.put("profile_image", profile_image);
        map.put("gender", gender);
        map.put("email", email);
        map.put("name", name);
        map.put("birthday",birthday);
        
        
        
		return map;
	}
	
	
	
}
