package com.kotlin.crudexample.exception.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.validation.FieldError
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
class ValidationValidDto(status: Int?, message: String, fieldErrors: List<FieldError>) {

    var status: Int? = null

    var message: String? = null

    var fieldErrors: List<FieldDto>? = null

    init {
        prepare(status, message, fieldErrors)
    }

    private fun prepare(status: Int?, message: String, fieldErrorList: List<FieldError>) {

        val fieldErrorsList: MutableList<FieldDto> = ArrayList()

        for (fieldError in fieldErrorList) {
            val field = FieldDto(fieldError.field, fieldError.defaultMessage ?: "Invalid input!")
            fieldErrorsList.add(field)
        }

        this.status = status
        this.message = message
        this.fieldErrors = fieldErrorsList

    }

}
