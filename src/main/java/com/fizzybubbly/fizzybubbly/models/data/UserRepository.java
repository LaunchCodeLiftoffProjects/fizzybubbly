package com.fizzybubbly.fizzybubbly.models.data;

import com.fizzybubbly.fizzybubbly.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}

