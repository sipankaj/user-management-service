package com.sipankaj.usermanagementservice.api.controllers;

import com.sipankaj.usermanagementservice.api.mapping.UserMapper;
import com.sipankaj.usermanagementservice.api.model.UserRequest;
import com.sipankaj.usermanagementservice.api.model.UserResponse;
import com.sipankaj.usermanagementservice.persistence.dao.UserRepository;
import com.sipankaj.usermanagementservice.persistence.dto.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping(value="/usermanagement")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);;

    @PostMapping(value="/user")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {

            if(StringUtils.isEmpty(userRequest.getCreatedDate())){
                userRequest.setCreatedDate(new Date());
            }
            Users users = userRepository.save(userMapper.mapUserRequestToUserDTO(userRequest));
           return userMapper.mapUserDTOToUserResponse(users);

    }

    @PutMapping(value="/user")
    public UserResponse updateUser(@RequestBody UserRequest userRequest) {

        if(userRequest.getUserId() == 0 ){
            System.out.println("USER ID is not present");
        }
        Optional<Users> oldUsers = userRepository.findById(userRequest.getUserId());
        oldUsers.ifPresentOrElse(user -> {
            if (userRequest.getAge() != 0) {
                user.setAge(userRequest.getAge());
            }
            if (!StringUtils.isEmpty(userRequest.getFirstName())) {
                user.setFirstName(userRequest.getFirstName());
            }
            if (!StringUtils.isEmpty(userRequest.getLastName())) {
                user.setLastName(userRequest.getLastName());
            }
            if (!StringUtils.isEmpty(userRequest.getEmail())) {
                user.setEmail(userRequest.getEmail());
            }
        },() -> System.out.println("Nothing to update so creating new u"));
        Users updateUser = userRepository.save(oldUsers.get());
        return userMapper.mapUserDTOToUserResponse(updateUser);
    }
}
