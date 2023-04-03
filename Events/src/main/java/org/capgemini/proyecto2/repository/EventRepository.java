package org.capgemini.proyecto2.repository;

import org.capgemini.proyecto2.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
