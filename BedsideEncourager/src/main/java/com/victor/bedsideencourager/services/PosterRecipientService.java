package com.victor.bedsideencourager.services;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.bedsideencourager.models.Patient;
import com.victor.bedsideencourager.models.PosterRecipient;
import com.victor.bedsideencourager.models.User;

import com.victor.bedsideencourager.repositories.PosterRecipientRepository;



@Service
public class PosterRecipientService {

	private final PosterRecipientRepository posterRecipientRepository;
	
	@Autowired
    UserService userService;
	
	@Autowired
	PatientService patientService;
    
    public PosterRecipientService(PosterRecipientRepository posterRecipientRepository) {
        this.posterRecipientRepository = posterRecipientRepository;
    }
    // returns all the people who post
    public List<PosterRecipient> allPosterRecipient() {
        return posterRecipientRepository.findAll();
    }
    // creates a person who is posting
    public PosterRecipient createPosterRecipient(Long userId, Long patientId, PosterRecipient p) {
    	User user = this.userService.findUser(userId);
    	Patient patient = this.patientService.findPatient(patientId);
    	
    	if ( user == null ) return null;
		
		p.setPoster(user);
		p.setRecipient(patient);
		
		return posterRecipientRepository.save(p);
        
    }
    // retrieves a person who is posting
//    public PosterRecipient findPosterRecipient(Long id) {
//        Optional<PosterRecipient> optionalPosterRecipient = posterRecipientRepository.findById(id);
//        if(optionalPosterRecipient.isPresent()) {
//            return optionalPosterRecipient.get();
//        } else {
//            return null;
//        }
//    }
//    
    
//    public PosterRecipient updatePosterRecipient(Long userId, Long patientId, PosterRecipient p) 
//    
//    {
//    	User user = this.userService.findUser(userId);
//    	Patient patient = this.patientService.findPatient(patientId);
//    	if ( user == null ) return null;
//		
//		p.setPoster(user);
//		p.setRecipient(patient);
//    	return posterRecipientRepository.save(p);
//    }
    
    public void deletePosterRecipient(Long id) {
    	posterRecipientRepository.deleteById(id);
    }
    
}


