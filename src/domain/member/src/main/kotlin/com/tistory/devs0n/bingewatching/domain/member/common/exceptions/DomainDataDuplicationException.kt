package com.tistory.devs0n.bingewatching.domain.member.common.exceptions

open class DomainDataDuplicationException(domainObjectName: String, field: String, value: Any) :
    RuntimeException("Domain data is duplicated - $domainObjectName.$field: $value")
