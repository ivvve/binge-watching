package com.tistory.devs0n.domain.content

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
class DomainContentModule

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(DomainContentModule::class)
annotation class EnableDomainContentModule
