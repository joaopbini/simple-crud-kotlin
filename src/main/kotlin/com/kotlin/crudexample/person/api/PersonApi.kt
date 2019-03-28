package com.kotlin.crudexample.person.api

import com.kotlin.crudexample.person.dto.PersonDto
import com.kotlin.crudexample.person.service.PersonService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/person")
class PersonApi(private val personService: PersonService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): PersonDto {
        return personService.findById(id)
    }

    @PostMapping
    fun create(@Valid @RequestBody personDto: PersonDto): PersonDto {
        return personService.create(personDto)
    }

    @PutMapping
    fun update(@Valid @RequestBody personDto: PersonDto): PersonDto {
        return personService.update(personDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        personService.delete(id)
    }

    @GetMapping("/nickname/{nickname}")
    fun findByNickname(@PathVariable("nickname") nickname: String): List<PersonDto> {
        return personService.findByNickname(nickname)
    }

}