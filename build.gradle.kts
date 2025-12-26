import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.4.6"
	id("org.jlleitschuh.gradle.ktlint") version libs.versions.gradle.ktlint
	id("io.gitlab.arturbosch.detekt") version libs.versions.gradle.detekt
	kotlin("jvm") version libs.versions.kotlin
}

apply(plugin = "io.spring.dependency-management")

group = "com.radmiy"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.kotlin.stdlib)
	implementation(libs.kotlinx.coroutines)
	implementation(libs.springframework.boot.starter.web)
	implementation(libs.springframework.boot.starter.actuator)
	implementation("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("io.projectreactor:reactor-core")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.postgresql:postgresql")
	implementation("org.liquibase:liquibase-core")
	testImplementation(libs.junit.jupiter)
	testImplementation(libs.assertj.core)
	testImplementation(libs.kotlinx.coroutines.test)
	testImplementation("io.mockk:mockk:1.13.13")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
