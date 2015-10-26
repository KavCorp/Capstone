package com.araxsys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.araxsys.domain.Event;
import com.araxsys.repositories.EventRepository;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Iterable<Event> listAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

	@Override
	public Event getEventByName(String eventDesc) {
		// TODO Auto-generated method stub
		return null;
	}

}
