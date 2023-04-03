package org.capgemini.proyecto2.service;

import java.util.List;

import org.capgemini.proyecto2.model.Event;
import org.capgemini.proyecto2.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

}
