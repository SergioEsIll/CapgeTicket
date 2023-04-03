package org.capgemini.proyecto2.repository;

import org.capgemini.proyecto2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
