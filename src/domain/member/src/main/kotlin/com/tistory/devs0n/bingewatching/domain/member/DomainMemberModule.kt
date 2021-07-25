package com.tistory.devs0n.bingewatching.domain.member

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing

@SpringBootApplication(scanBasePackageClasses = [DomainMemberModule::class])
@EnableJdbcAuditing
class DomainMemberModule

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(DomainMemberModule::class)
annotation class EnableDomainMemberModule
