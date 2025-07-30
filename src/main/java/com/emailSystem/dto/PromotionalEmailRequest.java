package com.emailSystem.dto;

import java.util.List;

public class PromotionalEmailRequest {
    public String to;
    public String name;
    public String headerText;
    public String mainContent;
    public boolean includeFeatures;
    public List<String> features;
    public boolean includePrice;
    public String price;
    public boolean includeButton;
    public String buttonText;
    public String buttonLink;
    public String footerText;
    public boolean includeSocialLinks;
    public String facebookLink;
    public String twitterLink;
    public String linkedinLink;
    public String unsubscribeLink;
}