package com.araxsys.repositories;

import org.springframework.data.repository.CrudRepository;
import com.araxsys.domain.Positions;
import com.araxsys.domain.PositionsCompositePK;

public interface PositionsRepository extends CrudRepository<Positions, PositionsCompositePK> {

}
