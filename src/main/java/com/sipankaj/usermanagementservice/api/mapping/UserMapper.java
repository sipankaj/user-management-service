package com.sipankaj.usermanagementservice.api.mapping;

import com.sipankaj.usermanagementservice.api.model.UserRequest;
import com.sipankaj.usermanagementservice.api.model.UserResponse;
import com.sipankaj.usermanagementservice.persistence.dto.Users;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    Users mapUserRequestToUserDTO(UserRequest userRequest);
    UserResponse mapUserDTOToUserResponse(Users users);

}
