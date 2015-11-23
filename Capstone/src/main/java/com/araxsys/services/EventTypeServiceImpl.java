package com.araxsys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araxsys.domain.EventType;
import com.araxsys.repositories.EventTypeRepository;


@Service
public class EventTypeServiceImpl implements EventTypeService {
	@Autowired
	private EventTypeRepository eventTypeRepository;
	
	@Override
	public Iterable<EventType> listAllEventTypes(){
		return eventTypeRepository.findAll();
	};
	@Override
	public EventType saveEventType(EventType eventType){
		return eventTypeRepository.save(eventType);
	};	
	@Override
	public EventType getEventType(int eventTypeId){
		return eventTypeRepository.findOne(eventTypeId);
	};
	@Override
	public void deleteEventType(int eventTypeId){
		eventTypeRepository.delete(eventTypeId);
	};
	
	
	
	
}
