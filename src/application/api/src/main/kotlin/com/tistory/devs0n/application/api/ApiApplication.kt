package com.tistory.devs0n.application.api

import com.tistory.devs0n.bingewatching.domain.member.EnableDomainMemberModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableDomainMemberModule
class ApiApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
