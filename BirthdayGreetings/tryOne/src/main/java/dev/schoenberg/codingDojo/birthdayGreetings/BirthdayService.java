package dev.schoenberg.codingDojo.birthdayGreetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BirthdayService {
	public void sendGreetings(String fileName, XDate xDate, String smtpHost, int smtpPort) {
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			String str = "";
			str = in.readLine(); // skip header
			while ((str = in.readLine()) != null) {
				String[] employeeData = str.split(", ");
				Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
				if (employee.isBirthday(xDate)) {
					String recipient = employee.getEmail();
					String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
					String subject = "Happy Birthday!";
					sendMessage(smtpHost, smtpPort, "sender@here.com", subject, body, recipient);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void sendMessage(String smtpHost, int smtpPort, String sender, String subject, String body,
			String recipient) {
		// Create a mail session
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", "" + smtpPort);
		Session session = Session.getInstance(props, null);

		// Construct the message
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(sender));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			msg.setSubject(subject);
			msg.setText(body);

			// Send the message
			Transport.send(msg);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
