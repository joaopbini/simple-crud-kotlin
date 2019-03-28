package com.kotlin.crudexample.person.repository

import com.kotlin.crudexample.person.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long> {

    fun findAllByNickname(nickname: String): List<Person>

}
