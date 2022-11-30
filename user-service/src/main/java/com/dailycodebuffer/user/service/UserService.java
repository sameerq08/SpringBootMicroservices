package com.dailycodebuffer.user.service;
import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public User saveUser(User user) {
        LOGGER.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }



    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        LOGGER.debug("Inside getUserWithDepartment of UserService");
        // Mapping User and Department and respond to get request
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}