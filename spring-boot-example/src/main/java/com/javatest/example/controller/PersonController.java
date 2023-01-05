package com.javatest.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatest.example.dto.PersonVO;
import com.javatest.example.repository.PersonVORepository;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired 
    PersonVORepository personRepo;
    
    /**
     * <p>Get all person data in the system.For production system you many want to use
     * pagination.</p>
     * @return List<PersonVO>
     */
	@GetMapping
    public List<PersonVO> getPersons(){
    	Iterable<PersonVO> it = personRepo.findAll();
    	List<PersonVO> listPerson = new ArrayList<PersonVO>();
    	it.forEach(listPerson::add);
    	
    	return listPerson;
    }
    
    /**
     * Method to get the customer data based on the ID.
     * @param id
     * @return PersonVO
     */
    @GetMapping("/person/{id}")
    public PersonVO getCustomer(@PathVariable Long id){
    	
        Optional<PersonVO> person = Optional.ofNullable(personRepo.findById(id).get());
        if (person.isPresent()) {
            System.out.println(person.get());
            return person.get();
        } else {
            System.out.println("Name is null.");
        }
    	
    	return null;
    }

}
