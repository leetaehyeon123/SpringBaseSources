package com.th.mailSender;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSender {
	@Autowired
	private JavaMailSender javaMailSender;

public void mailSendWithUserKey(String e_mail, String user_id, HttpServletRequest request) {

		
		MimeMessage mail = javaMailSender.createMimeMessage();
		String htmlStr = "<h2>안녕하세요 ~~~ 인증 메일입니다</h2><br><br>" 
				+ "<h3>" + user_id + "님</h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
				+ "<a href='http://localhost:2354/email/page3?id="+user_id+"' target=\"_self\">인증하기</a></p>"
				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
		try {
			mail.setSubject("[본인인증] 인증 메일입니다.", "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(e_mail));
			javaMailSender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 아마존 주소 : http://54.180.117.142/MS/user/key_alter?user_id=
		
	}



}
