package com.marketing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.dao.ManagerRepo;
import com.marketing.dao.ticketsRepo;
import com.marketing.microServices.EducationService;
import com.marketing.models.MarketingManager;
import com.marketing.models.Tickets;

@RestController
@RequestMapping("/marketing")
public class RootController {
	
	@Autowired
	ManagerRepo managerRepo;
	
	@Autowired
	ticketsRepo ticketsRepo;
	
	@Autowired
	EducationService educationService;
	
	@PostMapping("/addManager")
	ResponseEntity<?> addManager(@RequestBody MarketingManager manager)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(managerRepo.save(manager));
		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	@GetMapping("/getManaget/{managerId}")
	ResponseEntity<?> getManager(@PathVariable long managerId)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(managerRepo.getById(managerId));
		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	@GetMapping("/getAllManagers")
	ResponseEntity<?> getAllManagers()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(managerRepo.findAll());

		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	@PostMapping("/addTicket")
	ResponseEntity<?> addTicket(@RequestBody Tickets manager)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(ticketsRepo.save(manager));
		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	@GetMapping("/getTicket/{managerId}")
	ResponseEntity<?> getTicket(@PathVariable long managerId)
	{
		try
		{
			Tickets ticket=ticketsRepo.getById(managerId);
			ticket.setCourseName(educationService.getCourse(ticket.getCourse()).getName());
			ticket.setInsName(educationService.getInstructor(ticket.getInstructor()).getName());
			ticket.setStuName(educationService.getStudent(ticket.getStudent()).getName());
			return ResponseEntity.status(HttpStatus.OK).body(ticket);
		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	@GetMapping("/getAllTicket")
	ResponseEntity<?> getAllTickets()
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(ticketsRepo.findAll());

		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@GetMapping("/assignTicketToManager/{ticketId}/{managerId}")
	ResponseEntity<?> assignTicketTomanager(@PathVariable long ticketId, @PathVariable long managerId)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(ticketsRepo.assignTicket(ticketId,managerId));
		}
		catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	

}
