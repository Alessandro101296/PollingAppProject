package io.io.repository;

import io.io.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUsernameOrEmail(String Username,String email);

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
