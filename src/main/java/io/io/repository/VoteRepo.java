package io.io.repository;

import io.io.entity.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepo extends CrudRepository<Vote,Long> {
}
