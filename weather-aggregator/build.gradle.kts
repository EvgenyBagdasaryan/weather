plugins {
    id("org.springframework.boot") version "2.7.12"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("java")
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
    // Зависимость для создания REST API с использованием Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Зависимость для использования Feign клиента
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.3")

    // Зависимость для мониторинга микросервиса
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Зависимость для работы с асинхронными запросами (опционально)
    //implementation("org.springframework.boot:spring-boot-starter-async")

    // Зависимость для тестирования
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.projectlombok:lombok:1.18.28")
}

tasks.test {
    useJUnitPlatform()
}