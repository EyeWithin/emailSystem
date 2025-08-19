package com.emailSystem.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInterestDto {
	
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String interests;
    private Date createdAt;
}
