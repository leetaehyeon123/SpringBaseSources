package com.th.kakao;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class KakaoController {

	private String clientId = "60b8f3fc77f6786e704b5364ee6fc210"/*"나의 앱 키 입력"*/;
	private String LoginRedirectUri = "http://localhost:7984/kakao/page2.do"/*"리다이렉트 주소입력"*/;
	private String LogoutRedirectUrl="http://localhost:7984/kakao/logout";

  public String getLoginUrl(HttpSession session) {//카카오 로그인  페이지 url을 만든다.
    String kakaoUrl = "https://kauth.kakao.com/oauth/authorize?"
        + "client_id=" + clientId + "&redirect_uri="
        + LoginRedirectUri + "&response_type=code";
    return kakaoUrl;
  }
  
  public String getLogoutUrl() {//카카오 로그아웃 페이지 url을 만든다.
	  String URL="https://kauth.kakao.com/oauth/logout";
	  String logoutUrl="";
	  logoutUrl=URL+"?client_id="+clientId+"&logout_redirect_uri="+LogoutRedirectUrl;
	
	    return logoutUrl;
  }

  public  String getAccessToken(String autorize_code) {//코드를 통해서 코큰을 가져올 것이다.
      final String RequestUrl = "https://kauth.kakao.com/oauth/token";//접속할 url
      String param="grant_type=authorization_code&client_id="+clientId+"&redirect_uri="+LoginRedirectUri+"&code="+autorize_code;//POST방식이기에 바디에 담아줄 파라미터값
      JsonNode returnNode = null;
      String access_token="";
      try {  
      URL url = new URL(RequestUrl);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();//HttpURLConnection을 통해 해당 url로 연결을 시도할것이다.
      conn.setRequestMethod("POST");//방식 포스트
      conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
      conn.setDoInput(true);//인풋스트림 사용할거임
      conn.setDoOutput(true);//아웃풋스트림 사용할거임
  
      OutputStreamWriter outputStreamWriter=new OutputStreamWriter(conn.getOutputStream(),"UTF8");//OutputStreamWriter을 통해 위에서 작성했던 파라미터 값을 conn의 바디에 담아버린다.
      outputStreamWriter.write(param);
      outputStreamWriter.flush();
      outputStreamWriter.close();
      
      int responseCode = conn.getResponseCode();
      System.out.println(responseCode);//200이 정상적인 연결
     
         // JSON 형태 반환값 처리
         ObjectMapper mapper = new ObjectMapper();//서버에서 받은 InputStream을 json형태로 바꾸기 위해 생성
         returnNode = mapper.readTree(conn.getInputStream());//바꿔서 JsonNode에 담아줌
         access_token=returnNode.get("access_token").toString();//access_token만 추출
    
      } catch (IOException e) {
         e.printStackTrace();
      }
      return access_token;
   }
   
  public HashMap<String, Object> getUserInfo (String access_Token) {

	    HashMap<String, Object> userInfo = new HashMap<>();//정보를 담아줄 map임
	    String reqURL = "https://kapi.kakao.com/v2/user/me";
	    try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        
	        //    요청에 필요한 Header에 포함될 내용
	        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	        conn.setRequestProperty("Authorization", "Bearer " + access_Token);
	        
	        int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : " + responseCode);
	        
	        ObjectMapper objectMapper=new ObjectMapper();
	        JsonNode jnode=objectMapper.readTree(conn.getInputStream());
        
	        JsonNode properties = jnode.get("properties");
	        JsonNode kakao_account = jnode.get("kakao_account");
	        
	        String nickname = properties.get("nickname").toString();
	        String email = kakao_account.get("email").toString();
	        String birthday = kakao_account.get("birthday").toString();
	        String gender = kakao_account.get("gender").toString();
	        
	        System.out.println("로그인 정보 : "+nickname+ email+birthday+gender);
	        
	        userInfo.put("nickname", nickname);
	        userInfo.put("email", email);
	        userInfo.put("birthday", birthday);
	        userInfo.put("gender", gender);
	        
	        
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return userInfo;
	}

  

}