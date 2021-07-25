package com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions

import com.tistory.devs0n.bingewatching.domain.member.common.exceptions.InvalidDomainValueException

class MemberInvalidValueException(field: String, value: String) :
    InvalidDomainValueException("Member.$field", value)
