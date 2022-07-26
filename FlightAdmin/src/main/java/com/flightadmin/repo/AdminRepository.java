package com.flightadmin.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flightadmin.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String>{

	//List<Train> findByName(String string);

 

 

	 

	 

}