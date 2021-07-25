package com.tistory.devs0n.bingewatching.domain.member.core.infrastructure

import com.tistory.devs0n.bingewatching.domain.member.core.domain.Member
import com.tistory.devs0n.bingewatching.domain.member.core.domain.MemberRepository
import com.tistory.devs0n.bingewatching.domain.member.core.domain.exceptions.MemberRepositoryException
import org.slf4j.LoggerFactory
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
internal class DataJdbcMemberRepository(
    private val repository: InternalDataJdbcMemberRepository
) : MemberRepository {
    override fun save(member: Member): Member {
        return wrapMemberRepositoryException {
            this.repository.save(member)
        }
    }

    override fun findById(id: String): Member? {
        return wrapMemberRepositoryException {
            this.repository.findById(id).orElse(null)
        }
    }

    override fun existsByUsername(username: String): Boolean {
        return wrapMemberRepositoryException {
            this.repository.existsByUsername(username)
        }
    }

    @Suppress("TooGenericExceptionCaught")
    private fun <RETURN> wrapMemberRepositoryException(function: () -> RETURN): RETURN {
        return try {
            function.invoke()
        } catch (exception: Exception) {
            LOGGER.debug("JdbcMemberRepository occurred exception - ${exception.message}")
            throw MemberRepositoryException(exception)
        }
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}

internal interface InternalDataJdbcMemberRepository : CrudRepository<Member, String> {
    fun existsByUsername(username: String): Boolean
}
