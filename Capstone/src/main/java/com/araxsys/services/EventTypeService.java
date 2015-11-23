package com.araxsys.services;

import java.util.ArrayList;

import com.araxsys.domain.EventType;

public interface EventTypeService {
	Iterable<EventType> listAllEventTypes();
		
	EventType saveEventType(EventType eventType);	
	
	EventType getEventType(int eventTypeId);
	
	void deleteEventType(int eventTypeId);
}
