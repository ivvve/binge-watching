package com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions

import com.tistory.devs0n.bingewatching.domain.member.common.exceptions.InvalidDomainValueException
import com.tistory.devs0n.bingewatching.domain.member.core.domain.Member

class MemberInvalidValueException(field: String, value: String) :
    InvalidDomainValueException(Member.ENTITY_NAME, field, value)
