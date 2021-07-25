package com.tistory.devs0n.bingewatching.domain.member.common.exceptions

open class InvalidDomainValueException(domainObjectName: String, field: String, value: Any) :
    RuntimeException("Invalid domain value - $domainObjectName.$field: $value")
