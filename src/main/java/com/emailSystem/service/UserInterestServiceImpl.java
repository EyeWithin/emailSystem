package com.emailSystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emailSystem.dto.UserInterestDto;
import com.emailSystem.entity.UserInterestEntity;
import com.emailSystem.repository.UserInterestRepository;

@Service
public class UserInterestServiceImpl implements UserInterestService {
	
	
	@Autowired
    private UserInterestRepository userInterestRepository;
	
	

	public List<UserInterestDto> getAllUsers() {
		List<UserInterestEntity> userInterests = userInterestRepository.findAll();
		return userInterests.stream()
				.map(userInterest -> {
					UserInterestDto userInterestDto = new UserInterestDto();
					BeanUtils.copyProperties(userInterest, userInterestDto);
					return userInterestDto;
				})
				.collect(Collectors.toList());
	}

	
//	@Override
//    public List<UserDto> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map(user -> {
//                    UserDto userDto = new UserDto();
//                    BeanUtils.copyProperties(user, userDto);
//                    return userDto;
//                })
//                .collect(Collectors.toList());
//    }
}
