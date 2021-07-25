package com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions

import com.tistory.devs0n.bingewatching.domain.member.common.exceptions.DomainDataDuplicationException
import com.tistory.devs0n.bingewatching.domain.member.core.domain.Member

class MemberDomainDataDuplicationException(field: String, value: String) :
    DomainDataDuplicationException(Member.ENTITY_NAME, field, value)
