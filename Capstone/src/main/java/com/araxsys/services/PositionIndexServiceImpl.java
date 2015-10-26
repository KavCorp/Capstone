package com.araxsys.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araxsys.domain.PositionIndex;
import com.araxsys.repositories.PositionIndexRepository;

@Service
public class PositionIndexServiceImpl implements PositionIndexService {
	private PositionIndexRepository positionIndexRepository;
	
	@Autowired
	public void setPositionIndexRepository(PositionIndexRepository positionIndexRepository){
		this.positionIndexRepository = positionIndexRepository;
	}
	
	@Override
	public Iterable<PositionIndex> listAllPositionIndexes(){
		return positionIndexRepository.findAll();
	}
	
	@Override
	public PositionIndex getPositionIndexById(int positionId){
		return positionIndexRepository.findOne(positionId);
	}
	
	@Override
	public PositionIndex savePositionIndex(PositionIndex positionIndex){
		return positionIndexRepository.save(positionIndex);
	}
	
	@Override
	public void deletePositionIndex(int positionId){
		positionIndexRepository.delete(positionId);
	}
	
	@Override
	public PositionIndex getPositionIndexByName(String positionName){
		Iterable<PositionIndex> positionIndexes = positionIndexRepository.findAll();
		PositionIndex match = null;
		boolean flag = false;
		for(PositionIndex positionIndex: positionIndexes){
			if(positionIndex.getPositionName().equals(positionName)){
				flag = true;
				match = positionIndex;
				break;
			}
		}
		if(flag){
			return match;
		}else{
			System.out.println("No matches found for category name: "+positionName);
			return match;
			
		}
	}
}
