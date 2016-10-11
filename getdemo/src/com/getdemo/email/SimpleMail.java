package com.getdemo.email;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SimpleMail {

	// ���ı���ʽ�����ʼ�
	public static boolean sendTextMail(MailInfo mailInfo) {
		// �ж��Ƿ���Ҫ�����֤
		MyAuthenticator authenticator = null;
		Properties properties = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// �����Ҫ�����֤���򴴽�һ��������֤��
			authenticator = new MyAuthenticator(mailInfo.getUsername(),
					mailInfo.getPassword());
		}

		// �����ʼ��Ự���Ժ�������֤������һ�������ʼ���session
		Session sendMailSession = Session.getDefaultInstance(properties,
				authenticator);
		try {
			Message mailMessage = new MimeMessage(sendMailSession);// ����session����һ���ʼ���Ϣ
			Address from = new InternetAddress(mailInfo.getFromAddress());// �����ʼ������ߵ�ַ
			mailMessage.setFrom(from);// �����ʼ���Ϣ�ķ�����
			Address to = new InternetAddress(mailInfo.getToAddress());// �����ʼ��Ľ����ߵ�ַ
			mailMessage.setRecipient(Message.RecipientType.TO, to);// �����ʼ���Ϣ�Ľ�����
			mailMessage.setSubject(mailInfo.getSubject());// �����ʼ���Ϣ������
			mailMessage.setSentDate(new Date());// �����ʼ���Ϣ���͵�ʱ��
			// mailMessage.setText(mailInfo.getContent());//�����ʼ���Ϣ����Ҫ����

			// MimeMultipart����һ�������࣬����MimeBodyPart���͵Ķ���
			Multipart mainPart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();// ����һ�������������ݵ�MimeBodyPart
			// ����HTML����
			messageBodyPart.setContent(mailInfo.getContent(),
					"text/html; charset=utf-8");
			mainPart.addBodyPart(messageBodyPart);

			// ���ڸ���
			String[] filePaths = mailInfo.getAttachFileNames();
			if (filePaths != null && filePaths.length > 0) {
				for (String filePath : filePaths) {
					messageBodyPart = new MimeBodyPart();
					File file = new File(filePath);
					if (file.exists()) {// �������ڴ�����
						FileDataSource fds = new FileDataSource(file);// �õ�����Դ
						messageBodyPart.setDataHandler(new DataHandler(fds));// �õ�������������BodyPart
						messageBodyPart.setFileName(file.getName());// �õ��ļ���ͬ������BodyPart
						mainPart.addBodyPart(messageBodyPart);
					}
				}
			}

			// ��MimeMultipart��������Ϊ�ʼ�����
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);// �����ʼ�
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// ��HTML��ʽ�����ʼ�
	public static boolean sendHtmlMail(MailInfo mailInfo) {
		// �ж��Ƿ���Ҫ�����֤
		MyAuthenticator authenticator = null;
		Properties properties = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// �����Ҫ�����֤���򴴽�һ��������֤��
			authenticator = new MyAuthenticator(mailInfo.getUsername(),
					mailInfo.getPassword());
		}

		// �����ʼ��Ự���Ժ�������֤������һ�������ʼ���session
		Session sendMailSession = Session.getDefaultInstance(properties,
				authenticator);
		try {
			Message mailMessage = new MimeMessage(sendMailSession);// ����session����һ���ʼ���Ϣ
			Address from = new InternetAddress(mailInfo.getFromAddress());// �����ʼ������ߵ�ַ
			mailMessage.setFrom(from);// �����ʼ���Ϣ�ķ�����
			Address to = new InternetAddress(mailInfo.getToAddress());// �����ʼ��Ľ����ߵ�ַ
			mailMessage.setRecipient(Message.RecipientType.TO, to);// �����ʼ���Ϣ�Ľ�����
			mailMessage.setSubject(mailInfo.getSubject());// �����ʼ���Ϣ������
			mailMessage.setSentDate(new Date());// �����ʼ���Ϣ���͵�ʱ��

			// MimeMultipart����һ�������࣬����MimeBodyPart���͵Ķ���
			Multipart mainPart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();// ����һ������HTML���ݵ�MimeBodyPart
			// ����HTML����
			messageBodyPart.setContent(mailInfo.getContent(),
					"text/html; charset=utf-8");
			mainPart.addBodyPart(messageBodyPart);

			// ���ڸ���
			String[] filePaths = mailInfo.getAttachFileNames();
			if (filePaths != null && filePaths.length > 0) {
				for (String filePath : filePaths) {
					messageBodyPart = new MimeBodyPart();
					File file = new File(filePath);
					if (file.exists()) {// �������ڴ�����
						FileDataSource fds = new FileDataSource(file);// �õ�����Դ
						messageBodyPart.setDataHandler(new DataHandler(fds));// �õ�������������BodyPart
						messageBodyPart.setFileName(file.getName());// �õ��ļ���ͬ������BodyPart
						mainPart.addBodyPart(messageBodyPart);
					}
				}
			}

			// ��MimeMultipart��������Ϊ�ʼ�����
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);// �����ʼ�
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}