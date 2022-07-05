package com.example.userservice.service;

import com.example.userservice.VO.Deparment;
import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user= userRepository.findByUserId(userId);
        Deparment deparment=
                restTemplate
                        //.getForObject("http://localhost:9192/departments/"+user.getDepartmentId(),
                        .getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                                Deparment.class);
        vo.setUser(user);
        vo.setDepartment(deparment);
        return vo;


    }
}
