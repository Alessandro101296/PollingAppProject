package io.io.repository;

import io.io.entity.Choice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepo extends CrudRepository<Choice,Long> {
}
