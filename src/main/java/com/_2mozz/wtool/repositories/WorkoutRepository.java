package com._2mozz.wtool.repositories;

import com._2mozz.wtool.domain.Workout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long> {

Iterable<Workout> findAllByProjectLeader(String username);

Workout getById(Long id);

}

