package com.ibm.interac.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.interac.domain.Payee;
import com.ibm.interac.domain.Transfer;


@Repository
public interface PayeeRepository extends CrudRepository<Payee, String> {

	Payee findByPayeeId(String id);
		
}
