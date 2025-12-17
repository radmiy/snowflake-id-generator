package com.radmiy.snowflakegenerator

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

private const val STARTING_EPOCH = 1L
private const val DATACENTER_ID = 1L
private const val WORKED_ID = 1L

private val log: Logger = LoggerFactory.getLogger(ApplicationConfig::class.java)

@Configuration
@ConfigurationProperties(prefix = "id-generator-settings")
open class ApplicationConfig {
	@Value(value = "\${id-generator-settings.starting-epoch}")
	var startingEpoch: Long = STARTING_EPOCH

	@Value(value = "\${id-generator-settings.datacenter-id}")
	val datasetId: Long = DATACENTER_ID

	@Value(value = "\${id-generator-settings.worked-id}")
	val workedId: Long = WORKED_ID

	@Bean
	open fun nextDeviceHandlerSenderProperties(): GeneratorSettings {
		log.info("startingEpoch: $startingEpoch, datasetId: $datasetId, workedId: $workedId")
		return GeneratorSettings(startingEpoch, datasetId, workedId)
	}
}
