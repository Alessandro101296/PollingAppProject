package io.io.repository;

import io.io.entity.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepo extends CrudRepository<Poll,Long> {
}
