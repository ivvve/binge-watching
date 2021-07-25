package com.tistory.devs0n.bingewatching.domain.member

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication(scanBasePackageClasses = [DomainMemberModule::class])
class DomainMemberModule

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Import(DomainMemberModule::class)
annotation class EnableDomainMemberModule
