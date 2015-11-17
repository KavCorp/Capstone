package com.araxsys.services;

import java.util.ArrayList;

import com.araxsys.domain.Positions;
import com.araxsys.domain.PositionsCompositePK;

public interface PositionsService {
	Iterable<Positions> listAllPositions();
	
	Positions savePositions(Positions position);
	
	void deletePositions(PositionsCompositePK key);
	
	Positions getPositionsById(PositionsCompositePK key);
	
	ArrayList<Positions> getPositionsByDepartment(int departmentId);
	
}
