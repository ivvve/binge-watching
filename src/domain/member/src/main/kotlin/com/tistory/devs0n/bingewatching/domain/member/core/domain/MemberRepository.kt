package com.tistory.devs0n.bingewatching.domain.member.core.domain

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
    fun findById(id: String): Member?

    /**
     * @throws com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions.MemberRepositoryException
     * if fail to integrate with MemberRepository infrastructure
     */
    fun existsByUsername(username: String): Boolean
}
