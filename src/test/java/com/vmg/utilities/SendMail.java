package com.vmg.utilities;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.vmg.stepdefinition.LoginSteps;


public class SendMail {

	public Configurator configProps = new Configurator("config.properties");
	public void attachReportsToEmail() throws Exception {

		String strReportsFolder = "cucumber-reports";

		String strZipFilePath = "Results\\"
				+ strReportsFolder + ".Zip";
		Zip.zipFolder(configProps.getProperty("filePath"), strZipFilePath);

		String[] to = { configProps.getProperty("ToAddresses") };
		String[] cc = { configProps.getProperty("ToAddresses") };
		String[] bcc = {};
		sendMail(
				configProps.getProperty("MailUserName"),
				configProps.getProperty("MailpassWord"),
				"smtp.gmail.com",
				"465",
				"true",
				"true",
				true,
				"javax.net.ssl.SSLSocketFactory",
				"false",
				to,
				cc,
				bcc,
				"Hi",
				" ",
				strZipFilePath,
				strReportsFolder + configProps.getProperty("filePath") + ".Zip");
	}

	public boolean sendMail(String userName, String passWord,
			String host, String port, String starttls, String auth,
			boolean debug, String socketFactoryClass, String fallback,
			String[] to, String[] cc, String[] bcc, String subject,
			String text, String attachmentPath, String attachmentName) {
		Properties props = new Properties();
		props.put("mail.smtp.user", userName);
		props.put("mail.smtp.host", host);
		if (!"".equals(port))
			props.put("mail.smtp.port", port);
		if (!"".equals(starttls))
			props.put("mail.smtp.starttls.enable", starttls);
		props.put("mail.smtp.auth", auth);
		if (debug) {
			props.put("mail.smtp.debug", "true");
		} else {
			props.put("mail.smtp.debug", "false");
		}
		if (!"".equals(port))
			props.put("mail.smtp.socketFactory.port", port);
		if (!"".equals(socketFactoryClass))
			props.put("mail.smtp.socketFactory.class", socketFactoryClass);
		if (!"".equals(fallback))
			props.put("mail.smtp.socketFactory.fallback", fallback);
		try
		{
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(debug);
			MimeMessage msg = new MimeMessage(session);
			msg.setSubject(subject);
			BodyPart messageBodyPart1 = new MimeBodyPart();
			String table3 = "Automated mail from Cucumber Team";
			messageBodyPart1.setContent(table3, "text/html");
			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentPath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(attachmentName);
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart1);
			msg.setContent(multipart);
			msg.setFrom(new InternetAddress(configProps.getProperty("ToAddresses")));
			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to[i]));
			}
			for (int i = 0; i < cc.length; i++) {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
						cc[i]));
			}
			for (int i = 0; i < bcc.length; i++) {
				msg.addRecipient(Message.RecipientType.BCC,
						new InternetAddress(bcc[i]));
			}
			msg.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(host, userName, passWord);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			return true;
		}
		catch (Exception mex)
		{
			mex.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) {
		
	}
}
