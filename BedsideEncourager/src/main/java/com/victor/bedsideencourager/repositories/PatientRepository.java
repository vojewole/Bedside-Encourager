package com.victor.bedsideencourager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.victor.bedsideencourager.models.Patient;


@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
 
 List<Patient> findAll();
 
 Optional<Patient> findByRoomNumber(Double roomNumber);
 
}
