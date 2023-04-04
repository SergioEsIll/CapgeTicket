package org.capgemini.proyecto2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.capgemini.proyecto2.controller.EventController;
import org.capgemini.proyecto2.model.Event;
import org.capgemini.proyecto2.model.dto.EventDto;
import org.capgemini.proyecto2.repository.EventRepository;
import org.capgemini.proyecto2.service.EventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventControllerTest {

	@InjectMocks
	private EventController eventController;

	@Mock
	private EventServiceImpl eventService;

	@Mock
	private EventRepository eventRepository;

	private Event event;

	@BeforeEach
	public void setup() {
		event = new Event(1, "Rey León", "Musical Rey León", "El musical que esta dentro del top 3 del mundo",
				new Date(), new Date(), 50, "No utilizar el movil durante el musical", "Sala 1", "Madrid", "Madrid",
				"1", 100);
	}

	@Test
	public void event_controller_is_not_null() {
		assertThat(eventController).isNotNull();
	}

	@Test
	public void should_return_event_list_all_mocked() {
		// GIVEN

		Event event1 = new Event(2, "Coco", "Musical Coco", "El musical que esta dentro del top 10 del mundo",
				new Date(), new Date(), 30, "No utilizar el movil durante el musical", "Sala 3", "Madrid", "Madrid",
				"1", 100);

		Mockito.when(eventRepository.findAll()).thenReturn(List.of(event, event1));
		Mockito.when(eventService.findAll()).thenReturn(List.of(event, event1));

		// WHEN
		List<EventDto> eventList = eventController.listEvents();

		// THEN
		assertThat(eventList).isNotNull();
		assertThat(eventList.size()).isEqualTo(2);
		assertThat(eventList.get(0).getName()).isEqualTo("Rey León");
		assertThat(eventList.get(1).getName()).isEqualTo("Coco");
	}

	@Test
	public void should_add_event() {

		// GIVEN

		Event event1 = new Event(2, "Coco", "Musical Coco", "El musical que esta dentro del top 10 del mundo",
				new Date(), new Date(), 30, "No utilizar el movil durante el musical", "Sala 3", "Madrid", "Madrid",
				"1", 100);
		Mockito.when(eventRepository.save(event1)).thenReturn(event1);
		Mockito.when(eventService.save(event1)).thenReturn(event1);

		// WHEN
		EventDto eventDto = eventController.addEvent(event1);

		// THEN
		assertThat(eventDto).isNotNull();
		assertThat(event1.getName()).isNotNull();
		assertThat(event1.getName()).isNotEmpty();
		assertThat(event1.getName()).isEqualTo("Coco");

	}

}
