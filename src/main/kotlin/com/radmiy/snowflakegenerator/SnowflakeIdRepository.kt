package com.radmiy.snowflakegenerator

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SnowflakeIdRepository : JpaRepository<SnowflakeId, Long>
