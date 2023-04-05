package org.capgemini.proyecto2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.capgemini.proyecto2.model.Event;
import org.capgemini.proyecto2.repository.EventRepository;
import org.capgemini.proyecto2.service.EventServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventServiceTest {

	@Mock
	private EventRepository eventRepository;

	@InjectMocks
	private EventServiceImpl eventService;

	@Test
	public void event_service_is_not_null() {
		assertThat(eventService).isNotNull();
	}

	@Test
	public void should_create_event() {
		Event event1 = new Event(2, "Coco", "Musical Coco", "El musical que esta dentro del top 10 del mundo",
				new Date(), new Date(), 30, "No utilizar el movil durante el musical", "Sala 3", "Madrid", "Madrid",
				"1", 100);

		Mockito.when(eventRepository.save(event1)).thenReturn(event1);
		Event newEvent = eventService.save(event1);

		assertThat(newEvent).isNotNull();
		assertThat(newEvent.getName()).isNotNull();
		assertThat(newEvent.getName()).isEqualTo("Coco");

	}

	@Test
	public void should_return_event_list() {
		Event event1 = new Event(2, "Coco", "Musical Coco", "El musical que esta dentro del top 10 del mundo",
				new Date(), new Date(), 30, "No utilizar el movil durante el musical", "Sala 3", "Madrid", "Madrid",
				"1", 100);
		Mockito.when(eventRepository.findAll()).thenReturn(List.of(event1));
		List<Event> events = eventService.findAll();

		assertThat(events).isNotNull();
		assertThat(events).isNotEmpty();
		assertThat(events.size()).isEqualTo(1);
		assertThat(events.get(0).getName()).isNotEmpty();
		assertThat(events.get(0).getName()).isEqualTo("Coco");

	}

}
