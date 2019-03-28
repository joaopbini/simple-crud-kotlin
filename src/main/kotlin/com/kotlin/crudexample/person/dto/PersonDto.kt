package com.kotlin.crudexample.person.dto

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PersonDto(

        var id: Long = 0,

        @get:NotEmpty
        @get:Length(min = 3, max = 200)
        var name: String = "",

        var nickname: String = "",

        @get:NotNull
        @get:Min(0)
        var age: Int = 0

)
