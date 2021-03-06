package com.ibm.interac.service;

import com.ibm.interac.domain.Payee;
import com.ibm.interac.domain.Transfer;
import com.ibm.interac.domain.User;

public interface InteracService {

	/**
	 * Finds transfer request by ID
	 *
	 * @param id
	 * @return found account
	 */
	Transfer find(String id);

	/**	 
	 * Creates new transfer request with state pending
	 *
	 * @param user
	 * @return created account
	 */
	Transfer createTransfer(Transfer transfer);
	
	/**
	 * Create new Payee
	 * @param payee
	 * @return
	 */
	Payee createPayee(Payee payee);

	/**
	 * applies incoming transfer updates
	 *
	 * @param name
	 * @param update
	 */
	void saveChanges(Transfer update);

	/**
	 * Creates a new user using auth-service client
	 * @param user
	 * @return
	 */
	void createUser(User user);
}
