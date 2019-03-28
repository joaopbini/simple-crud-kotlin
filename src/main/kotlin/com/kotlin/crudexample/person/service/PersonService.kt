package com.kotlin.crudexample.person.service

import com.kotlin.crudexample.exception.PersonException
import com.kotlin.crudexample.person.dto.PersonDto
import com.kotlin.crudexample.person.mapper.PersonMapper
import com.kotlin.crudexample.person.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(private val personRepository: PersonRepository,
                    private val personMapper: PersonMapper) {

    fun findById(id: Long): PersonDto {

        val person = personRepository.findById(id).orElse(null)

        person?.let {
            return personMapper.toDto(person)
        }

        throw PersonException("Person not found!")
    }

    fun create(personDto: PersonDto): PersonDto {
        val person = personMapper.fromDto(personDto)
        return personMapper.toDto(personRepository.save(person))
    }

    fun update(personDto: PersonDto): PersonDto {

        if (!personRepository.findById(personDto.id).isPresent) {
            throw PersonException("Person not found!")
        }

        return personMapper.toDto(personRepository.save(personMapper.fromDto(personDto)))
    }

    fun delete(id: Long) {

        val person = personRepository.findById(id).orElse(null)

        person?.let {
            personRepository.delete(person)
        }
    }

    fun findByNickname(nickname: String): List<PersonDto> {
        val listPerson = personRepository.findAllByNickname(nickname)
        return personMapper.toDtoList(listPerson)
    }

}
