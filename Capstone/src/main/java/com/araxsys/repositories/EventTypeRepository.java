package com.araxsys.repositories;

import org.springframework.data.repository.CrudRepository;
import com.araxsys.domain.EventType;

public interface EventTypeRepository extends CrudRepository<EventType, Integer> {
}
