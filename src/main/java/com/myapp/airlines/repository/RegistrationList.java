package com.myapp.airlines.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myapp.airlines.model.Registration;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationList extends JpaRepository<Registration, Integer>{


	Optional<List<Registration>> findByemailId(String EmailId);
}
