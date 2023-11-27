package com.erudio.model.entities.dto;

import com.erudio.model.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

    public PersonDto(Person person) {
        id = person.getId();
        firstName = person.getFirstName();
        lastName = person.getLastName();
        address = person.getAddress();
        gender = person.getGender();
    }
}
