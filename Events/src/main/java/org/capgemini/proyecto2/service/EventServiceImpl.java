package org.capgemini.proyecto2.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Event save(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Event update(Event event) {
		if(eventRepository.existsById(event.getId())) {
			return eventRepository.save(event);
	}
	return null;
	}

	@Override
	public void deleteById(int id) {
		if(eventRepository.existsById(id)) {
			eventRepository.deleteById(id);;
		}
	}

	@Override
	public Optional<Event> findById(int id) {
		return eventRepository.findById(id);
	}

}
