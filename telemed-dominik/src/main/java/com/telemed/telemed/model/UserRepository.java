package com.telemed.telemed.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findByType(int type);

    List<User> findByFirstName(String firstName);


    User findByLoginEmailAndLoginPassword(String email, String password);


}
