plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "mitconsult"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-mustache
	implementation("org.springframework.boot:spring-boot-starter-mustache:3.1.5")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.h2database:h2")
	compileOnly("org.projectlombok:lombok")
//	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-validation:3.1.5")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
