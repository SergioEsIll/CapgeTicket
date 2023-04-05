package org.capgemini.proyecto2.repository;

import org.capgemini.proyecto2.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
