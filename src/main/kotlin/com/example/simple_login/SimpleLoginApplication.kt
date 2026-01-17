package com.example.simple_login

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleLoginApplication

fun main(args: Array<String>) {
	runApplication<SimpleLoginApplication>(*args)
}
