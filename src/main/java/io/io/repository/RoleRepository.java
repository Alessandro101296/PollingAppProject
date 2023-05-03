package io.io.repository;

import io.io.entity.Role;
import io.io.entity.RoleName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long>{

    Optional<Role> findByName(RoleName name);
}
