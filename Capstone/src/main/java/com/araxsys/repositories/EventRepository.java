package com.araxsys.repositories;

import org.springframework.data.repository.CrudRepository;
import com.araxsys.domain.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {
}
