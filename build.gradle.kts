plugins {
    kotlin("jvm") version "2.3.20"
    kotlin("plugin.spring") version "2.3.20"
    id("org.springframework.boot") version "4.0.4-SNAPSHOT"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.ihletada"
version = "0.0.1-SNAPSHOT"
description = "fstest-2"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-flyway")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("io.github.wimdeblauwe:htmx-spring-boot-thymeleaf:5.0.0")
    implementation("org.flywaydb:flyway-database-postgresql")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-flyway-test")
    testImplementation("org.springframework.boot:spring-boot-starter-jdbc-test")
    testImplementation("org.springframework.boot:spring-boot-starter-thymeleaf-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(kotlin("stdlib"))
    implementation("com.github.f4b6a3:uuid-creator:5.3.5")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.1")

}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}


tasks.withType<Test> {
    useJUnitPlatform()

    jvmArgs(
        "-javaagent:${
            configurations.testRuntimeClasspath.get().files
                .first { it.name.contains("mockito-core") }
        }"
    )
}
