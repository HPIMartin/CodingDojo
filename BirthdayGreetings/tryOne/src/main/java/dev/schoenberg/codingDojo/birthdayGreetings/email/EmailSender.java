package dev.schoenberg.codingDojo.birthdayGreetings.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dev.schoenberg.codingDojo.birthdayGreetings.core.Sender;

public class EmailSender implements Sender<Email> {
	private final String smtpHost;
	private final int smtpPort;
	private final String sender;

	public EmailSender(String smtpHost, int smtpPort, String sender) {
		this.smtpHost = smtpHost;
		this.smtpPort = smtpPort;
		this.sender = sender;
	}

	@Override
	public void sendMessage(Email email) {
		try {
			Session session = createMailSession();
			Message msg = constructMessage(email, session);
			Transport.send(msg);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private Message constructMessage(Email email, Session session) throws MessagingException, AddressException {
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(sender));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email.recipient));
		msg.setSubject(email.subject);
		msg.setText(email.body);
		return msg;
	}

	private Session createMailSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", "" + smtpPort);
		return Session.getInstance(props, null);
	}
}
