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

	
	/*@Override
	public Account findByName(String accountName) {
		Assert.hasLength(accountName);
		return repository.findByName(accountName);
	}

	
	@Override
	public Account create(User user) {

		Account existing = repository.findByName(user.getUsername());
		Assert.isNull(existing, "account already exists: " + user.getUsername());

		authClient.createUser(user);

		Saving saving = new Saving();
		saving.setAmount(new BigDecimal(0));
		saving.setCurrency(Currency.getDefault());
		saving.setInterest(new BigDecimal(0));
		saving.setDeposit(false);
		saving.setCapitalization(false);

		Account account = new Account();
		account.setName(user.getUsername());
		account.setLastSeen(new Date());
		account.setSaving(saving);

		repository.save(account);

		log.info("new account has been created: " + account.getName());

		return account;
	}

	
	@Override
	public void saveChanges(String name, Account update) {

		Account account = repository.findByName(name);
		Assert.notNull(account, "can't find account with name " + name);

		account.setIncomes(update.getIncomes());
		account.setExpenses(update.getExpenses());
		account.setSaving(update.getSaving());
		account.setNote(update.getNote());
		account.setLastSeen(new Date());
		repository.save(account);

		log.debug("account {} changes has been saved", name);
	}*/
}
