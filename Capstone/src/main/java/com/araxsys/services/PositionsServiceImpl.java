package com.araxsys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
