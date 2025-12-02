package com.radmiy.snowflakegenerator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SnowflakeApplication

fun main(vararg args: String) {
	runApplication<SnowflakeApplication>(*args)
}
