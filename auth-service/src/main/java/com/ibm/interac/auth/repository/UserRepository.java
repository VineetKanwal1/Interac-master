package com.ibm.interac.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.interac.auth.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
