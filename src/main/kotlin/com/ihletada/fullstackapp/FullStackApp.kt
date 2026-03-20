package com.ihletada.fullstackapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import io.github.cdimascio.dotenv.dotenv

@SpringBootApplication
@EnableScheduling
class FullStackApp

fun main(args: Array<String>) {
    val dotenv = dotenv {
        systemProperties = true
        ignoreIfMissing = true
    }

    runApplication<FullStackApp>(*args)
}

