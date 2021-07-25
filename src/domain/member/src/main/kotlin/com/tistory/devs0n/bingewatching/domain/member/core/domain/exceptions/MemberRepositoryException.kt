package com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions

import com.tistory.devs0n.bingewatching.domain.member.common.exceptions.IntegrationException

class MemberRepositoryException(cause: Exception) : IntegrationException(cause)
