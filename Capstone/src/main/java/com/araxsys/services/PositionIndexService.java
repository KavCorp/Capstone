package com.araxsys.services;

import java.util.ArrayList;

import com.araxsys.domain.PositionIndex;

public interface PositionIndexService {
	Iterable<PositionIndex> listAllPositionIndexes();
	
	PositionIndex savePositionIndex(PositionIndex positionIndex);
	
	void deletePositionIndex(int positionId);
	
	PositionIndex getPositionIndexById(int positionId);
	
	PositionIndex getPositionIndexByName(String positionName);
	
	ArrayList<PositionIndex> getPositionsByDepartment(String departmentName);

}
