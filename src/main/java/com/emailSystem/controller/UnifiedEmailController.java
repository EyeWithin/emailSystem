package com.emailSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emailSystem.dto.UnifiedEmailRequest;
import com.emailSystem.service.UnifiedEmailService;

@RestController
@RequestMapping("/api/v2/email")
public class UnifiedEmailController {

    @Autowired
    private UnifiedEmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendUnifiedEmail(@RequestBody UnifiedEmailRequest request) {
        try {
            emailService.sendUnifiedEmail(request);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Failed to send email: " + e.getMessage());
        }
    }
    
    
    @PostMapping("/thankYouEmail/{recipientEmail}/{recipientName}")
    public ResponseEntity<String> sendThankYouEmail(@PathVariable ("recipientEmail") String recipientEmail, @PathVariable("recipientName") String recipientName) {
		try {
			emailService.sendThankYouEmail(recipientEmail, recipientName);
			return ResponseEntity.ok("Thank you email sent successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body("Failed to send thank you email: " + e.getMessage());
		}
	}
    
    
}