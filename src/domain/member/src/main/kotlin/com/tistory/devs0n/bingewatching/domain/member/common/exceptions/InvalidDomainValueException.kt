package com.tistory.devs0n.bingewatching.domain.member.common.exceptions

open class InvalidDomainValueException(field: String, value: Any) :
    RuntimeException("Invalid domain value - $field: $value")
