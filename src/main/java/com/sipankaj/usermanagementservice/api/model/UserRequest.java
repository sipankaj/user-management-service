package com.sipankaj.usermanagementservice.api.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    Long userId;
    String firstName;
    String lastName;
    int age;
    String email;
    Date createdDate;
}
