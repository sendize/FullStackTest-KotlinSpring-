package com.ihletada.fstest2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import io.github.cdimascio.dotenv.dotenv

@SpringBootApplication
@EnableScheduling
class Fstest2Application

fun main(args: Array<String>) {
    val dotenv = dotenv {
        systemProperties = true
        ignoreIfMissing = false
    }

    runApplication<Fstest2Application>(*args)
}

