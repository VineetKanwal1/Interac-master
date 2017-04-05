package com.ibm.interac.service;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ibm.interac.client.AuthServiceClient;
import com.ibm.interac.domain.Payee;
import com.ibm.interac.domain.Transfer;
import com.ibm.interac.domain.User;
import com.ibm.interac.repository.InteracRepository;
import com.ibm.interac.repository.PayeeRepository;

@Service
public class InteracServiceImpl implements InteracService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	

	@Autowired
	private AuthServiceClient authClient;

	@Autowired
	private InteracRepository repository;
	
	@Autowired
	private PayeeRepository payeeRepo;

	@Override
	public Transfer find(String id) {
		
		return repository.findById(id);
	}

	@Override
	public Transfer createTransfer(Transfer transfer) {
		
		String id = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);		
		
		transfer.setId(id);
		
		transfer.setCreatedAt(new Date());
		
		transfer.setState("Pending");
		
		return repository.save(transfer);		
	}

	@Override
	public Payee createPayee(Payee payee) {
		
		return payeeRepo.save(payee);
	}

	@Override
	public void saveChanges(Transfer update) {
		Transfer transfer = repository.findById(update.getId());
		Assert.notNull(transfer, "can't find transfer with ID " + update.getId());
		
		transfer.setState(update.getState());
		transfer.setAmount(update.getAmount());
		
	}

	@Override
	public void createUser(User user) {		
		authClient.createUser(user);;
	}

	
}
