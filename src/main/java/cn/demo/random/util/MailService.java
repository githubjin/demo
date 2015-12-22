package cn.demo.random.util;

import java.util.Locale;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import cn.demo.random.config.AppProperties;
import cn.demo.random.rbac.domain.RbacUser;

@Service
public class MailService {

	private final Logger logger = LoggerFactory.getLogger(MailService.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private AppProperties appProperties;
	
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	@Autowired
	private MessageSource messageSource;
	
	@Async
	public void sendMail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
		logger.debug("Send e-mail[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
				isMultipart, isHtml, to, subject, content);
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, CharEncoding.UTF_8);
			message.setTo(to);
			message.setFrom(appProperties.getMail().getFrom());
			message.setSubject(subject);
			message.setText(content, isHtml);
			mailSender.send(mimeMessage);
			logger.debug("Send e-mail to User '{}'", to);
		} catch (MessagingException e) {
			logger.warn("E-mail could not be sent to user '{}', exception is : {}", to, e.getMessage());
		}
	}
	
	@Async
	public void sendActivatioEmail(RbacUser user, String baseUrl) {
		logger.debug("Sending activation e-mail to '{}'", user.getEmail());
		Locale locale = Locale.forLanguageTag(user.getLangKey());
		Context context = new Context(locale);
		context.setVariable("user", user);
		context.setVariable("baseUrl", baseUrl);
		String content = templateEngine.process("activationEmail", context);
		String subject = messageSource.getMessage("email.activation.title", null, locale);
		sendMail(user.getEmail(), subject, content, false, true);
	}
	
	@Async
	public void sendPasswordResetMail(RbacUser user, String baseUrl) {
		logger.debug("Sending password reset e-mail to '{}'", user.getEmail());
		Locale locale = Locale.forLanguageTag(user.getLangKey());
		Context context = new Context(locale);
		context.setVariable("user", user);
		context.setVariable("baseUrl", baseUrl);
		String content = templateEngine.process("passwordResetEmail", context);
		String subject = messageSource.getMessage("email.reset.title", null, locale);
		sendMail(user.getEmail(), subject, content, false, true);
	}
}
