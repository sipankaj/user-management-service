package com.sipankaj.usermanagementservice.persistence.dto;

import lombok.*;

import java.util.Date;
import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(sequenceName = "USERS_SEQ",schema = "C##SIPANKAJ", allocationSize = 1, name = "USERS_SEQ")
    Long userId;
    String firstName;
    String lastName;
    int age;
    String email;
    @Column(name="CREATED_DATE")
    Date createdDate;
}
