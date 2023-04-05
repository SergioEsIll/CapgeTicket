package org.capgemini.proyecto2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.assertj.core.api.SoftAssertions;
import org.capgemini.proyecto2.model.Event;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventEntityTest {

	@Test
	public void check_and_set_attributes_on_event_entity() {

		Event event = new Event(2, "Coco", "Musical Coco", "El musical que esta dentro del top 10 del mundo",
				new Date(), new Date(), 30, "No utilizar el movil durante el musical", "Sala 3", "Madrid", "Madrid",
				"1", 100);

//		assertThat(event.getId()).isEqualTo(2);
//		assertThat(event.getName()).isEqualTo("Coco");
//		assertThat(event.getShortDescription()).isEqualTo("Musical Coco");
//		assertThat(event.getNameRoom()).isEqualTo("Sala 3");

		SoftAssertions softly = new SoftAssertions();

		softly.assertThat(event.getId()).isEqualTo(2);
		softly.assertThat(event.getName()).isEqualTo("Coco");
		softly.assertThat(event.getShortDescription()).isEqualTo("Musical Coco");
		softly.assertThat(event.getNameRoom()).isEqualTo("Sala 3");
		softly.assertAll();

	}

}
