package dev.schoenberg.codingDojo.birthdayGreetings.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
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
		// Create a mail session
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", "" + smtpPort);
		Session session = Session.getInstance(props, null);

		// Construct the message
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(sender));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email.recipient));
			msg.setSubject(email.subject);
			msg.setText(email.body);

			// Send the message
			Transport.send(msg);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}