package com.tistory.devs0n.bingewatching.domain.member.core.domain

import java.util.*

class MockMemberRepository : MemberRepository {
    private val members = mutableMapOf<UUID, Member>()

    fun clear() {
        this.members.clear()
    }

    override fun save(member: Member): Member {
        this.members[member.id] = member
        return member
    }

    override fun findById(id: UUID): Member? {
        return this.members[id]
    }

    override fun existsByUsername(username: String): Boolean {
        return this.members.values.any { it.username == username }
    }
}
