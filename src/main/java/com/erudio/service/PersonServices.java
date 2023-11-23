package com.erudio.service;

import com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong aLong = new AtomicLong(0);
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(Long id) {
        logger.info("find by id");
        Person person = new Person(aLong.incrementAndGet(), "Mohamed", "Ali", "California", "Male");
        return person;
    }

    public List<Person> getAll() {
        logger.info("list persons");
        return Arrays.asList(new Person(aLong.incrementAndGet(), "Ayn", "Rand", "Suiça", "Female"),
                new Person(aLong.incrementAndGet(), "Ronaldo", "Fenomeno", "BH", "Male"),
                new Person(aLong.incrementAndGet(), "Nelson", "Mandela", "Africa do sul", "Male"),
                new Person(aLong.incrementAndGet(), "Dagni", "Tagard", "EUA", "Female"));
    }

    public Person add(Person person){

        logger.info("create a person");
        return person;
    }

    public Person update(Long id) {
        logger.info("update a person");
        return new Person();
    }

    public void delete(Long id) {
        logger.info("deleting a person");
    }
}
