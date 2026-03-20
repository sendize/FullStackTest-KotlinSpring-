package com.ihletada.fullstackapp

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.support.NoOpTaskScheduler

@TestConfiguration
class TestConfig {
    @Bean
    fun taskScheduler(): TaskScheduler {
        println("Disabling scheduled tasks")
        return NoOpTaskScheduler()  // Disables scheduled tasks
    }
}

@SpringBootTest
class Fstest2ApplicationTests {


//    @Test
//    fun contextLoads() {
//
//    }

}
