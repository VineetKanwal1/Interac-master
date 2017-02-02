package com.ibm.interac.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.interac.domain.Transfer;


@Repository
public interface InteracRepository extends CrudRepository<Transfer, String> {

	Transfer findById(String id);
		

}
