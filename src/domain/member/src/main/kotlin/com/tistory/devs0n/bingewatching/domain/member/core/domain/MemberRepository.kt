package com.tistory.devs0n.bingewatching.domain.member.core.domain

import java.util.*

interface MemberRepository {
    /**
     * @throws com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions.MemberRepositoryException
     * if fail to integrate with MemberRepository infrastructure
     */
    fun save(member: Member): Member

    /**
     * @throws com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions.MemberRepositoryException
     * if fail to integrate with MemberRepository infrastructure
     */
    fun findById(id: UUID): Member?

    /**
     * @throws com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions.MemberRepositoryException
     * if fail to integrate with MemberRepository infrastructure
     */
    fun existsByUsername(username: String): Boolean
}
