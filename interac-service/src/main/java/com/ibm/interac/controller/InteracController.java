package com.ibm.interac.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.interac.domain.Transfer;
import com.ibm.interac.domain.User;
import com.ibm.interac.service.InteracService;

@RestController
public class InteracController {

	@Autowired
	private InteracService interacService;

	@PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
	@RequestMapping(path = "/transfer/{id}", method = RequestMethod.GET)
	public Transfer getTransfer(@PathVariable String id) {
		return interacService.find(id);
	}
	

	@RequestMapping(path = "/transfer", method = RequestMethod.POST)
	public Transfer createNewTransfer(@Valid @RequestBody Transfer transfer) {
		return interacService.createTransfer(transfer);		
	}
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public void createNewUser(@Valid @RequestBody User user) {
		interacService.createUser(user);		
	}
}
