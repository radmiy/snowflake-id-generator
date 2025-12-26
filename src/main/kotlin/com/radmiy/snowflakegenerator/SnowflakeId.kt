package com.radmiy.snowflakegenerator

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.OffsetDateTime

@Entity
@Table(name = "snowflakeid")
data class SnowflakeId(
	@Id
	@Column(name = "guid")
	val guid: Long,

	@Column(name = "created_at")
	val createdAt: OffsetDateTime,

	@Column(name = "datacenter_id")
	val datacenterId: Int,

	@Column(name = "worked_id")
	val workedId: Int,
) {
	constructor() : this(1L, OffsetDateTime.now(), 0, 0)
}
