package com.radmiy.snowflakegenerator

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.nio.charset.Charset
import java.util.zip.CRC32

private const val STARTING_EPOCH = 1L
private const val EMPTY_STR = ""
private const val LENGTH_5_BIT = 32

private val log: Logger = LoggerFactory.getLogger(ApplicationConfig::class.java);

@Configuration
open class ApplicationConfig {

	@Value(value = "\${snowflake-settings.starting-epoch}")
	var startingEpoch: Long = STARTING_EPOCH

	@Value(value = "\${snowflake-settings.datacenter-id}")
	val datasetId: String = EMPTY_STR

	@Value(value = "\${snowflake-settings.worked-id}")
	val workedId: String = EMPTY_STR

	@Bean
	open fun nextDeviceHandlerSenderProperties(): GeneratorSettings {
		log.info("startingEpoch: $startingEpoch, datasetId: $datasetId, workedId: $workedId")
		return GeneratorSettings(startingEpoch, generateIdFromString(datasetId), generateIdFromString(workedId))
	}

	private fun generateIdFromString(inputString: String): Long {
		if (inputString.isEmpty()) {
			return 0L
		}


		val crc32 = CRC32()
		crc32.update(inputString.toByteArray(Charset.forName("UTF-8")))

		var result = crc32.value % LENGTH_5_BIT
		if (result == 0L) {
			result += 1L
		}
		log.info("hash: $result")

		return result
	}
}
