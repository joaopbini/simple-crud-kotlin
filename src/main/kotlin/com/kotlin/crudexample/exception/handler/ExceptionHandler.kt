package com.kotlin.crudexample.exception.handler

import com.kotlin.crudexample.exception.dto.ValidationValidDto
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

@ControllerAdvice(annotations = [RestController::class])
class ExceptionHandler {

    private val log = LoggerFactory.getLogger(ExceptionHandler::class.java.name)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<*> {
        log.error(e.message, e)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ValidationValidDto(HttpStatus.BAD_REQUEST.value(), INVALID_VALUE, e.bindingResult.fieldErrors))
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException): ResponseEntity<*> {
        log.error(e.message, e)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(REQUIRED_VALUE)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<*> {
        log.error(e.message, e)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.message)
    }

}

private const val INVALID_VALUE = "Invalid value"
private const val REQUIRED_VALUE = "This value is required"
