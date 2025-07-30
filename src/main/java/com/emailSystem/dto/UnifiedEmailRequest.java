package com.emailSystem.dto;

import java.util.List;

public class UnifiedEmailRequest {
    public EmailType type;
    
    // Common fields
    public String to;
    public String subject;
    public String body;
    
    // Template and Promotional fields
    public String name;
    public String headerText;
    public String mainContent;
    public String footerText;
    public boolean includeButton;
    public String buttonText;
    public String buttonLink;
    
    // Promotional specific fields
    public boolean includeFeatures;
    public List<String> features;
    public boolean includePrice;
    public String price;
    public boolean includeSocialLinks;
    public String facebookLink;
    public String twitterLink;
    public String linkedinLink;
    public String unsubscribeLink;
}