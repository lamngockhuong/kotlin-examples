import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.23"
}

group = "com.ngockhuong"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:3.2.4")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("com.google.zxing:core:3.5.3")
	implementation("com.google.zxing:javase:3.5.3")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.4")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
