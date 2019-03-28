package com.kotlin.crudexample.person.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Person(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        var name: String = "",

        var nickname: String = "",

        var age: Int = 0

)
