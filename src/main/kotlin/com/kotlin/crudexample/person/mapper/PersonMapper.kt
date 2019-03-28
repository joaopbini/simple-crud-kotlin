package com.kotlin.crudexample.person.mapper

import com.kotlin.crudexample.person.dto.PersonDto
import com.kotlin.crudexample.person.model.Person
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

@Component
class PersonMapper(private val modelMapper: ModelMapper) {

    fun toDto(person: Person): PersonDto = modelMapper.map(person, PersonDto::class.java)

    fun fromDto(personDto: PersonDto): Person = modelMapper.map(personDto, Person::class.java)

    fun toDtoList(personList: List<Person>): List<PersonDto> {
        val personDtoList = mutableListOf<PersonDto>()
        personList.forEach { personDtoList.add(toDto(it)) }
        return personDtoList
    }

    fun fromDtoList(personDtoList: List<PersonDto>): List<Person> {
        val personList = mutableListOf<Person>()
        personDtoList.forEach { personList.add(fromDto(it)) }
        return personList
    }

}
