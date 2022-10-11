package com.sipankaj.usermanagementservice.persistence.dao;

import com.sipankaj.usermanagementservice.persistence.dto.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {
}
