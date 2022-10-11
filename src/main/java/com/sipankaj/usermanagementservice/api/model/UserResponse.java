package com.sipankaj.usermanagementservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserResponse {
    int userId;
    String firstName;
    String lastName;
    int age;
    String email;
    Date createdDate;
}
