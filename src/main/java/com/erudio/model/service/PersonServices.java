package com.erudio.model.service;

import com.erudio.exceptions.ResourceNotFoundExcetion;
import com.erudio.model.entities.Person;
import com.erudio.model.entities.dto.PersonDto;
import com.erudio.model.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class PersonServices {

    private final PersonRepository repository;
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public PersonDto findById(Long id) {
        logger.info("find by id");
        Person person = repository.findById(id).orElseThrow();
        return new PersonDto(person);
    }

    public List<Person> getAll() {
        logger.info("list persons");
        return repository.findAll();
    }

    public PersonDto add(PersonDto personDto) {
        logger.info("create a person");
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setGender(personDto.getGender());
        person.setAddress(personDto.getAddress());
        person = repository.save(person);
        return new PersonDto(person);
    }

    public PersonDto update(Long id, PersonDto dto) {
        logger.info("update a person");
        Person person = repository.getReferenceById(id);
        try {
            person.setFirstName(dto.getFirstName());
            person.setLastName(dto.getLastName());
            person.setGender(dto.getGender());
            person.setAddress(dto.getAddress());
            person = repository.save(person);
            return new PersonDto(person);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundExcetion("No entity found for this id " + id);
        }

    }

    public void delete(Long id) {
        logger.info("deleting a person");
        repository.deleteById(id);
    }

    public Page<PersonDto> findAllPaged(PageRequest pageRequest) {
        Page<Person> all = repository.findAll(pageRequest);
        return all.map(PersonDto::new);
    }
}
