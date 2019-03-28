package com.kotlin.crudexample.person.service

import com.kotlin.crudexample.person.dto.PersonDto
import com.kotlin.crudexample.person.mapper.PersonMapper
import com.kotlin.crudexample.person.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(private val personRepository: PersonRepository,
                    private val personMapper: PersonMapper) {

    fun findById(id: Long) = personMapper.from(personRepository.findById(id).get())

    fun create(personDto: PersonDto) = personMapper.from(personRepository.save(personMapper.to(personDto)))

    fun update(personDto: PersonDto): PersonDto {

        if (!personRepository.findById(personDto.id).isPresent) {
            throw RuntimeException("Erroooou")
        }

        return personMapper.from(personRepository.save(personMapper.to(personDto)))
    }

    fun delete(id: Long) {

        val person = personRepository.findById(id).get()

        personRepository.delete(person)
    }

    fun findByNickname(nickname: String): List<PersonDto> {
        return personMapper.fromList(personRepository.findAllByNickname(nickname))
    }

}
