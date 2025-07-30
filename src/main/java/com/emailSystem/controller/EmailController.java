package com.emailSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emailSystem.dto.EmailRequest;
import com.emailSystem.dto.TemplateEmailRequest;
import com.emailSystem.dto.PromotionalEmailRequest;
import com.emailSystem.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmail(emailRequest);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to send email: " + e.getMessage());
        }
    }

    @PostMapping("/send-template")
    public ResponseEntity<String> sendTemplateEmail(@RequestBody TemplateEmailRequest emailRequest) {
        try {
            emailService.sendTemplateEmail(emailRequest);
            return ResponseEntity.ok("Template email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to send template email: " + e.getMessage());
        }
    }

    @PostMapping("/send-promotional")
    public ResponseEntity<String> sendPromotionalEmail(@RequestBody PromotionalEmailRequest emailRequest) {
        try {
            emailService.sendPromotionalEmail(emailRequest);
            return ResponseEntity.ok("Promotional email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to send promotional email: " + e.getMessage());
        }
    }
}