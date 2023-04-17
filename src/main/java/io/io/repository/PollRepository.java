package io.io.repository;

import io.io.entity.Poll;
import io.io.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PollRepository extends CrudRepository<Poll,Long> {
    Optional<List<Poll>> findByExpirationDateTimeIsLessThan(Date expirationDateTime);
}