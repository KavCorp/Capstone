package com.araxsys.repositories;

import org.springframework.data.repository.CrudRepository;
import com.araxsys.domain.RSVP;

public interface RSVPRepository extends CrudRepository<RSVP, Integer> {
}
