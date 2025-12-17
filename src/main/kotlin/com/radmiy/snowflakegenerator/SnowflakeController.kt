package com.radmiy.snowflakegenerator

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

private val log: Logger = LoggerFactory.getLogger(SnowflakeController::class.java)

@RestController("/v1")
class SnowflakeController(private val generator: Generator) {
	@GetMapping("/next-id")
	suspend fun generate(): Long {
		log.info("Generating Snowflake ID")

		return generator.nextId()
	}
}
