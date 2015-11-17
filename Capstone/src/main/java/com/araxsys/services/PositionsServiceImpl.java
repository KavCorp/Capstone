package com.araxsys.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araxsys.domain.PositionIndex;
import com.araxsys.domain.Positions;
import com.araxsys.domain.PositionsCompositePK;
import com.araxsys.repositories.PositionsRepository;

@Service
public class PositionsServiceImpl implements PositionsService{
	private PositionsRepository positionsRepository;
	
	@Autowired
	public void setPositionsRepository(PositionsRepository positionsRepository){
		this.positionsRepository = positionsRepository;
	}
	
	@Override
	public Iterable<Positions> listAllPositions(){
		return positionsRepository.findAll();
	}
	
	@Override
	public Positions getPositionsById(PositionsCompositePK key){
		return positionsRepository.findOne(key);
	}
	
	@Override
	public Positions savePositions(Positions positions){
		return positionsRepository.save(positions);
	}
	
	@Override
	public void deletePositions(PositionsCompositePK key){
		positionsRepository.delete(key);
	}
	
	@Override
	public ArrayList<Positions> getPositionsByDepartment(int departmentId){
		ArrayList<Positions> deptRoster= new ArrayList<>();
		Iterable<Positions> fullRoster= positionsRepository.findAll();
		
		for(Positions positions: fullRoster){
			if(positions.getCompositePK()!=null){
				if(positions.getCompositePK().getDepartmentId() == departmentId){
					deptRoster.add(positions);
				}
			}
		}
		return deptRoster;
	}

}
