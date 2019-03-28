package com.kotlin.crudexample.person.mapper

import com.kotlin.crudexample.person.dto.PersonDto
import com.kotlin.crudexample.person.model.Person
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

@Component
class PersonMapper(private val modelMapper: ModelMapper) {

    fun from(person: Person) = modelMapper.map(person, PersonDto::class.java)

    fun to(personDto: PersonDto) = modelMapper.map(personDto, Person::class.java)

    fun fromList(personList: List<Person>): List<PersonDto> {
        val personDtoList = mutableListOf<PersonDto>()
        personList.forEach { personDtoList.add(from(it)) }
        return personDtoList
    }

    fun toList(personDtoList: List<PersonDto>): List<Person> {
        val personList = mutableListOf<Person>()
        personDtoList.forEach { personList.add(to(it)) }
        return personList
    }

}
