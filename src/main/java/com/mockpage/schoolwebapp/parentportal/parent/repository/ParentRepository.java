package com.mockpage.schoolwebapp.parentportal.parent.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;

import com.mockpage.schoolwebapp.parentportal.parent.model.Parent;

public interface ParentRepository extends CrudRepository<Parent,Long>{

	public Optional<Parent> findById(Long id);
	
	public Parent findByFirstName(String firstName);

	public Parent findBystudentId(String sid);

	public boolean existsBystudentId(@Valid String sid);
}