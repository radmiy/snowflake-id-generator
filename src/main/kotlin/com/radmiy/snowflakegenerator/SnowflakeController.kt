package com.radmiy.snowflakegenerator

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/v1")
class SnowflakeController(private val generator: Generator) {
	@GetMapping("/next-id")
	suspend fun generate(): Long = generator.nextId()
}
