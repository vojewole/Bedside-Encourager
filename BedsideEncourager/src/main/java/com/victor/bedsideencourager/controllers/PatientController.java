package com.victor.bedsideencourager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.victor.bedsideencourager.models.Patient;
import com.victor.bedsideencourager.models.PosterRecipient;
import com.victor.bedsideencourager.models.User;
import com.victor.bedsideencourager.repositories.PatientRepository;
import com.victor.bedsideencourager.services.PatientService;
import com.victor.bedsideencourager.services.PosterRecipientService;
import com.victor.bedsideencourager.services.UserService;

import java.util.List;

import javax.servlet.http.HttpSession;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class PatientController {
	
	@Autowired
	PosterRecipientService posterRecipientService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/patients")
	public String showPatients( Model model, HttpSession session) {
		
		User user = userService.findUser((Long)session.getAttribute("userId"));
		
		model.addAttribute("user", user);
		List <Patient> patients = patientService.allPatients();
	    model.addAttribute("patients", patients);
		return "patients.jsp";
	}
	
	@GetMapping("/patients/new")
	public String addPatients(@ModelAttribute("patient") Patient patient) {
		return "addPatient.jsp";
	}
	
	@PostMapping("/patients/add")
	public String create(@Valid @ModelAttribute("patient") Patient patient, BindingResult result, HttpSession session
						) {
		
		if (patientRepository.findByRoomNumber(patient.getRoomNumber()).isPresent())
	     {
	    	 result.rejectValue("roomNumber", "Room Number", "Another patient occupies this room number already!");

	     }
		if(result.hasErrors()) {
			return "addPatient.jsp";
		}
		else {
		Long userId = (Long)session.getAttribute("userId");
		patientService.createPatient(userId, patient);
		return "redirect:/patients";
		}
	}
	
	@GetMapping("/patients/{patientId}")
	public String displayPatient(@PathVariable Long patientId, Model model, @ModelAttribute("posterRecipient") PosterRecipient posterRecipient) {
		Patient recipient = patientService.findPatient(patientId);
		model.addAttribute("patient", recipient);
		return "wordForPatient.jsp";
	}
	
	@PostMapping("/patients/word")
	public String createDisplayPatient(@Valid @ModelAttribute("posterRecipient") PosterRecipient posterRecipient, BindingResult result, HttpSession session) {
		Long posterId = (Long)session.getAttribute("userId");
		User poster = userService.findUser(posterId);
		Patient recipient = posterRecipient.getRecipient();
		//Long recipientId = patient.getId();
		//PosterRecipient posterRecipient = new PosterRecipient();
		posterRecipientService.createPosterRecipient(posterId, recipient.getId(), posterRecipient);
		//model.addAttribute("posterRecipients", posterRecipient);
		return "redirect:/patients/" + recipient.getId();
	}
	
	@GetMapping("/patients/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Patient patient = patientService.findPatient(id);
		model.addAttribute("patient", patient);
	    return "editPatient.jsp";
	}
	    
	@PutMapping("/patients/{id}")
	public String update(@Valid @ModelAttribute("patient") Patient patient, 
			BindingResult result, HttpSession session) {
		
		if (patientRepository.findByRoomNumber(patient.getRoomNumber()).isPresent())
	     {
	    	 result.rejectValue("roomNumber", "Room Number", "Another patient occupies this room number already!");
	     }
		
		if(result.hasErrors()) {
			System.out.println(result.hasErrors());
			return "editPatient.jsp";
		}
		else {
		Long userId = (Long)session.getAttribute("userId");
		patientService.updatePatient(patient, userId );
		return "redirect:/patients";
		}
	}
	
    @DeleteMapping("/patients/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
    

}
