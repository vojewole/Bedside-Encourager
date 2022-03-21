package com.victor.bedsideencourager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.bedsideencourager.models.Patient;
import com.victor.bedsideencourager.models.User;
import com.victor.bedsideencourager.repositories.PatientRepository;



@Service
public class PatientService {

	private final PatientRepository patientRepository;
	
	@Autowired
    UserService userService;
    
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    // returns all the Patients
    public List<Patient> allPatients() {
        return patientRepository.findAll();
    }
    
    public Patient roomNumberCheck(Patient p) {
    	Optional <Patient> foundPatient = this.patientRepository.findByRoomNumber(p.getRoomNumber());
    	return foundPatient.get();
    }
    // creates a patient many to one
    public Patient createPatient(Long userId, Patient p) {
    	User user = this.userService.findUser(userId);
    	
    	if ( user == null ) return null;
    	
		p.setUser(user);
		
		return patientRepository.save(p);
        
    }
    // retrieves a Patient
    public Patient findPatient(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if(optionalPatient.isPresent()) {
            return optionalPatient.get();
        } else {
            return null;
        }
    }
    
    
    public Patient updatePatient(Patient p, Long userId) 
    
    {
    	User user = this.userService.findUser(userId);
    	p.setUser(user);
    	return patientRepository.save(p);
    }
    
    public void deletePatient(Long id) {
    	patientRepository.deleteById(id);
    }
    
}


