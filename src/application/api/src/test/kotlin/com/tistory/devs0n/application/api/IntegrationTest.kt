package com.tistory.devs0n.application.api

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.transaction.annotation.Transactional
import org.testcontainers.containers.MySQLContainer

@Suppress("UtilityClassWithPublicConstructor") // ignore detekt rule
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class IntegrationTest {
    companion object {
        private val mysqlContainer = MySQLContainer<Nothing>("mysql:8.0").apply {
            withCommand("mysqld", "--character-set-server=utf8mb4")
            withInitScript("migrations/V1.sql")
            start()
        }

        @JvmStatic
        @DynamicPropertySource
        fun registerProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl)
            registry.add("spring.datasource.username", mysqlContainer::getUsername)
            registry.add("spring.datasource.password", mysqlContainer::getPassword)
        }
    }
}
