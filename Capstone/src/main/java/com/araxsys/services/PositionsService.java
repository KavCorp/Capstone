package com.araxsys.services;

import com.araxsys.domain.Positions;
import com.araxsys.domain.PositionsCompositePK;

public interface PositionsService {
	Iterable<Positions> listAllPositions();
	
	Positions savePositions(Positions position);
	
	void deletePositions(PositionsCompositePK key);
	
	Positions getPositionsById(PositionsCompositePK key);
	
}
