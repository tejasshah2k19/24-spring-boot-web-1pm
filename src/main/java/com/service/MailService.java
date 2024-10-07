package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	 
	public void sendWelcomeEmail(String email, String firstName) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("your-email@gmail.com");
		message.setTo(email);
		message.setSubject("Welcome," + firstName);
		message.setText("we are happy to connect with you");

		mailSender.send(message);
	}

	public void sendWelcomeEmailTemplate(String to, String firstName) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

		// Create the HTML content manually
		String htmlContent = "<!DOCTYPE html>" + "<html>" + "<head>"
				+ "    <title>Welcome to Food Panda</title>" + "    <style>"
				+ "        body { font-family: Arial, sans-serif; color: #333; background-color: #f9f9f9; padding: 20px; }"
				+ "        h2 { color: #007bff; }" + "        p { line-height: 1.6; }"
				+ "        .footer { margin-top: 30px; font-size: 0.9em; color: #888; }" + "    </style>" + "</head>"
				+ "<body>" + "    <h2>Welcome to Food Panda, " + firstName + "!</h2>" + "    <p>Hi "
				+ firstName + ",</p>"
				+ "    <p>We’re excited to have you on board! You’ve taken the first step towards [mention your platform/service's goal]. "
				+ "At [Your Company Name], we strive to provide [short pitch about your service/product].</p>"
				+ "    <p>Here are some things you can do next:</p>" + "    <ul>"
				+ "        <li>Explore your <a href=\"#\">dashboard</a> to get familiar with the platform.</li>"
				+ "        <li>Set up your profile to personalize your experience.</li>"
				+ "        <li>Check out our <a href=\"#\">resources</a> to help you get started.</li>" + "    </ul>"
				+ "    <p>If you need any help or have any questions, feel free to reach out to our support team. "
				+ "We’re here to assist you at every step.</p>"
				+ "    <p>Once again, welcome aboard! We can’t wait to see what you accomplish with us.</p>"
				+ "    <p>Best regards,<br>The [Your Company Name] Team</p>" + "    <div class=\"footer\">"
				+ "        <p>&copy; [Current Year] [Your Company Name]. All rights reserved.</p>"
				+ "        <p>Follow us on: " + "            <a href=\"#\">Facebook</a> | "
				+ "            <a href=\"#\">Twitter</a> | " + "            <a href=\"#\">LinkedIn</a>" + "        </p>"
				+ "    </div>" + "</body>" + "</html>";

		// Configure the email details
		helper.setTo(to);
		helper.setSubject("Welcome to Food Panda, " + firstName + "!");
		helper.setText(htmlContent, true); // true indicates that the content is HTML

		// Send the email
		mailSender.send(mimeMessage);
	}
}
