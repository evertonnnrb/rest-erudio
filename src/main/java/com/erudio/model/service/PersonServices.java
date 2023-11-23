package com.erudio.model.service;

import com.erudio.model.entities.Person;
import com.erudio.model.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class PersonServices {

    private final PersonRepository repository;
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(Long id) {
        logger.info("find by id");
        return repository.findById(id).orElseThrow();
    }

    public List<Person> getAll() {
        logger.info("list persons");
        return repository.findAll();
    }

    public Person add(Person person) {
        logger.info("create a person");
        return repository.save(person);
    }

    public Person update(Long id, Person person) {
        logger.info("update a person");
        Person personSaved = findById(id);
        BeanUtils.copyProperties(person, personSaved, "id");

        /*
        Person entity = findById(id);
        entity.setFirstname(person.getFirstname());
        entity.setLastname(person.getLastname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        */

        return repository.save(person);

    }

    public void delete(Long id) {
        logger.info("deleting a person");
        repository.deleteById(id);
    }
}
