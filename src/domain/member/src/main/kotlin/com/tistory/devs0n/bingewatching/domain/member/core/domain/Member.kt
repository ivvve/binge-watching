package com.tistory.devs0n.bingewatching.domain.member.core.domain

import com.tistory.devs0n.bingewatching.domain.member.common.entity.UUIDEntity
import com.tistory.devs0n.bingewatching.domain.member.common.utils.hasLengthBetween
import com.tistory.devs0n.bingewatching.domain.member.common.utils.hasSpace
import com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions.MemberInvalidValueException
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("members")
class Member : UUIDEntity {
    @Column("username")
    var username: String

    private constructor(username: String) : super() {
        this.validateUsername(username)
        this.username = username
    }

    private fun validateUsername(username: String) {
        if (username.hasSpace() ||
            username.isBlank() ||
            !username.hasLengthBetween(USERNAME_MIN_LENGTH, USERNAME_MAX_LENGTH)
        ) {
            throw MemberInvalidValueException("username", username)
        }
    }

    companion object {
        val ENTITY_NAME: String = Member::class.java.simpleName

        const val USERNAME_MAX_LENGTH = 20
        const val USERNAME_MIN_LENGTH = 4

        fun new(username: String): Member {
            return Member(username)
                .apply { this.new = true }
        }
    }
}
