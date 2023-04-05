package org.capgemini.proyecto2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.capgemini.proyecto2.model.Event;
import org.capgemini.proyecto2.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventRepositoryTest {

	@Autowired
	private EventRepository eventRepository;

	@Test
	public void event_repository_is_not_null() {
		assertThat(eventRepository).isNotNull();
	}

	@Test
	public void should_create_event() {
		Event event1 = new Event(2, "Coco", "Musical Coco", "El musical que esta dentro del top 10 del mundo",
				new Date(), new Date(), 30, "No utilizar el movil durante el musical", "Sala 3", "Madrid", "Madrid",
				"1", 100);
		Event newEvent = eventRepository.save(event1);
		assertThat(newEvent).isNotNull();
		assertThat(newEvent.getName()).isNotEmpty();
		assertThat(newEvent.getName()).isEqualTo("Coco");

	}

	@Test
	public void should_find_events() {
		List<Event> events = eventRepository.findAll();
		assertThat(events).isNotNull();
	}

}
