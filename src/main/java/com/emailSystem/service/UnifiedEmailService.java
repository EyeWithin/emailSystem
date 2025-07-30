package com.emailSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.emailSystem.dto.UnifiedEmailRequest;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;

import java.util.HashMap;
import java.util.Map;

@Service
public class UnifiedEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration freemarkerConfig;

    public void sendUnifiedEmail(UnifiedEmailRequest request) throws Exception {
        switch (request.type) {
            case SIMPLE:
                sendSimpleEmail(request);
                break;
            case TEMPLATE:
                sendTemplateEmail(request);
                break;
            case PROMOTIONAL:
                sendPromotionalEmail(request);
                break;
            default:
                throw new IllegalArgumentException("Unsupported email type: " + request.type);
        }
    }

    private void sendSimpleEmail(UnifiedEmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.to);
        message.setSubject(request.subject);
        message.setText(request.body);
        mailSender.send(message);
    }

    private void sendTemplateEmail(UnifiedEmailRequest request) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        Map<String, Object> model = new HashMap<>();
        model.put("name", request.name);
        model.put("headerText", request.headerText);
        model.put("mainContent", request.mainContent);
        model.put("footerText", request.footerText);
        model.put("includeButton", request.includeButton);
        model.put("buttonText", request.buttonText);
        model.put("buttonLink", request.buttonLink);

        Template template = freemarkerConfig.getTemplate("email-template.html");
        String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        helper.setTo(request.to);
        helper.setSubject(request.headerText);
        helper.setText(htmlContent, true);

        mailSender.send(message);
    }

    private void sendPromotionalEmail(UnifiedEmailRequest request) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        Map<String, Object> model = new HashMap<>();
        // Common fields
        model.put("name", request.name);
        model.put("headerText", request.headerText);
        model.put("mainContent", request.mainContent);
        model.put("footerText", request.footerText);
        
        // Promotional specific content
        model.put("includeFeatures", request.includeFeatures);
        model.put("features", request.features);
        model.put("includePrice", request.includePrice);
        model.put("price", request.price);
        model.put("includeButton", request.includeButton);
        model.put("buttonText", request.buttonText);
        model.put("buttonLink", request.buttonLink);
        
        // Social links
        model.put("includeSocialLinks", request.includeSocialLinks);
        model.put("facebookLink", request.facebookLink);
        model.put("twitterLink", request.twitterLink);
        model.put("linkedinLink", request.linkedinLink);
        model.put("unsubscribeLink", request.unsubscribeLink);

        Template template = freemarkerConfig.getTemplate("promotional-template.html");
        String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        helper.setTo(request.to);
        helper.setSubject(request.headerText);
        helper.setText(htmlContent, true);

        mailSender.send(message);
    }

	public void sendThankYouEmail(String recipientEmail, String recipientName) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		 Map<String, Object> model = new HashMap<>();
	        model.put("name", recipientName);
	        
		Template template = freemarkerConfig.getTemplate("showInterent.html");
        String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
		
		
		helper.setTo(recipientEmail);
		helper.setSubject("Thank You!");
        helper.setText(htmlContent, true);
        
        mailSender.send(message);
		
	}
}